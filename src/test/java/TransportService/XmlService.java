package TransportService;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class XmlService {
    private String filePath;
    private Document doc;
    private String existingElementValue;

    public XmlService(String xmlFile) {
        this.filePath = xmlFile;
    }
    private static Logger Log = Logger.getLogger(XmlService.class.getName());
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private Node createConfigElement(String name, String value) {
        Node configNode = doc.createElement("ConfigElement");
        Element elementName = doc.createElement("ElementName");
        Element elementValue = doc.createElement("ElementValue");
        elementName.appendChild(doc.createTextNode(name));
        elementValue.appendChild(doc.createTextNode(value));
        configNode.appendChild(elementName);
        configNode.appendChild(elementValue);
        return configNode;
    }

    private void writeXml() {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (TransformerException tfe) {
            tfe.getStackTrace();
        }
    }

    private void initDocument() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            this.doc = docBuilder.parse(filePath);
            Log.info("XML was parsed");

        } catch (ParserConfigurationException | IOException  | SAXException e) {
        }
    }

    public void addToXmlFile(String elementName, String elementValue) {
        initDocument();
        getExistingConfigElementValue(elementName, elementValue);
        if (!modifyExistingConfigElement(elementName, elementValue)) {
            appendToConfigNode(createConfigElement(elementName, elementValue));
        }
        writeXml();
    }

    private void appendToConfigNode(Node node) {
        Node configNode = doc.getElementsByTagName("Config").item(0);
        configNode.appendChild(node);
    }

    private boolean modifyExistingConfigElement(String elementName, String elementValue) {
        NodeList elementNameList = doc.getElementsByTagName("ElementName");
        for (int i=0; i < elementNameList.getLength(); i++) {
            if (elementNameList.item(i).getTextContent().equals(elementName)) {
                doc.getElementsByTagName("ElementValue").item(i).setTextContent(elementValue);
                Log.info("Config file was updated.");
                return true;
            }
        }
        return false;
    }

    private String getExistingConfigElementValue(String elementName, String elementValue) {
        NodeList elementNameList = doc.getElementsByTagName("ElementName");
        for (int i=0; i < elementNameList.getLength(); i++) {
            if (elementNameList.item(i).getTextContent().equals(elementName)) {
                existingElementValue = doc.getElementsByTagName("ElementValue").item(i).getTextContent();
                Log.info("Existing Element value for "+elementName+ " is " +existingElementValue);
                return existingElementValue;
            }
        }
        return existingElementValue;
    }

    public boolean restoreExistingElemetValue(String elementName, String elementValue) {
        initDocument();
        System.out.println(existingElementValue);
        NodeList elementNameList = doc.getElementsByTagName("ElementName");
        for (int i=0; i < elementNameList.getLength(); i++) {
            if (elementNameList.item(i).getTextContent().equals(elementName)) {
                doc.getElementsByTagName("ElementValue").item(i).setTextContent(existingElementValue);
                Log.info("Config file was restored.");
                return true;
            }
        }
        return false;
    }


       /* public void restoreBackup() {
            File backupFile = new File(filePath+".backup");
            File modifiedFile = new File(filePath);
            modifiedFile.delete();
            backupFile.renameTo(modifiedFile);
        }*/
}
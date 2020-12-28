package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties pro;

    public ReadConfig(String path)
    {
        File src = new File(path);

        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getValue(String value){
        String val = pro.getProperty(value);
        return val;
    }

    public String getApplicationURL()
    {
        String url=pro.getProperty("baseURL");
        return url;
    }
    public String getPan()
    {
        String pan=pro.getProperty("pan");
        return pan;
    }

    public String getRegion(){
        String region=pro.getProperty("region");
        return region;
    }

    public String getUsername()
    {
        String username=pro.getProperty("username");
        return username;
    }

    public String getPassword()
    {
        String password=pro.getProperty("password");
        return password;
    }

    public String getChromePath()
    {
        String chromepath=pro.getProperty("chromepath");
        return chromepath;
    }

    public String getIEPath()
    {
        String iepath=pro.getProperty("iepath");
        return iepath;
    }

    public String getFirefoxPath()
    {
        String firefoxpath=pro.getProperty("firefoxpath");
        return firefoxpath;
    }


}
package PageObject;

import BaseFramework.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OOBPage extends BaseClass {

    public String OobInfoText() {
        waitForElementToAppear(By.xpath("//*[@id=\"info-text\"]"));
        highLightElement(driver, By.xpath("//*[@id=\"info-text\"]"));
        String bodyText = getText(driver, By.xpath("//*[@id=\"info-text\"]"));
        return bodyText;
    }

    public String whyinfotextText() throws InterruptedException {
        waitForElementToAppear(By.xpath("//*[@id=\"why-info-label\"]"));
        clickElement(By.xpath("//*[@id=\"why-info-label\"]"));
        highLightElement(driver, By.xpath("//*[@id='why-info-text']"));
        String bodyText = getText(driver, By.xpath("//*[@id='why-info-text']"));
        clickElement(By.xpath("//*[@id=\"why-info-label\"]"));
        return bodyText;
    }

    public String whyinfolabelText(){
        waitForElementToAppear(By.xpath("//*[@id=\"why-info-label\"]"));
        highLightElement(driver, By.xpath("//*[@id=\"why-info-label\"]"));
        String bodyText = getText(driver, By.xpath("//*[@id=\"why-info-label\"]"));
        return bodyText;
    }

    public String submitlabelTextOnOOBPage(){
        waitForElementToAppear(By.xpath("//*[@id=\"continue\"]"));
        highLightElement(driver, By.xpath("//*[@id=\"continue\"]"));
        String bodyText = getText(driver, By.xpath("//*[@id=\"continue\"]"));
        return bodyText;
    }
}
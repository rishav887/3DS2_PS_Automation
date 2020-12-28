package PageObject;

import BaseFramework.BaseClass;
import org.openqa.selenium.By;

public class SMSPage extends BaseClass {

    public String infoText(){
        waitForElementToAppear(By.xpath("//*[@id=\"info-text\"]"));
        highLightElement(driver, By.xpath("//*[@id=\"info-text\"]"));
        String bodyText = getText(driver, By.xpath("//*[@id=\"info-text\"]"));
        return bodyText;
    }

    public String whyinfotextText() throws InterruptedException {
        waitForElementToAppear(By.xpath("//*[@id=\"why-info-label\"]"));
        clickElement(By.xpath("//*[@id=\"why-info-label\"]"));
        highLightElement(driver,By.xpath("//*[@id='why-info-text']") );
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

    public void sendOTP(String value, String ReportComment){
        waitForElementToAppear(By.id("dataEntry"));
        test.info(ReportComment);
        sendKey(driver, By.id("dataEntry"), value);
    }

    public String submitlabelTextOnSmsPage(){
        waitForElementToAppear(By.xpath("//*[@id=\"submit-label\"]"));
        highLightElement(driver, By.xpath("//*[@id=\"submit-label\"]"));
        String bodyText = getText(driver, By.xpath("//*[@id=\"submit-label\"]"));
        return bodyText;
    }


    public String resendLabelText(){
        waitForElementToAppear(By.xpath("//*[@id=\"resend-label\"]"));
        highLightElement(driver, By.xpath("//*[@id=\"resend-label\"]"));
        String bodyText = getText(driver, By.xpath("//*[@id=\"resend-label\"]"));
        return bodyText;
    }

    public void clickSubmitButton(String ReportComment) throws InterruptedException {
        test.info(ReportComment);
        waitForElementToAppear(By.xpath("//*[@id=\"submit-label\"]"));
        clickElement(By.xpath("//*[@id=\"submit-label\"]"));
        Thread.sleep(10000);
        ngDriver.waitForAngularRequestsToFinish();
    }

    public String resendWhyInforTextAfterResendClick() throws InterruptedException {
        waitForElementToAppear(By.xpath("//*[@id=\"resend-label\"]"));
        clickElement(By.xpath("//*[@id=\"resend-label\"]"));
        Thread.sleep(5000);
        String bodyText = getText(driver, By.xpath("//*[@id=\"info-text\"]"));
        return bodyText;
    }

    public String ErrorWhyInforTextAfterIncorrectOtp() {
        waitForElementToAppear(By.xpath("//*[@id=\"info-text\"]"));
        highLightElement(driver, By.xpath("//*[@id=\"info-text\"]"));
        String bodyText = getText(driver, By.xpath("//*[@id=\"info-text\"]"));
        return bodyText;
    }
}
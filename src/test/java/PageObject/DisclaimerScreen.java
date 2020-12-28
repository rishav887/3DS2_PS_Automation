package PageObject;

import BaseFramework.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class DisclaimerScreen extends BaseClass {

    public void selectChallengeOptions(String text, String ReportComment) throws InterruptedException {
        test.info(ReportComment);
        try{
        for(int i =1; i <4; i++) {
           String Option = driver.findElement(By.xpath("/html/body/form/div/div[4]/div/label[" + i + "]/span")).getText();
           if(Option.contains(text)){
               driver.findElement(By.xpath("/html/body/form/div/div[4]/div/label[" + i + "]/input")).click();
               break;
           }
        }
    } catch (Exception e){
            driver.findElement(By.xpath("/html/body/form/div/div[4]/div/div[1]")).click();
            for(int i =1; i <4; i++) {
                Thread.sleep(1000);
                WebElement el = driver.findElement(By.xpath("/html/body/form/div/div[4]/div/div[2]/div["+i+"]"));
                String expected = el.getText();
                if(expected.contains(text)) {
                   driver.findElement(By.xpath("/html/body/form/div/div[4]/div/div[2]/div["+i+"]")).click();
                   break;
            }
        }
    }
    }

    public void clickSubmit() throws IOException {
        try {
            waitForElementToAppear(By.xpath("//*[@id='submit-label']"));
            driver.findElement(By.xpath("//*[@id='submit-label']")).click();
            ngDriver.waitForAngularRequestsToFinish();
            logger.info("Submit button clicked.");
            test.info("Submit button clicked.");
        }catch(Exception e){
            logger.error("Unable to find/click submit button.");
            test.fail("Submit button clicked.");
            captureScreen("SubmitButton");
        }
    }

    public String infoText(){
        waitForElementToAppear( By.xpath("//*[@id='info-text']"));
        highLightElement(driver, By.xpath("//*[@id='info-text']"));
        String bodyText = getText(driver, By.xpath("//*[@id='info-text']"));
        return bodyText;
    }

    public String whyinfotextText() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementToAppear(By.xpath("//*[@id=\"why-info-label\"]"));
        clickElement(By.xpath("//*[@id=\"why-info-label\"]"));
        highLightElement(driver, By.xpath("//*[@id='why-info-text']"));
        String bodyText = getText(driver, By.xpath("//*[@id='why-info-text']"));
        clickElement(By.xpath("//*[@id=\"why-info-label\"]"));
        return bodyText;
    }

    public String whyinfolabelText(){
        waitForElementToAppear(By.xpath("//*[@id=\"why-info-label\"]"));
        String bodyText = getText(driver, By.xpath("//*[@id=\"why-info-label\"]"));
        return bodyText;
    }

    public String submitlabelText(){
        waitForElementToAppear(By.xpath("//*[@id=\"submit-label\"]"));
        highLightElement(driver,By.xpath("//*[@id=\"submit-label\"]") );
        String bodyText = getText(driver, By.xpath("//*[@id=\"submit-label\"]"));
        return bodyText;
    }

}

package BaseFramework;

import Utils.ReadConfig;
import Utils.Report;
import com.paulhammant.ngwebdriver.NgWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass extends Report {
    public static String cw = System.getProperty("user.dir");
    private ReadConfig readconfig=new ReadConfig("./config/config.properties");
    public Logger logger = Logger.getLogger("3DS_PsAutomation");
    protected static WebDriver driver;
    protected WebDriverWait wait ;
    protected static NgWebDriver ngDriver;

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser)
    {
        PropertyConfigurator.configure("log4j.properties");
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
          //  options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }
         if(browser.equalsIgnoreCase("firefox")){
             System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
             WebDriverManager.firefoxdriver().setup();
             FirefoxOptions options = new FirefoxOptions();
            // options.addArguments("--headless");
             options.addArguments("--disable-gpu");
             options.addArguments("--start-maximized");
             driver = new FirefoxDriver(options);
         }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(readconfig.getApplicationURL());
        logger.info("Opening URL QA130.");
        //driver.manage().window().fullscreen();
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        ngDriver.waitForAngularRequestsToFinish();
    }


    @AfterClass
    public void afterClass() {
        try{
            if(driver!=null) {
                driver.close();
            } }catch(Exception e){
            System.out.println("Driver is closed - therefore AfterTest skipped.");
        }
    }

  /*  @AfterTest
    public void afters(){
     try{
        if(driver!=null) {
         driver.quit();
     } }catch(Exception e){
         System.out.println("Driver is closed - therefore AfterTest skipped.");
        }
    }*/


    public void captureScreen(String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    protected void waitForElementToAppear(By locator) {
        wait = new  WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToDisappear(By locator) {
        wait = new  WebDriverWait(driver,30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait = new  WebDriverWait(driver,30);
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }

    protected void clickElement(By locator) throws InterruptedException {
        Thread.sleep(2000);
        wait = new  WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    protected  String getText(WebDriver driver, By locator){
       String text =  driver.findElement(locator).getText();
       return text;
    }

    protected void assertToCompareString(String getTextFromPage, String valueFromPropFile, String ReportComment) {
       try{
            test.info(ReportComment);
         if (getTextFromPage.contains(valueFromPropFile)){
         //if(StringUtils.contains(getTextFromPage, valueFromPropFile)){
            Assert.assertTrue(true);
            logger.info("Text matches the expected value. -- " +valueFromPropFile);
            test.info("Text matches the expected value.");
        } else {
            logger.error("Text doesnt matches the expected value. -- " +valueFromPropFile);
            test.fail("Text doesnt matches the expected value --[ACTUAL] "+ getTextFromPage + " [EXPECTED] "+valueFromPropFile);
        }
         }catch(Exception e) {
            logger.error("Text doesnt matches the expected value. -- " +valueFromPropFile);
            test.fail("Text doesnt matches the expected value.");
        }
    }

    protected  void sendKey(WebDriver driver, By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    protected  void selectByVisibleText(String text){
        driver.findElement(By.partialLinkText(text)).click();
    }


    public static void highLightElement(WebDriver driver, By by)
    {
        WebElement element = driver.findElement(by);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
    }

}
package PageObject;

import BaseFramework.BaseClass;
import TransportService.SshImplimentation;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BaseClass {
   private SshImplimentation server= new SshImplimentation();

    public void login(String pan, String region) throws InterruptedException {
        server.CleanDB(region);
        driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/app-fields-block/table/tr[3]/td[2]/input")).clear();
        test.info("Pan used for the test :"+pan);
        driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/app-fields-block/table/tr[3]/td[2]/input")).sendKeys(pan);
        driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/app-fields-block/table/tr[2]/td[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/app-fields-block/table/tr[2]/td[2]/input")).sendKeys("Challenge");
        Select sel = new Select(driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/app-fields-block/table/tr[1]/td[2]/select")));
        sel.selectByVisibleText("Browser");
        Select sel2 = new Select(driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/app-fields-block/table/tr[8]/td[2]/select")));
        sel2.selectByVisibleText("02 - 390x400");
        driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/input")).click();
        Thread.sleep(10000);
        driver.switchTo().frame(driver.findElement(By.className("challenge-iframe")));
        Thread.sleep(5000);

    }

    public void decline(String pan) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/app-fields-block/table/tr[3]/td[2]/input")).clear();
        test.info("Pan used for the test :"+pan);
        driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/app-fields-block/table/tr[3]/td[2]/input")).sendKeys(pan);
        driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/app-fields-block/table/tr[2]/td[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/app-fields-block/table/tr[2]/td[2]/input")).sendKeys("decline");
        Select sel = new Select(driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/app-fields-block/table/tr[1]/td[2]/select")));
        sel.selectByVisibleText("Browser");
        Select sel2 = new Select(driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/app-fields-block/table/tr[8]/td[2]/select")));
        sel2.selectByVisibleText("02 - 390x400");
        driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/input")).click();
        Thread.sleep(12000);

    }

    public void allow(String pan) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/app-fields-block/table/tr[3]/td[2]/input")).clear();
        test.info("Pan used for the test :"+pan);
        driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/app-fields-block/table/tr[3]/td[2]/input")).sendKeys(pan);
        driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/app-fields-block/table/tr[2]/td[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/app-fields-block/table/tr[2]/td[2]/input")).sendKeys("allow");
        Select sel = new Select(driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/app-fields-block/table/tr[1]/td[2]/select")));
        sel.selectByVisibleText("Browser");
        Select sel2 = new Select(driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/app-fields-block/table/tr[8]/td[2]/select")));
        sel2.selectByVisibleText("02 - 390x400");
        driver.findElement(By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[1]/app-basic-areq/input")).click();
        Thread.sleep(12000);
    }




}

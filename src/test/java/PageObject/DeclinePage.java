package PageObject;

import BaseFramework.BaseClass;
import org.openqa.selenium.By;

public class DeclinePage extends BaseClass {

     public  String declineText(){
         String declineText = getText(driver, By.xpath("/html/body/app-root/app-landing-page/div/app-basic-view/div[2]/app-ares/ngb-accordion/div/div[2]/app-fields-block/table/tr[3]/td[2]/div"));
         return declineText;

}
}

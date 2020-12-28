package TestCase;

import BaseFramework.BaseClass;
import PageObject.LoginPage;
import Utils.ReadConfig;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC_NEW_TrialTest extends BaseClass {

    @Test(enabled = true)
     public void lointest() throws IOException, InterruptedException {
        test = extent.createTest("TC_Trial");
        if(false){
            test.error("error");

        }
        System.out.println("test");
}
}

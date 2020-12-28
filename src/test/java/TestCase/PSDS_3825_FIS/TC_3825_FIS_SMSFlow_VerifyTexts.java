package TestCase.PSDS_3825_FIS;

import Flows.TransactionFlows;
import PageObject.*;
import Utils.ReadConfig;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC_3825_FIS_SMSFlow_VerifyTexts extends TransactionFlows implements PageObjects {
    private ReadConfig readconfig=new ReadConfig(cw+"\\src\\test\\java\\TestData\\fisp_3825.properties");

    @Test(priority = 0, enabled = true)
        public void LoginUsingPanSMSFlow() throws InterruptedException, IOException {
        CheckDisclaimerPage_SMS_Having_WhyinfoText("TC_3825_FIS-Verifying text on SMS", readconfig);
    }

    @Test(priority = 1, dependsOnMethods = {"LoginUsingPanSMSFlow"}, enabled = true)
    public void SmsFlow() throws IOException, InterruptedException {
        CheckSmsPage_Having_WhyInfoText(readconfig);
    }
}
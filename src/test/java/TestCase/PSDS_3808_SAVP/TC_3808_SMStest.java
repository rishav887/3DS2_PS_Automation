package TestCase.PSDS_3808_SAVP;

import Flows.TransactionFlows;
import PageObject.PageObjects;
import Utils.ReadConfig;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC_3808_SMStest extends TransactionFlows implements PageObjects {
    private ReadConfig readconfig = new ReadConfig(cw + "\\src\\test\\java\\TestData\\savp_3808.properties");

    @Test(priority = 0)
    public void LoginUsingSms() throws InterruptedException, IOException {
        CheckDisclaimerPage_SMS_Not_Having_WhyinfoText("TC_3808_SMS-Verify Login in SMS flow", readconfig);
    }

    @Test(priority = 1)
    public void SmsPageOtpCheck() throws InterruptedException {
        CheckSmsPage_Not_Having_WhyinfoText(readconfig);
    }
}

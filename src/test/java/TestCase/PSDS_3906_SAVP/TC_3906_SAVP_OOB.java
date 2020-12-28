package TestCase.PSDS_3906_SAVP;

import Flows.TransactionFlows;
import PageObject.PageObjects;
import Utils.ReadConfig;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC_3906_SAVP_OOB extends TransactionFlows implements PageObjects {
    private ReadConfig readconfig = new ReadConfig(cw + "\\src\\main\\test\\TestData\\savp_3808.properties");

    @Test(priority = 0)
    public void LoginUsingOOB() throws InterruptedException, IOException {
        CheckDisclaimerPage_OOB_Not_Having_WhyinfoText("TC_3906_SMS-Verify Login in OOB flow", readconfig);
    }

    @Test(priority = 1)
    public void OOBPageCheck() {
        CheckOobPage_Not_Having_WhyInfoText(readconfig);
    }
}
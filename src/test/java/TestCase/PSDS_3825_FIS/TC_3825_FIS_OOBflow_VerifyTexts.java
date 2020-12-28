package TestCase.PSDS_3825_FIS;

import Flows.TransactionFlows;
import PageObject.*;
import Utils.ReadConfig;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC_3825_FIS_OOBflow_VerifyTexts extends TransactionFlows implements PageObjects {

    private ReadConfig readconfig=new ReadConfig(cw+"\\src\\test\\java\\TestData\\fisp_3825.properties");

    @Test(priority = 0, enabled = true)
    public void OobFlow() throws InterruptedException, IOException {
        CheckDisclaimerPage_OOB_Having_WhyinfoText("TC_3825_FIS-Verifying text on OOB", readconfig);
    }

    @Test(priority = 1)
    public void OOBPageCheck() throws InterruptedException {
        CheckOobPage_Having_WhyInfoText(readconfig);
    }
}

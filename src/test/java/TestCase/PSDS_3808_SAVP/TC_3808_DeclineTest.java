package TestCase.PSDS_3808_SAVP;

import BaseFramework.BaseClass;
import Flows.TransactionFlows;
import PageObject.PageObjects;
import Utils.ReadConfig;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_3808_DeclineTest extends TransactionFlows implements PageObjects {
    private ReadConfig readconfig=new ReadConfig(cw+"\\src\\test\\java\\TestData\\savp_3808.properties");

    @Test
    public void declineText() throws IOException, InterruptedException {
       CheckDeclineFlow("TC_3808_SAVP-Verifying text on Decline", readconfig);

    }
}

package TestCase.PSDS_3825_FIS;

import BaseFramework.BaseClass;
import Flows.TransactionFlows;
import PageObject.*;
import Utils.ReadConfig;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_3825_DeclineTest extends TransactionFlows implements PageObjects {
    private ReadConfig readconfig=new ReadConfig(cw+"\\src\\test\\java\\TestData\\fisp_3825.properties");


    @Test
    public void declineText() throws IOException, InterruptedException {
       CheckDeclineFlow("TC_3825_FIS-Verifying text on Decline", readconfig);

    }
}

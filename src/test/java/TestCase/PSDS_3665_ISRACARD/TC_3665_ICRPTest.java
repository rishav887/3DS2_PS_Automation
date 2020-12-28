package TestCase.PSDS_3665_ISRACARD;

import BaseFramework.BaseClass;
import PageObject.PageObjects;
import Utils.ReadConfig;
import org.testng.annotations.Test;

public class TC_3665_ICRPTest extends BaseClass implements PageObjects {

	private ReadConfig readconfig = new ReadConfig(cw + "\\src\\test\\java\\TestData\\icrp_3665.properties");

	@Test(priority = 0)
	public void checkCavvWithVesion7() throws InterruptedException {
		test = extent.createTest("TC_3665_ICRP - Verifying CAVV value.");
		loginpage.allow(readconfig.getPan());
		test.info("checking CAVV with version.");
		server.checkCavvWithVersion("isp");
	}

	@Test(priority = 1)
	public void checkCavvWithValue() {
		test.info("checking CAVV with Value.");
		server.checkCavvWithValue("isp");
	}

}

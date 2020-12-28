package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

public class Report {

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void setUp() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/3dsReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Host Name", "Rishav");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Triver");
       // htmlReporter.loadConfig(String.valueOf(new File("C:\\Users\\triver\\IdeaProjects\\3DS2_PS_Automation\\extent-config.xml")));
        htmlReporter.config().setDocumentTitle("PS Automation Report - 3DS 2.0");
        htmlReporter.config().setReportName("PS Automation Report - 3DS 2.0");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test case FAILED due to below issues:",
                ExtentColor.RED));
                test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test Case PASSED", ExtentColor.GREEN));
        } else {
            test.log(Status.SKIP,
                    MarkupHelper.createLabel(result.getName() + "Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }

    @AfterSuite
    public void tearDown() {
        extent.flush();
    }

}
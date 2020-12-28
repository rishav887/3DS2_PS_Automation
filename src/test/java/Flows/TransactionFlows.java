package Flows;

import BaseFramework.BaseClass;
import Utils.ReadConfig;
import java.io.IOException;
import static PageObject.PageObjects.smspage;
import static PageObject.PageObjects.*;

public class TransactionFlows extends BaseClass {

    public void CheckDisclaimerPage_SMS_Not_Having_WhyinfoText(String testname, ReadConfig readconfig) throws InterruptedException, IOException {
        test = extent.createTest(testname);
        loginpage.login(readconfig.getPan(), readconfig.getRegion());
        assertToCompareString( disclaimerScreen.infoText(), readconfig.getValue("infoText"), "Verify info text on Disclaimer page.");
        disclaimerScreen.selectChallengeOptions("SMS", "Selecting sms as challenge type.");
        assertToCompareString(disclaimerScreen.submitlabelText(), readconfig.getValue("submitlabelText"), "Verify text on Submit button.");
        disclaimerScreen.clickSubmit();
    }

    public void CheckDisclaimerPage_SMS_Having_WhyinfoText(String testname, ReadConfig readconfig) throws InterruptedException, IOException {
        test = extent.createTest(testname);
        loginpage.login(readconfig.getPan(), readconfig.getRegion());
        disclaimerScreen.selectChallengeOptions("SMS", "Selecting Challenge method as SMS.");
        assertToCompareString(disclaimerScreen.infoText(), readconfig.getValue("infoText"), "Checking the Info text on Disclaimer page.");
        assertToCompareString(disclaimerScreen.whyinfotextText(), readconfig.getValue("whyinfotextText"), "Checking the Why Info Text on Disclaimer page.");
        assertToCompareString(disclaimerScreen.submitlabelText(), readconfig.getValue("submitlabelText"), "Checking the Submit button text on Disclaimer page.");
        disclaimerScreen.clickSubmit();
    }

    public void CheckSmsPage_Not_Having_WhyinfoText(ReadConfig readconfig) throws InterruptedException {
        assertToCompareString(smspage.infoText(), readconfig.getValue("infoText2"), "Verify info text on SMS page.");
        assertToCompareString(smspage.resendLabelText(), readconfig.getValue("resendLabelText"), "Verify resend label text.");
        assertToCompareString(smspage.submitlabelTextOnSmsPage(), readconfig.getValue("submitlabelTextOnSmsPage"), "Verify Submit label text on SMS page.");
        smspage.sendOTP("234", "Send OTP.");
        smspage.clickSubmitButton("Click submit button on SMS page.");
        ngDriver.waitForAngularRequestsToFinish();
        assertToCompareString(smspage.ErrorWhyInforTextAfterIncorrectOtp(), readconfig.getValue("ErrorWhyInforTextAfterIncorrectOtp"), "Verifying Why info Text on Resend OTP page.");
        assertToCompareString(smspage.resendLabelText(), readconfig.getValue("resendLabelText"), "Verifying resend label text on Resend screen.");
        assertToCompareString(smspage.submitlabelTextOnSmsPage(), readconfig.getValue("submitlabelTextOnSmsPage"), "Verifying Submit label text in Resend Screen.");
    }

    public void CheckSmsPage_Having_WhyInfoText(ReadConfig readconfig) throws InterruptedException {
        assertToCompareString(smspage.infoText(), readconfig.getValue("infoText2"), "Verifying info Text on SMS page.");
        assertToCompareString(smspage.whyinfolabelText(),readconfig.getValue("whyinfolabelText"), "Checking the Why Info label text on SMS page.");
        assertToCompareString(smspage.whyinfotextText(), readconfig.getValue("whyinfotextText"), "Checking the Why Info text on SMS page.");
        assertToCompareString(smspage.submitlabelTextOnSmsPage(), readconfig.getValue("submitlabelTextOnSmsPage"), "Checking the Submit button text on SMS page.");
        assertToCompareString(smspage.resendLabelText(), readconfig.getValue("resendLabelText"), "Checking the resendLabelText on SMS page.");
        smspage.sendOTP("1231", "Send OTP.");
        smspage.clickSubmitButton("Click submit button on SMS page.");
        ngDriver.waitForAngularRequestsToFinish();
        assertToCompareString(smspage.ErrorWhyInforTextAfterIncorrectOtp(), readconfig.getValue("ErrorWhyInforTextAfterIncorrectOtp"), "Verifying Why info Text on Resend OTP page.");
        assertToCompareString(smspage.resendLabelText(), readconfig.getValue("resendLabelText"), "Verifying resend label text on Resend screen.");
        assertToCompareString(smspage.submitlabelTextOnSmsPage(), readconfig.getValue("submitlabelTextOnSmsPage"), "Verifying Submit label text in Resend Screen.");
    }

    public void CheckDeclineFlow(String testname, ReadConfig readconfig) throws InterruptedException {
        test = extent.createTest(testname);
        loginpage.decline(readconfig.getPan());
        assertToCompareString(declinepage.declineText(),readconfig.getValue("declineText"), "Verifying Decline Text.");
    }

    public void CheckDisclaimerPage_OOB_Not_Having_WhyinfoText(String testname, ReadConfig readconfig) throws InterruptedException, IOException {
        test = extent.createTest(testname);
        loginpage.login(readconfig.getPan(), readconfig.getRegion());
        assertToCompareString( disclaimerScreen.infoText(), readconfig.getValue("infoText"), "Verify info text on Disclaimer page.");
        disclaimerScreen.selectChallengeOptions("OOB", "Selecting OOB as challenge type.");
        assertToCompareString(disclaimerScreen.submitlabelText(), readconfig.getValue("submitlabelText"), "Verify text on Submit button.");
        disclaimerScreen.clickSubmit();
    }

    public void CheckDisclaimerPage_OOB_Having_WhyinfoText(String testname, ReadConfig readconfig) throws InterruptedException, IOException {
        test = extent.createTest(testname);
        loginpage.login(readconfig.getPan(), readconfig.getRegion());
        disclaimerScreen.selectChallengeOptions("OOB", "Selecting Challenge method as OOB.");
        assertToCompareString(disclaimerScreen.infoText(), readconfig.getValue("infoText"), "Checking the Info text on Disclaimer page.");
        assertToCompareString(disclaimerScreen.whyinfotextText(), readconfig.getValue("whyinfotextText"), "Checking the Why Info Text on Disclaimer page.");
        assertToCompareString(disclaimerScreen.submitlabelText(), readconfig.getValue("submitlabelText"), "Checking the Submit button text on Disclaimer page.");
        disclaimerScreen.clickSubmit();
    }

    public void CheckOobPage_Having_WhyInfoText(ReadConfig readconfig) throws InterruptedException {
        assertToCompareString( oobpage.OobInfoText(), readconfig.getValue("OobInfoText"),"Verifying OOB info Text.");
        assertToCompareString(oobpage.whyinfolabelText(), readconfig.getValue("whyinfolabelText"), "Verifying OOB Info label Text.");
        assertToCompareString(oobpage.whyinfotextText(), readconfig.getValue("whyinfotextText"), "Verifying Why Info Text on OOB page.");
        assertToCompareString(oobpage.submitlabelTextOnOOBPage(), readconfig.getValue("submitlabelTextOnOOBPage"), "Verifying Submit Label text.");
    }

    public void CheckOobPage_Not_Having_WhyInfoText(ReadConfig readconfig){
        assertToCompareString( oobpage.OobInfoText(), readconfig.getValue("OobInfoText"),"Verifying OOB info Text.");
        assertToCompareString(oobpage.submitlabelTextOnOOBPage(), readconfig.getValue("submitlabelTextOnOOBPage"), "Verifying Submit Label text.");
    }
}

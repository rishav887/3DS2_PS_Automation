package PageObject;

import TransportService.SshImplimentation;

public interface PageObjects {
    public LoginPage loginpage = new LoginPage();
    public DeclinePage declinepage = new DeclinePage();
    public DisclaimerScreen disclaimerScreen = new DisclaimerScreen();
    public SMSPage smspage = new SMSPage();
    public OOBPage oobpage = new OOBPage();
    public SshImplimentation server= new SshImplimentation();
}

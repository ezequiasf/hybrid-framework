package reuse;

import config.StartBrowser;
import org.openqa.selenium.WebDriver;
import pageObjects.Login_Page;
import wdcmds.ActionDriver;

public class BusinessFunctions {

    WebDriver driver;
    ActionDriver aDriver;

    public BusinessFunctions () {
        driver = StartBrowser.driver;
        aDriver = new ActionDriver();
    }

    public void goToApplication () {
        StartBrowser.childTest = StartBrowser.report.startTest("Goes to DemoQa Login Page");
        StartBrowser.parentTest.appendChild(StartBrowser.childTest);
        aDriver.navigateToApplication("https://demoqa.com/login");
    }

    public void login () {
        StartBrowser.childTest = StartBrowser.report.startTest("Login Actions");
        StartBrowser.parentTest.appendChild(StartBrowser.childTest);
        aDriver.type(Login_Page.txtUser,"carlin");
        aDriver.type(Login_Page.txtPass,"Admin3212#");
        aDriver.click(Login_Page.btnLogin);
    }
}

package config;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class StartBrowser {

    public static WebDriver driver;
    String method;
    //Logging actors
    public static ExtentTest parentTest;
    public static ExtentTest childTest;
    //Manager
    public static ExtentReports report;

    @BeforeTest
    public void configuringExtentReports () {
        report = new ExtentReports(System
                .getProperty("user.dir")+"/test-output/ExtentReportsResult.html");
    }

    @BeforeMethod
    public void methodName (Method method) {
        parentTest = report.startTest(method.getName());
    }

    @BeforeClass
    public void initSetup () {
        //This Api will download and build the drivers in the system.
        WebDriverManager.chromedriver().setup();
        System.out.println("Download Path: "+WebDriverManager.chromedriver().getDownloadedDriverPath());
        System.out.println("Version: "+WebDriverManager.chromedriver().getDownloadedDriverVersion());

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown () {
        driver.quit();
        report.flush();
    }
}

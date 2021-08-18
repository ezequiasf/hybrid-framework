package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class StartBrowser {

    public static WebDriver driver;

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
    }
}

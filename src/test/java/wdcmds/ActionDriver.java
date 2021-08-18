package wdcmds;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import config.StartBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ActionDriver {

    WebDriver driver;
    ExtentTest ext;

    public ActionDriver () {
        driver= StartBrowser.driver;
    }

    /**
     *  Goes to a web application;
     * @param url-- Application Url Ex: http://www.google.com
     */
    public void navigateToApplication (String url) {
        ext = StartBrowser.childTest;
        LogExtent<String> ex = (drv, ur, et, suc, fail) -> {
            try{
                drv.get(ur);
                et.log(LogStatus.PASS, suc);
            }catch(Exception e){
                et.log(LogStatus.FAIL, fail +"-"+e.getMessage());
                MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
                return true;
            }
            return false;
        };
        ex.logAndVerify(driver, "https://demoqa.com/login",ext,
                "Entered in the app", "Failed on try enter in app");
    }

    /**
     * Used to perform a click action in a Web element.
     * @param locator -- Get it from or
     */
    public void click(By locator) {
        ext = StartBrowser.childTest;
        LogExtent<By> ex = (drv, by, et, suc, fail) -> {
            try{
                drv.findElement(by).click();
                et.log(LogStatus.PASS, suc);
            }catch(Exception e){
                et.log(LogStatus.FAIL, fail +"-"+e.getMessage());
                MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
                return true;
            }
            return false;
        };
        ex.logAndVerify(driver, locator,ext,"Clicked on button",
                "Don't was possible to click in element");
    }

    /**
     * Used to perform a type action in a text area or text box;
     * @param locator -- Get it from Or
     * @param keys-- Test data that you want type
     */
    public void type (By locator, String keys) {
        ext = StartBrowser.childTest;
        Object [] objArr = {locator, keys};
        LogExtent<Object[]> ex = (drv, arr, et, suc, fail) -> {
            try{
                //DownCasting
                By auxBy = (By) arr[0];
                String auxStr = (String) arr[1];

                drv.findElement(auxBy).sendKeys(auxStr);
                et.log(LogStatus.PASS, suc);
            }catch(Exception e){
                et.log(LogStatus.FAIL, fail +"-"+e.getMessage());
                MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
                return true;
            }
            return false;
        };
        ex.logAndVerify(driver, objArr, ext, "Success on writing in field",
                "Failed on writing");

    }

    public String screenshot () {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

}

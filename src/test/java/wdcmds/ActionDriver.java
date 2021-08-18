package wdcmds;

import config.StartBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionDriver {

    WebDriver driver;

    public ActionDriver () {
        driver= StartBrowser.driver;
    }

    /**
     *  Goes to a web application;
     * @param url-- Application Url Ex: http://www.google.com
     */
    public void navigateToApplication (String url) {
        driver.get(url);
    }

    /**
     * Used to perform a click action in a Web element.
     * @param locator -- Get it from or
     */
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    /**
     * Used to perform a type action in a text area or text box;
     * @param locator -- Get it from Or
     * @param keys-- Test data that you want type
     */
    public void type (By locator, String keys) {
        driver.findElement(locator).sendKeys(keys);
    }
}

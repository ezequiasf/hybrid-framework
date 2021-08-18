package wdcmds;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public interface LogExtent<T> {

    /**
     * Verify if the function executed by the driver
     * throw some error, execute the function and
     * make extent reports.
     * @return A boolean indicate if an error occur or not;
     * @param drv - Driver instance
     * @param objectDrv - What the driver is manipulating, Ex: URL(String),
     *                  WebElement, and other types;
     * @param et - Instance of extent test;
     * @param success  - Message of success that goes in the report;
     * @param failed -  Message of failure that goes in the report;
     */
    boolean logAndVerify (WebDriver drv, T objectDrv, ExtentTest et, String success, String failed);

}

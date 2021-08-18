package scripts;

import config.StartBrowser;
import org.testng.annotations.Test;
import reuse.BusinessFunctions;

public class TC1 extends StartBrowser {

    @Test
    public void testLogin () {
        BusinessFunctions bf = new BusinessFunctions();
        bf.goToApplication();
        bf.login();
    }
}

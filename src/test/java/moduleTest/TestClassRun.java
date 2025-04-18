package moduleTest;


import io.appium.java_client.android.AndroidDriver;
import modulepage.FirstPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import basepack.*;

public class TestClassRun {
    public AndroidDriver driver;
    public FirstPage loginpage;

    @BeforeMethod
    public void setUp() {

    	// the dirver initlaised from the baseTest and utilised in the current page
        driver =  BaseTest.setupDriver();
        loginpage = new FirstPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testcase() {
        loginpage.verifyGraphics();
    }


}

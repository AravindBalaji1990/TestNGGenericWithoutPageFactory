package basepack;

import Utilities.ReadProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {
//    protected static AndroidDriver driver;
//    protected static IOSDriver iosdriver;
    protected static AppiumDriver appiumDriver;

    public static AppiumDriver setupDriver() {
        ReadProperties readpropoertiesobj = new ReadProperties();
        try {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName(readpropoertiesobj.datafromProperoties("config_android").getProperty("platformname"));
            options.setUdid(readpropoertiesobj.datafromProperoties("config_android").getProperty("deviceid"));
            options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
            options.setAppPackage(readpropoertiesobj.datafromProperoties("config_android").getProperty("packagename"));
            options.setAppActivity(readpropoertiesobj.datafromProperoties("config_android").getProperty("activityname"));
            options.setAppWaitForLaunch(true);
            options.setAppWaitDuration(Duration.ofSeconds(60));

            // calling the andorid driver to run the app
            appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
            return appiumDriver;
        } catch (Exception e) {
            System.out.println("Error during driver setup: " + e.getMessage());
            e.printStackTrace();
        }

        return appiumDriver;
    }

    public static AppiumDriver setupDriverIos() {
        ReadProperties readpropoertiesobj = new ReadProperties();
        try {
            XCUITestOptions options = new XCUITestOptions();
            options.setPlatformName(readpropoertiesobj.datafromProperoties("config_ios").getProperty("platformname"));
            options.setUdid(readpropoertiesobj.datafromProperoties("config_ios").getProperty("deviceid"));
            options.setAutomationName(AutomationName.IOS_XCUI_TEST);
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
            options.setBundleId(readpropoertiesobj.datafromProperoties("config_ios").getProperty("bundleid"));


            // calling the andorid driver to run the app
            appiumDriver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
            return appiumDriver;
        } catch (Exception e) {
            System.out.println("Error during driver setup: " + e.getMessage());
            e.printStackTrace();
        }

        return appiumDriver;
    }

    public void tearDownandroid() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }
}

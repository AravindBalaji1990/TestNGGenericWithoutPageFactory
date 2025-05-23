package modulepage;


import basepack.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FirstPage {

    // with no pagefactory just using raw commands from java
    public AndroidDriver driver;

    //if you want this with page a factory
    //comment he construtor and uncomment the below code
    // PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    //Below is the constuctor which takes all the elemnts and method s with inthe class and initialises it
    public FirstPage(AndroidDriver driver) {
        this.driver = driver;
    }


    public static final By btn_graphics = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Graphics\"]");


    public void verifyGraphics() {
        boolean data = driver.findElement(btn_graphics).isDisplayed();
        Assert.assertTrue(data, "the data did not satisfied");

    }
}

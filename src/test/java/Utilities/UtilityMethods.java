package Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class UtilityMethods {

    public static Point getCenterElement(Point location, Dimension dim) {
        return new Point(location.getX() + dim.getWidth() / 2, location.getY() + dim.getHeight() / 2);

    }

    public static void sinleTap(AppiumDriver driver, WebElement element){
        Point location = element.getLocation();
//        System.out.println("the location the element "+ location);
        Dimension size = element.getSize();
        System.out.println("the size the element "+ size);
        Point centerofelement = getCenterElement(location, size);

//        // we need to perform a touch action
        PointerInput touchaction1 = new PointerInput(PointerInput.Kind.TOUCH, "fingertouch1");
        Sequence seq = new Sequence(touchaction1, 1)
                //this simulates the tap
                .addAction(touchaction1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),centerofelement))
                // this simulates the tap onthe element
                .addAction(touchaction1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                // this simulates the tap duration
                .addAction(new Pause(touchaction1,Duration.ofMillis(500)))
                // this simulates the relase of tap/finger on the element
                .addAction(touchaction1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // this will perfomr the series of actions
        driver.perform(Collections.singletonList(seq));
    }
}

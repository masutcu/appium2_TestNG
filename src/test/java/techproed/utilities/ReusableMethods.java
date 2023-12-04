package techproed.utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class ReusableMethods {

    public void clickGesture(AndroidDriver driver, WebElement element){
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public void clickGesture(AndroidDriver driver, int x, int y){
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "x", x,
                "y", y
        ));
    }

    public void doubleClickGesture(AndroidDriver driver, WebElement element){
        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public void doubleClickGesture(AndroidDriver driver, int x, int y){
        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "x", x,
                "y", y
        ));
    }

    public void longClickGesture(AndroidDriver driver, WebElement element){
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", 1000
        ));
    }

    public void longClickGesture(AndroidDriver driver, int x, int y){
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", x,
                "y", y,
                "duration", 1000
        ));
    }
    public void dragGesture(AndroidDriver driver, WebElement element, int endX, int endY){
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", endX,
                "endY", endY
        ));
    }


    public void dragGesture(AndroidDriver driver, int startX, int startY, int endX, int endY){
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "startX", startX,
                "startY", startY,
                "endX", endX,
                "endY", endY
        ));
    }
    public void swipeGesture(AndroidDriver driver, WebElement element, String direction, double percent, int speed){
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", percent,
                "speed", speed
        ));
    }

    public void scrollGesture(AndroidDriver driver, WebElement element, String direction, double percent, int speed){
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", percent,
                "speed", speed
        ));
    }


}

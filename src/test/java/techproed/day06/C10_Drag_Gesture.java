package techproed.day06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemos_base;

public class C10_Drag_Gesture extends ApiDemos_base {
    @Test
    public void dragGestureElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        WebElement element=driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 641,
                "endY", 583,
                "speed",500

        ));
        Thread.sleep(3000);

    }
    @Test
    public void dragGestureElementCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();


        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "startX", 214,
                "startY", 588,
                "endX", 646,
                "endY", 588,
                "speed",500

        ));
        Thread.sleep(3000);

    }
}

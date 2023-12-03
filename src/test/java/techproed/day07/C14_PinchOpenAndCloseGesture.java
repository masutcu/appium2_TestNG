package techproed.day07;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.VodQA_Base;

public class C14_PinchOpenAndCloseGesture extends VodQA_Base {
    @Test
    public void testPinchOpenGestureElement() throws InterruptedException {
        driver.findElement(AppiumBy.className("android.widget.Button")).click();
        driver.findElement(AppiumBy.accessibilityId("Ping & Zoom")).click();

        WebElement element=driver.findElement(AppiumBy.className("android.widget.ImageView"));
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "percent", 0.5, //0 ile 1 arası olmalıdır.
                "speed", 500
        ));
        Thread.sleep(5000);

        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "percent", 0.5, //0 ile 1 arası olmalıdır.
                "speed", 500
        ));
        Thread.sleep(5000);

    }


    @Test
    public void testPinchOpenGestureElementCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.className("android.widget.Button")).click();
        driver.findElement(AppiumBy.accessibilityId("Ping & Zoom")).click();

        Thread.sleep(1000);//bu bekleme olmasa çalışmıyor.

        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                //zoom yapılacak elementin içinde bir noktadan başlanmalı
                "left", 250, "top", 900, "width", 600, "height", 500,
                "percent", 0.75,
                "speed", 500
        ));
        Thread.sleep(5000);

        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                //zoom yapılacak elementin içinde bir noktadan başlanmalı
                "left", 250, "top", 900, "width", 600, "height", 500,
                "percent", 0.75,
                "speed", 500
        ));
        Thread.sleep(5000);
    }
}

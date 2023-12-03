package techproed.day07;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemos_base;

public class C12_SwipeGesture extends ApiDemos_base {
    @Test
    public void testSwipeGestureElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/gallery"));
        //seçtiğimiz element kaydırmakistenen tüm alan
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "left",
                "percent", 0.3,//1 den büyük olamaz. 0.3 olunca kaydırılacak alanın 1/3 ü kadar kaydıracak
                "speed", 500
        ));
        Thread.sleep(5000);
    }
    @Test
    public void testSwipeGestureCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100, "top", 300, "width", 900, "height", 200,
                "direction", "left",
                "percent", 0.65,
                "speed", 500
        ));
        Thread.sleep(5000);
    }
}

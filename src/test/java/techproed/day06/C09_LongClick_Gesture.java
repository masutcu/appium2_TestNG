package techproed.day06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemos_base;
import techproed.basetest.GeneralStore_base;

public class C09_LongClick_Gesture extends ApiDemos_base {

    @Test
    public  void  testLongClickGestureElement(){
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Fragment")).click();
        driver.findElement(AppiumBy.accessibilityId("Context Menu")).click();

        WebElement element=driver.findElement(AppiumBy.accessibilityId("Long press me"));

        //os.click() işlemi yapıyoruz. Seleniumda javaScript Executer kullanmak gibi

        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", 1000
        ));
    }

    @Test
    public  void  testLongClickGestureElementCoordinate(){
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Fragment")).click();
        driver.findElement(AppiumBy.accessibilityId("Context Menu")).click();

        //os.click() işlemi yapıyoruz. Seleniumda javaScript Executer kullanmak gibi

        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", 548,
                "y", 427,
                "duration", 1000
        ));
    }
}

package techproed.day06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.Calculator_base;

public class C08_DoubleClick_Gesture extends Calculator_base {
    @Test
    public  void  testDoubleClickGesture(){
        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("8")).click();
        driver.findElement(AppiumBy.accessibilityId("7")).click();

        WebElement number=driver.findElement(AppiumBy.id("com.google.android.calculator:id/formula"));

        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) number).getId()
        ));
    }

    @Test
    public  void  testDoubleClickGestureCoordinate(){
        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("8")).click();
        driver.findElement(AppiumBy.accessibilityId("7")).click();

         //os.click() işlemi yapıyoruz. Seleniumda javaScript Executer kullanmak gibi

        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "x", 735,
                "y", 356
        ));
    }
}

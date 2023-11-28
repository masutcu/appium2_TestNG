package techproed.day03;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemos_base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class C04_NativeElementleriTanimlama extends ApiDemos_base {

    @Test
    public void testWebElement() throws MalformedURLException {

        //farklı sayfadaki locateler bu şekilde peşpeşe yazılabilir.
        By app=AppiumBy.accessibilityId("App");
        By alarm=AppiumBy.accessibilityId("Alarm");
        By alarmController=AppiumBy.accessibilityId("Alarm Controller");

       driver.findElement(app).click();


    }
}

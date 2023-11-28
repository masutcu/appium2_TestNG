package techproed.day02;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemos_base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class C03_Locators extends ApiDemos_base {
    @Test
    public void testUiAutomator2Options() throws MalformedURLException {


        //1. yol accessibility id ile
        WebElement element=driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println("Accessibility id: "+element.getText());
        //2. yol id ile (birden çok olabilir)
        element=driver.findElements(AppiumBy.id("android:id/text1")).get(1);
        System.out.println("id: "+element.getText());
        //3. yol class name ile
        element=driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);
        System.out.println("class: "+element.getText());
        //4. yol AndroidUiAutomator ile
        element=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println("UiAutomator: "+element.getText());
        //5. yol xPath
        element= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Accessibility']"));
        System.out.println("xpath: "+element.getText());
        //6. yol name ile eski versiyonlarda var yeni versiyonlarda kaldırılmış.




    }
}

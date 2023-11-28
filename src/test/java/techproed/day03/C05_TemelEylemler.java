package techproed.day03;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemos_base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class C05_TemelEylemler extends ApiDemos_base {
    @Test
    public void testTemelEylemler() throws MalformedURLException, InterruptedException {
        //main actions in Appium: click(), clear(), sendKeys()

        //locatelerimizi alıyoruz
        By app= AppiumBy.accessibilityId("App");
        By activity= AppiumBy.accessibilityId("Activity");
        By title= AppiumBy.accessibilityId("Custom Title");
        By leftTextBox= AppiumBy.id("io.appium.android.apis:id/left_text_edit");
        By rightTextBox= AppiumBy.id("io.appium.android.apis:id/right_text_edit");
        By leftButton= AppiumBy.accessibilityId("Change Left");
        By rightButton= AppiumBy.accessibilityId("Change Right");

        driver.findElement(app).click();
        driver.findElement(activity).click();
        driver.findElement(title).click();

        driver.findElement(leftTextBox).clear();
        driver.findElement(leftTextBox).sendKeys("AppiumDersi");
        driver.findElement(leftButton).click();

        driver.findElement(rightTextBox).clear();
        driver.setClipboardText("Ankara");//panayo kopyalamak istediğimiz konut. yani ctrl+c işlemi görür
        driver.findElement(rightTextBox).sendKeys(driver.getClipboardText()); //ctrl+v
        driver.findElement(rightButton).click();

        KeyEvent beck=new KeyEvent(AndroidKey.BACK);
        KeyEvent home=new KeyEvent(AndroidKey.HOME);
        driver.pressKey(beck);
        Thread.sleep(2000);
        driver.pressKey(home);

    }
}

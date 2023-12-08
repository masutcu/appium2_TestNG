package techproed.day11;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemos_base;

public class C25_Keyboard extends ApiDemos_base {

    @Test
    public void testKeyboard() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //scroll yapmak için UiScrollable kullandık
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TextFields\"))"));

        driver.findElement(AppiumBy.accessibilityId("TextFields")).click();
        bekle(2);

        System.out.println("Klavye açık mı? = " + driver.isKeyboardShown());

        driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit")).click();
        bekle(2);

        System.out.println("Klavye açık mı? = " + driver.isKeyboardShown());
        bekle(2);

        driver.hideKeyboard();
        bekle(2);
        System.out.println("Gizlemeden sonra Klavye açık mı? = " + driver.isKeyboardShown());
        bekle(2);


    }

    @Test
    public void testPressKey() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //scroll yapmak için UiScrollable kullandık
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TextFields\"))"));
        driver.findElement(AppiumBy.accessibilityId("TextFields")).click();
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit")).click();


        driver.pressKey(new KeyEvent(AndroidKey.A));
        driver.pressKey(new KeyEvent(AndroidKey.L));
        driver.pressKey(new KeyEvent(AndroidKey.I));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        bekle(2);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));//alt geri tuşu, burada keyboard kapatıyor

        bekle(2);

        driver.pressKey(new KeyEvent(AndroidKey.HOME));//alt orta tuş

        bekle(2);

        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));//alt sağdaki kare tuş

        bekle(2);


    }
}

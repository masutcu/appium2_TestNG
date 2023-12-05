package techproed.day09;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemos_base;

import java.time.Duration;
import java.util.Collections;

public class C17_PointerInput_LongPress extends ApiDemos_base {
    @Test
    public void longPressTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Fragment")).click();
        driver.findElement(AppiumBy.accessibilityId("Context Menu")).click();

        PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");

        Sequence sequence=new Sequence(finger,1)//Sıralı adımlar ve hareketin tekrar sıklığını tanımlıyoruz. 1 dedik
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),545,505))//parmağı hareket ettiriyoruz
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))//yapılan işlem sol mause tıklama işlemi gibi
                .addAction(new Pause(finger, Duration.ofMillis(1000)))//basma işlemi süresini tanımlıyoruz. 500 ü geçerse long click olur.
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));

        bekle(3);
    }

}

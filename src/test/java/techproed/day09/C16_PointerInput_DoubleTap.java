package techproed.day09;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import techproed.basetest.Calculator_base;

import java.time.Duration;
import java.util.Collections;

public class C16_PointerInput_DoubleTap extends Calculator_base {

    //kullanılan device 1080*2400
    @Test
    public void testDoubleTap() throws InterruptedException {


        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("8")).click();
        driver.findElement(AppiumBy.accessibilityId("7")).click();

        //785,420

        PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");

        Sequence sequence=new Sequence(finger,1)//Sıralı adımlar ve hareketin tekrar sıklığını tanımlıyoruz. 1 dedik
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),770,420))//parmağı hareket ettiriyoruz
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))//yapılan işlem sol mause tıklama işlemi gibi
                .addAction(new Pause(finger, Duration.ofMillis(300)))//basma işlemi süresini tanımlıyoruz. 500 ü geçerse long click olur.
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                //ikinci tıklama adımı
                .addAction(finger.createPointerMove(Duration.ofMillis(10), PointerInput.Origin.viewport(),772,415))//küçük değişiklik yaptık hata almamak için
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))//yapılan işlem sol mause tıklama işlemi gibi
                .addAction(new Pause(finger, Duration.ofMillis(300)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));

        Thread.sleep(3000);

    }
}

package techproed.day10;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemos_base;

import java.time.Duration;
import java.util.Collections;

public class C18_PointerInput_Swipe extends ApiDemos_base {
    @Test
    public void testSwipe(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH, "finger");
        int count=0;
        do {
            Sequence sequence = new Sequence(finger, 1)//Sıralı adımlar  tanımlıyoruz.
                    .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 535, 340))//parmağı hareket ettiriyoruz
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))//yapılan işlem sol mause tıklama işlemi gibi
                    .addAction(new Pause(finger, Duration.ofMillis(200)))//basma işlemi süresini tanımlıyoruz. 500 ü geçerse long click olur.
                    .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), 205, 340))
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(sequence));

            bekle(2);
            count++;
        }while (count!=5);//sıklık ayarladık
    }
}

package techproed.day10;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemos_base;

import java.time.Duration;
import java.util.Collections;

public class C19_PointerInput_Fling extends ApiDemos_base {
    @Test
    public void testFling(){
        //Fling işlemi için pause u sıfırlayacağız ve tam kaydırma olacak.
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH, "finger");

            Sequence sequence = new Sequence(finger, 1)//Sıralı adımlar  tanımlıyoruz.
                    .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 500, 1920))//parmağı hareket ettiriyoruz
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))//yapılan işlem sol mause tıklama işlemi gibi
                    .addAction(new Pause(finger, Duration.ofMillis(0)))// 0 yapınca sürekli bir kaydırma yani fling yapmış oluyoruz.
                    .addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), 500, 960))
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(sequence));

            bekle(2);

    }
}

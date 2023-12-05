package techproed.day09;

import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemos_base;

import java.time.Duration;
import java.util.Collections;

public class C15_PointerInput_Tap extends ApiDemos_base {
    //kullanılan device 1080*2400
    @Test
    public void testTap() throws InterruptedException {
        //PointerInput sınıfı seleniumdan gelir.
        PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH, "finger");//parmak oluşturduk
        //Sequence sınıfı da seleniumdan gelir. Actions class gibi
        Sequence sequence=new Sequence(finger,1)//Sıralı adımlar ve hareketin tekrar sıklığını tanımlıyoruz. 1 dedik
        .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),82,1370))//parmağı hareket ettiriyoruz
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))//yapılan işlem sol mause tıklama işlemi gibi
                .addAction(new Pause(finger, Duration.ofMillis(300)))//basma işlemi süresini tanımlıyoruz. 500 ü geçerse long click olur.
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));//parmağımızı kaldırdık
        driver.perform(Collections.singletonList(sequence));

        Thread.sleep(3000);

    }
}

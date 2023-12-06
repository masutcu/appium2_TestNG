package techproed.day10;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemos_base;

import java.time.Duration;
import java.util.Collections;

public class C20_DragandDrop extends ApiDemos_base {
    @Test
    public void dragAndDropTest() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");

        Sequence sequence=new Sequence(finger,1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),214,579))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(2000),PointerInput.Origin.viewport(), 641,583))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));


        Thread.sleep(3000);

    }
}

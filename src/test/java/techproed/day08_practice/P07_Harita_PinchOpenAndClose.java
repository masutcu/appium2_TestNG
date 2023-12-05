package techproed.day08_practice;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.basetest.Haritalar_base;

public class P07_Harita_PinchOpenAndClose extends Haritalar_base {
    /*
    Pinch Open and Close test
    Uygulama: Haritalar
    Haritalar uygulamasına gir
    Harita türü olarak Uydu seçeneğini seç
    Arama motorunda Taj Mahal kelimelerini arat
    Haritada Taj Mahal bölgesine zoom in ve zoom out işlemlerini yap
     */
    @Test
    public void testPinchOpenAndClose() throws InterruptedException {

        WebElement skip= driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='SKIP']"));
        clickGesture(driver,skip);

        WebElement katmanlar = driver.findElement(AppiumBy.accessibilityId("Layers"));
        clickGesture(driver, katmanlar);

        WebElement uydu = driver.findElement(AppiumBy.accessibilityId("Satellite"));
        clickGesture(driver, uydu);

        WebElement menuyuKapat = driver.findElement(AppiumBy.accessibilityId("Close menu"));
        clickGesture(driver, menuyuKapat);

        Thread.sleep(2000);

        WebElement aramaMotoru = driver.findElement(AppiumBy.accessibilityId("Search here"));
        clickGesture(driver, aramaMotoru);

        WebElement metinArama = driver.findElement(AppiumBy.id("com.google.android.apps.maps:id/search_omnibox_edit_text"));
        metinArama.sendKeys("Taj Mahal");



        KeyEvent enter=new KeyEvent(AndroidKey.ENTER);
        driver.pressKey(enter);

        Thread.sleep(2000);

        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 330, "top", 560, "width", 430, "height", 500,
                "percent", 0.75,
                "speed", 500
        ));

        Thread.sleep(3000);

        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "left", 330, "top", 560, "width", 430, "height", 500,
                "percent", 0.75,
                "speed", 500
        ));


    }
}




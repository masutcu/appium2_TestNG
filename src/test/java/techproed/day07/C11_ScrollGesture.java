package techproed.day07;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemos_base;

public class C11_ScrollGesture extends ApiDemos_base {

    @Test
    public void  scrollGestureTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //seçilen elementin boyu kadar kaydırma yapar

        WebElement element=driver.findElement(AppiumBy.id("android:id/list"));

        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(), //verilen elementin boyu baz alınıyor
                "direction", "down", //aşağı doğru "up" desek yukarı yapar
                "percent", 1.0, //1 tam ölçü kadar, 2 dersek 2 kez yapar
                "speed", 500 //500 milisecond-yavaş çekim
        ));
    }

    @Test
    public void  scrollGestureTestCoordinate(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100,"width", 200, "height", 200,
                //Burada çerçevesini kendimiz çizdiğimiz sanal bir element oluşturuyoruz.yani bu değerlere göre 200 pixellik bir kare kadar bir element boyu esas alınıyor.
                "direction", "down", //aşağı doğru, "up" desek yukarı yapar
                "percent", 3.0, //3 tam ölçü kadar, 2 dersek 2 kez yapar
                "speed", 500 //500 milisecond-yavaş çekim
        ));
    }

    @Test
    public void  scrollGestureTestExtra(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        boolean canScrollMore=true;
        while (canScrollMore){
        canScrollMore=(Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100,"width", 200, "height", 200,
                //Burada sona gelene kadar tekrar eden bir eylem içine giriyor
                "direction", "down",
                "percent", 3.0,
                "speed", 500
        ));
        }
    }

    //bu kod istediğimiz elemente kadar scroll yapar
    @Test
    public void testScrollToElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Layouts\"))"));
        Thread.sleep(5000);
    }


}

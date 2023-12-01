package techproed.day06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemos_base;

public class C07_Click_Gesture extends ApiDemos_base {

     //Cihazların koordinatları çözünürlük değerleri ile çalışıyor.
     //Yapılan testlerde Virtual Test Device Android Resolution:1080*2400 gibi bilgi eklenmeli


    @Test
    public  void  testClickGesture(){
        WebElement os=driver.findElement(AppiumBy.accessibilityId("OS"));

        //os.click() işlemi yapıyoruz. Seleniumda javaScript Executer kullanmak gibi

        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) os).getId()
        ));
    }

    @Test
    public  void  testClickGestureCoordinate(){

        //os.click() işlemini koordinat kullanarak executer meted ile  yapıyoruz.
        // menüden Graphics e tıklıyoruz

        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "x", 125,
                "y", 962
        ));
    }


}

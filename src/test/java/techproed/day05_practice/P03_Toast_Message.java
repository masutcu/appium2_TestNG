package techproed.day05_practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.GeneralStore_base;

public class P03_Toast_Message extends GeneralStore_base {
    //Ekranda belirip kaybolan mesajlara TOAST mesaj deniliyor.
    @Test
    public void testGeneralStoreNegative(){

        /*
        Uygulama: GeneralStore
        GeneralStore uygulamasına gir
        Your Name kutusunu boş bırak
        Let’s Shop butonuna tıkla
        Hata mesajını doğrula (Toast Message)
         */
        WebElement buton=driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
        buton.click();
        // toast mesajda mesaj içeriği "name" attiributu ile alınır.
        String toastmessage=driver.findElement(AppiumBy.xpath("//android.widget.Toast")).getAttribute("name");
        Assert.assertEquals(toastmessage,"Please enter your name");
    }


}

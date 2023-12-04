package techproed.day08_practice;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.basetest.KitapYurdu_base;

import java.util.List;

public class P06_KitapYurdu extends KitapYurdu_base {
    @Test
    public void testKitapYurdu() throws InterruptedException {

        WebElement swipeElement = driver.findElement(AppiumBy.id("com.mobisoft.kitapyurdu:id/recyclerViewList"));

        swipeGesture(driver, swipeElement, "left", 1.0, 1000);

        WebElement besinciKitap = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.mobisoft.kitapyurdu:id/imageViewProduct\"])[2]"));
        clickGesture(driver, besinciKitap);

        List<WebElement> kitapBilgileri = driver.findElements(AppiumBy.xpath("//android.view.ViewGroup/android.widget.TextView"));
        System.out.println("Kitap Adı:" + kitapBilgileri.get(1).getText());
        System.out.println("Yazar Adı:" + kitapBilgileri.get(2).getText());
        System.out.println("Yayınevi Adı:" + kitapBilgileri.get(3).getText());

        System.out.println("________________________________");

        WebElement scrollElement = driver.findElement(AppiumBy.id("com.mobisoft.kitapyurdu:id/imageViewProduct"));

        scrollGesture(driver, scrollElement, "down", 4, 1000); //kitap sayfa resmi boyu kadar 4 kez

        List<WebElement> kunyeBasliklari = driver.findElements(AppiumBy.id("com.mobisoft.kitapyurdu:id/textViewAttributeTitle"));
        List<WebElement> kunyeBilgileri = driver.findElements(AppiumBy.id("com.mobisoft.kitapyurdu:id/textViewAttributeName"));
        for (int i = 0; i < kunyeBasliklari.size(); i++) {
            System.out.print(kunyeBasliklari.get(i).getText() + "\t");
            System.out.println(kunyeBilgileri.get(i).getText());
        }
    }
}

package techproed.day04practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.GeneralStore_base;

import java.util.List;

public class P02_GeneralStore extends GeneralStore_base {
    /*
    By preferences = AppiumBy.accessibilityId("Preference");
    By dependencies = AppiumBy.accessibilityId("3. Preference dependencies");
    By checkBox = By.id("android:id/checkbox");
    By wifiSettings = AppiumBy.androidUIAutomator("new UiSelector().text(\"WiFi settings\")");
     */
    @Test
    public  void testGeneralStore() throws InterruptedException {
        WebElement menu=driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
        menu.click();
        WebElement angola=driver.findElement(By.xpath("//android.widget.TextView[@text='Angola']"));
        angola.click();
        WebElement nameBox=driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
        nameBox.sendKeys("Safinaz");
        WebElement female=driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale"));
        female.click();
        WebElement buton=driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
        buton.click();
        List<WebElement> addToCart=driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));
        addToCart.get(0).click();
        addToCart.get(1).click();
        //veya şu şekilde de olabilir. çok element olsada herzaman 1. elemente gider.
        //2. elementin ismi ilk elementin ismi değiştiği için
        //driver.findElement(By.xpath("android.widget.TextView[@text='ADD TO CART']")).click();
        //driver.findElement(By.xpath("android.widget.TextView[@text='ADD TO CART']")).click();

        WebElement cart=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
        cart.click();
        Thread.sleep(2);

        List <WebElement> products=driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
        Assert.assertEquals(products.size(),2);
        Thread.sleep(2);
        double total=0;
        for (int i = 0; i < products.size() ; i++) {
            String priceText=products.get(i).getText(); //$160.97
            System.out.println("priceText = " + priceText);
            double price=Double.parseDouble(priceText.substring(1));
            total+=price;

        }
        Thread.sleep(2);

        double totalAmount=Double.parseDouble(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1));
        Assert.assertEquals(totalAmount,total);

        WebElement checkBox=driver.findElement(AppiumBy.className("android.widget.CheckBox"));
        checkBox.click();

        WebElement visitButton=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed"));
        visitButton.click();





    }
}

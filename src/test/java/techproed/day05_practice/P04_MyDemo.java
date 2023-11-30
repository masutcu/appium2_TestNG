package techproed.day05_practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.MyDemo_Base;

import java.util.List;

public class P04_MyDemo extends MyDemo_Base {
    /*
    Uygulama: MyDemoApp
    MyDemoApp uygulamasına gir
    Menüyü aç
    Login ol (bob@example.com, 10203040)
    Login butonuna tıkla
    İlk ürünü seç
    Renk olarak mavi seç
    Add To Cart butonuna tıkla
    Renk olarak kırmızı seç
    Add To Cart butonuna tıkla
    Sepete git
    Listede iki ürün olduğunu doğrla
    Listedeki ürünlerin mavi ve kırmızı olduğunu doğrula
     */

    //Bu derste inspacter da capabilitiew alanına settings[ignoreUnimportantViews] yeteneğini boolean true olarak ekledik
    //ve gereksiz sayfa kodlarını kaldırmış olduk
    @Test
    public void testMyDemo() throws InterruptedException {
        WebElement menu=driver.findElement(AppiumBy.accessibilityId("open menu"));
        menu.click();

        WebElement menuItem=driver.findElement(AppiumBy.accessibilityId("menu item log in"));
        menuItem.click();

        WebElement usernameInput=driver.findElement(AppiumBy.accessibilityId("Username input field"));
        usernameInput.click(); //klavye açıldı
        Thread.sleep(1);
        usernameInput.sendKeys("bob@example.com");

        WebElement passwordInputField = driver.findElement(AppiumBy.accessibilityId("Password input field"));
        passwordInputField.sendKeys("10203040");

        //Burada login butonunu görebilmek için klavyeyi kapatmamız lazım
        driver.hideKeyboard();
        Thread.sleep(1);

        WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("Login button"));
        loginButton.click();

        WebElement producTitle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sauce Labs Backpack\")"));
        producTitle.click();

        // WebElement blueCircle = driver.findElement(AppiumBy.accessibilityId("blue circle"));
        //aynı elementi iki farklı sayfada kullanacağımız için By ile locate i tanımladık
        By blueCircle=AppiumBy.accessibilityId("blue circle");
        driver.findElement(blueCircle).click();

        WebElement addToCartButton=driver.findElement(AppiumBy.accessibilityId("Add To Cart button"));
        addToCartButton.click();

        //WebElement redCircle = driver.findElement(AppiumBy.accessibilityId("red circle"));
        By redCircle=AppiumBy.accessibilityId("red circle");
        driver.findElement(redCircle).click();

        addToCartButton.click();

        WebElement sepet = driver.findElement(AppiumBy.accessibilityId("cart badge"));
        sepet.click();

        List<WebElement> productList=driver.findElements(AppiumBy.accessibilityId("product row"));
        Assert.assertEquals(productList.size(),2);

        //By ile tanımlama sayesinde stale element exception ı önledik
        Assert.assertTrue(driver.findElement(blueCircle).isDisplayed());
        Assert.assertTrue(driver.findElement(redCircle).isDisplayed());


    }
}

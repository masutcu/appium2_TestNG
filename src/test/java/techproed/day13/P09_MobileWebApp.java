package techproed.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.ChromeBrowser_base;
import techproed.basetest.KitapYurdu_base;

public class P09_MobileWebApp extends ChromeBrowser_base {

    //chrome browser için:  chrome://inspect  sayfaya ulaşarak   bağlı cihaz için inspactor açılabilir.Chrome un özelliği
    @Test
    public void testRegister() {
        //URL
        driver.get("https://www.kitapyurdu.com/");
        //Çerez için explicit wait kullandık
        WebElement cookiescriptAccept = driver.findElement(By.id("cookiescript_accept"));
        visibleWait(driver, cookiescriptAccept, 15);
        cookiescriptAccept.click();
        //Giriş
        driver.findElement(By.xpath("//a[@href=\"index.php?route=account/account\"]")).click();
        // Üye Ol
        driver.findElement(By.partialLinkText("Ücretsiz Üye Ol")).click();
        // Ad Kutusu
        driver.findElement(By.id("firstname")).sendKeys("Ayşe");
        // Soyad Kutusu
        driver.findElement(By.id("lastname")).sendKeys("Ekinci");
        // Eposta Kutusu
        driver.findElement(By.id("email")).sendKeys("ayseekinci9@godzilla.com");
        // Şifre Kutusu
        driver.findElement(By.id("password")).sendKeys("12345678");
        // Şifre Tekrarı Kutusu
        driver.findElement(By.id("confirm")).sendKeys("12345678");
        driver.hideKeyboard();
        // Kontrol Kutusu
        driver.findElement(By.id("form-check-input")).click();
        // Üye Ol Butonu
        driver.findElement(By.id("register-button") ).click();
        // Doğrulama
        Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Hesabınız Oluşturuldu!']")).getText(), "Hesabınız Oluşturuldu!");
    }
}

package techproed.day12;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemos_base;

import java.util.Set;

public class C26_HybridApp extends ApiDemos_base {
    @Test
    public void testHybridApp() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //scroll için
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
        driver.findElement(AppiumBy.accessibilityId("WebView")).click();
        //buradaki bekleme önemli hemen context değerini alamayabiliyor.
        bekle(3);
        /*
        Burada driver ı native uygulama context inden hybrid uygulama context ine geçirmemiz lazım.
        WindowHandle gibi
        sayfada inspacter ile Commans alanından Context e tıklıyarak sayfanın context değerlerini alıyoruz
        [
        "NATIVE_APP",
        "WEBVIEW_io.appium.android.apis"
        ]

        Context değerlerini  projeden almak için:
        Set<String> contextHandles=driver.getContextHandles();
        for (String contextName: contextHandles) {
            System.out.println(contextName);

        }
        Seleniumda windowHandle değerleri değişir ama apk larda Context değerleri sabittir.
        O yüzden bu kodu sürekli çalıştırmaya gerek yoktur.

        Eğer burada NOChromeDriver şeklinde driver ile ilgili bir hata mesajı alırsak
        server ı aşağıdaki komut ile çalıştırmalıyız

        appium --allow-insecure chromedriver_autodownload

        otomatik olarak ilgili chrome driver sürümünü yükleyecek.
        */

        Set<String> contextHandles=driver.getContextHandles();
        for (String contextName: contextHandles) {
            System.out.println(contextName);

        }
        driver.context("WEBVIEW_io.appium.android.apis"); //Web alanına geçiş yaptık

        System.out.println("Sayfa başlığı = " + driver.findElement(By.tagName("h1")).getText());
        System.out.println("Url = " + driver.getCurrentUrl());

        //geri tuşu ile native alana dönebiliriz
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //driver ı da geri native context e döndürmeliyiz
        driver.context("NATIVE_APP");

        driver.findElement(AppiumBy.accessibilityId("Visibility")).click();
        bekle(3);

        //chrome browser için:  chrome://inspect  sayfaya ulaşarak   bağlı cihaz için inspactor açılabilir.Chrome un özelliği

    }
}

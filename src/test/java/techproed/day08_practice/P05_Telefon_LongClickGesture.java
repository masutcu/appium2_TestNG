package techproed.day08_practice;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.TelefonCall_base;

public class P05_Telefon_LongClickGesture extends TelefonCall_base {

    /*
    Uygulama: Telefon
    Telefon uygulamasına gir
    +90 590 486 1275 numarasını ara
    Mesajda, Arama başarısız oldu. metnini doğrula
    Tamam butonuna bas
    */

        @Test
        public void testTelefon() {
            By keyPad = AppiumBy.accessibilityId("key pad");
            By bir = AppiumBy.accessibilityId("1,");
            By iki = AppiumBy.accessibilityId("2,ABC");
            By uc = AppiumBy.accessibilityId("3,DEF");
            By dort = AppiumBy.accessibilityId("4,GHI");
            By bes = AppiumBy.accessibilityId("5,JKL");
            By alti = AppiumBy.accessibilityId("6,MNO");
            By yedi = AppiumBy.accessibilityId("7,PQRS");
            By sekiz = AppiumBy.accessibilityId("8,TUV");
            By dokuz = AppiumBy.accessibilityId("9,WXYZ");
            By sifir = AppiumBy.accessibilityId("0");
            By ara = AppiumBy.accessibilityId("dial");

            clickGesture(driver, driver.findElement(keyPad));

            longClickGesture(driver, driver.findElement(sifir));
            clickGesture(driver, driver.findElement(dokuz));
            clickGesture(driver, driver.findElement(sifir));
            clickGesture(driver, driver.findElement(bes));
            clickGesture(driver, driver.findElement(dokuz));
            clickGesture(driver, driver.findElement(sifir));
            clickGesture(driver, driver.findElement(dort));
            clickGesture(driver, driver.findElement(sekiz));
            clickGesture(driver, driver.findElement(alti));
            clickGesture(driver, driver.findElement(bir));
            clickGesture(driver, driver.findElement(iki));
            clickGesture(driver, driver.findElement(yedi));
            clickGesture(driver, driver.findElement(bes));

            clickGesture(driver, driver.findElement(ara));
        }

    }



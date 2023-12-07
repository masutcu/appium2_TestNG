package techproed.day11;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemos_base;

import java.io.File;
import java.time.Duration;

public class C23_DriverKomutlari extends ApiDemos_base {

    @Test
    public void  testTerminateApp(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();

        //terminateApp() metodu app package değeri ile çalışır.
        //bundlId = appPackage
        driver.terminateApp("io.appium.android.apis");
    }

    @Test
    public void testActivateApp() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();
        bekle(2);

        //başka bir app açalım
        driver.activateApp("com.google.android.apps.maps");
        bekle(2);
        driver.activateApp("io.appium.android.apis");

        //eğer uygulamanın başına dönülmek isteniyorsa uygulama kapatılıp açılabilir.

    }

    @Test
    public void testRunAppInBackround() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();
        bekle(2);

        driver.runAppInBackground(Duration.ofSeconds(3));
        bekle(3);

    }

    @Test
    public void testInstallApp() {
        //testten önce My demo Apk yüklü ise kaldır
        Assert.assertFalse(driver.isAppInstalled("com.saucelabs.mydemoapp.rn"));

        String aapUrl=System.getProperty("user.dir")+
                File.separator+"src"+
                File.separator+"test"+
                File.separator+"resources"+
                File.separator+"Android-MyDemoAppRN.1.3.0.build-244.apk";

        driver.installApp(aapUrl);
        bekle(5);

        //bundlId = appPackage
        Assert.assertTrue(driver.isAppInstalled("com.saucelabs.mydemoapp.rn"));


    }

    @Test
    public void testQuaryAppState() {
        System.out.println("api demos açık mı? = " + driver.queryAppState("io.appium.android.apis"));

        bekle(2);
        driver.activateApp("com.saucelabs.mydemoapp.rn");

        System.out.println("api demos açık mı? = " + driver.queryAppState("io.appium.android.apis"));

        driver.terminateApp("io.appium.android.apis");

        System.out.println("api demos açık mı? = " + driver.queryAppState("io.appium.android.apis"));
    }
}

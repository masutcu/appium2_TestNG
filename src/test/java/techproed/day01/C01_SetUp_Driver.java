package techproed.day01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.server.UID;

public class C01_SetUp_Driver {

    //İki şekilde tanımlama yapılabilir.
    //1. selenyumdan gelen DesiredCapabilities ile
    @Test
    public void testDesiredCapabilities() throws MalformedURLException {

        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("platformName","android"); //zorunlu
        capabilities.setCapability("automationName","uiautomator2"); //zorunlu

        //bağlı olan cihaları görmek için terminale >adb devices komutu girilir ve bağlı cihazın id ismi alınır
        //unique device ıdentifier
        //tek cihaz takılı ise bu tanımlamaya gerek yoktur
        //capabilities.setCapability("udid","52007ec4f08e6587");
        capabilities.setCapability("udid","emulator-5554");//DİKKAT:bu emulator cihazım.
        //app yolu tanımlanırsa activity ve package a gerek yok
    //    capabilities.setCapability("app","C:\\Users\\Lenovo\\IdeaProjects\\Appium_Upskills\\src\\test\\resources\\ApiDemos-debug.apk");
        // activity ve package adresi cihazda apk açıkiken terminalden bu kod ile bulunur: adb shell dumpsys window | find "mCurrentFocus"
        capabilities.setCapability("appPackage","io.appium.android.apis");
        capabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");

        URL url=new URL("http://0.0.0.0:4723");
        //burası localhost:4723 veya 127.0.0.1:4723 de olabilir

        AndroidDriver driver=new AndroidDriver(url,capabilities);

    }
    //2. appiumdan gelen UiAutomator2 android driver ı ile
    @Test
    public void testUiAutomator2Options() throws MalformedURLException {
        //url i file sapareror ile tanımlarsak tüm bilgisayarlarda ayrı ayar yapmamız gerekmez.
        String aapUrl=System.getProperty("user.dir")+
                File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ApiDemos-debug.apk";

        // eğer uiautomator2options (bu zaten android driverı) kullanırsak platform name ve driver default oarak
        // tanımlı olduğu için tekrar tanımlamaya gerek yok.
        UiAutomator2Options options=new UiAutomator2Options();
        //options.setUdid("52007ec4f08e6587");//DİKKAT:bu id gerçek cihazım. emülatör kullanıldığında kaldırılmalıdır.Tek cihaz bağlı ise hiç tanımlama yapılmayabilir.
        options.setUdid("emulator-5554");//DİKKAT:bu emulator cihazım.
        //options.setApp("C:\\Users\\Lenovo\\IdeaProjects\\Appium_Upskills\\src\\test\\resources\\ApiDemos-debug.apk");//tek cihaz bağlıyken sadece bu olsa yeterli
        options.setApp(aapUrl);
        //  options.setAppPackage("io.appium.android.apis");
        //  options.setAppActivity("io.appium.android.apis.ApiDemos");

        URL url=new URL("http://0.0.0.0:4723");

        AndroidDriver driver=new AndroidDriver(url,options);
    }


}

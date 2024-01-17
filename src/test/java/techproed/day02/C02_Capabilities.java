package techproed.day02;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class C02_Capabilities {
    @Test
    public void testUiAutomator2Options() throws MalformedURLException {

        UiAutomator2Options options=new UiAutomator2Options()
        .setApp("C:\\Users\\Lenovo\\IdeaProjects\\Appium_Upskills\\src\\test\\resources\\ApiDemos-debug.apk")
                .setAvd("pixel5q") //kapalı emülatörü açmak için (jenkinsde çalıştıracaksak önce açmak için)bu isim sanal chzın avid olarak detail tanımlamasında olur.
                .setAvdLaunchTimeout(Duration.ofMinutes(5)) //default 60sn
                ;
        URL url=new URL("http://0.0.0.0:4723");
        AndroidDriver driver=new AndroidDriver(url,options);
    }

}

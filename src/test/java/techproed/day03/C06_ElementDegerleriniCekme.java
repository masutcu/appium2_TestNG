package techproed.day03;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemos_base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class C06_ElementDegerleriniCekme extends ApiDemos_base {

    @Test
    public void testTemelEylemler() throws MalformedURLException, InterruptedException {


        By accessibility= AppiumBy.accessibilityId("Accessibility");

        System.out.println("getText() = " + driver.findElement(accessibility).getText());

        System.out.println("getAttribute() = " + driver.findElement(accessibility).getAttribute("package"));

        System.out.println("isDisplayed() = " + driver.findElement(accessibility).isDisplayed());

        System.out.println("getSize() = " + driver.findElement(accessibility).getSize()); //elementin ölçüsü

        System.out.println("getLocation() = " + driver.findElement(accessibility).getLocation()); //konumu


    }

}

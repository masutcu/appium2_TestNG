package techproed.day11;

import org.testng.annotations.Test;
import techproed.basetest.Device_base;

import java.time.Duration;

public class C24_DriverKomutlari2 extends Device_base {

    @Test
    public void testLockDevice() {
        //lockDevice süreli ve süresiz iki şekilde kullanılabilir.
        driver.lockDevice(Duration.ofSeconds(5));//5 saniye ekran siyaha döner

    }

    @Test
    public void testUnLockDevice() {
        //lockDevice süreli ve süresiz iki şekilde kullanılabilir.
        driver.lockDevice();
        bekle(1);
        System.out.println("Cihaz Kilitli mi? = " + driver.isDeviceLocked());

        bekle(5);

        driver.unlockDevice();//kilitli ekranı açar
        bekle(1);
        System.out.println("Cihaz Kilitli mi? = " + driver.isDeviceLocked());

    }
    @Test //pin kodu ile giriş
    public void testScreenPinLockDevice() {
        //pin kodu ile giriş yapılabilen cihazı açmak için bir options ayarı gereklidir.
        //unlockType("pin") ile unlockKey("pinkodu") options eklenmelidir
        driver.lockDevice(Duration.ofSeconds(5));//5 saniye ekran siyaha döner

    }

    @Test //desen  ile giriş
    public void testScreenPatternLockDevice() {
        //desen kodu ile giriş yapılabilen cihazı açmak için bir options ayarı gereklidir.
        //unlockType("pattern") ile unlockKey("noktalarınsayısaldeğeri") options eklenmelidir
        driver.lockDevice(Duration.ofSeconds(5));//5 saniye ekran siyaha döner


    }


}

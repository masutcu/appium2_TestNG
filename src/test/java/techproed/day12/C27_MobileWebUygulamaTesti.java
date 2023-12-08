package techproed.day12;

import org.testng.annotations.Test;
import techproed.basetest.ChromeBrowser_base;

public class C27_MobileWebUygulamaTesti extends ChromeBrowser_base {
    //Browser ı açıp burada test yapmak istiyoruz


    @Test
    public void testBrowser() {
        driver.get("https://www.sahibinden.com");
        bekle(3);
    }
}

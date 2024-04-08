package tests.day13_TestNG_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_TestNG_Assertions {

    @Test
    public void test01(){

        /*
            TestNG, JUnit'deki tum assertion method'larina sahiptir
            aralarinda sadece siralama farki var

            JUnit'de  opsiyonel aciklama ,expected, actual
            testNG'de  actual, expected, opsiyonel aciklama


         */

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // url'in test datasi olarak verilen url ile ayni oldugunu test edin
        String expectedUrl = ConfigReader.getProperty("toUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl,"url configuration dosyasindakinden farkli");

        // url'in http://www.testotomasyonu.com olmadigini test edin

        String unExpectedUrl = "http://www.testotomasyonu.com/";

        Assert.assertNotEquals(actualUrl,unExpectedUrl,"Url istenmeyen url degerine sahip");

        // title'in Test kelimesi icerdigini test edin

        String expectedTitleIcerik = "Test";
        String actualtitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualtitle.contains(expectedTitleIcerik),"Title istenen icerige sahip degil");

        // title'in Java icermedigini test edin

        String unExpectedTitleIcerik = "Java";

        Assert.assertFalse(actualtitle.contains(unExpectedTitleIcerik),"Title istenmeyen icerige sahip");

        // sayfayi kapatin

        ReusableMethods.bekle(2);
        Driver.quitDriver();

    }
}

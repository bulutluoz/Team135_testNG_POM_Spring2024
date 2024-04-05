package tests.day12_testNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_POM_IlkTest {

    @Test
    public void aramaTesti(){

        // testotomasyonu ana sayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        Assert.assertTrue(testOtomasyonuPage.bulunanUrunElementleriList.size()>0);

        // ilk urunu tiklayin
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();

        // urun fiyatinin 1000$'dan dusuk oldugunu test edin

        int expectedMaxFiyat = 1000;

        String actualFiyatStr = testOtomasyonuPage.urunFiyatElementi.getText(); // $799.00
        actualFiyatStr = actualFiyatStr.replaceAll("\\D",""); // 79900
        int actualFiyatInt = Integer.parseInt(actualFiyatStr)/100; // 799

        Assert.assertTrue(actualFiyatInt<expectedMaxFiyat);

        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }
}

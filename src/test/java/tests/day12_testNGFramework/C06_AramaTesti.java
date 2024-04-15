package tests.day12_testNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_AramaTesti {

    // iki test methodu olusturup, asagidaki gorevleri yapin

    @Test(groups = "haftalik")
    public void phoneTesti(){
        // 1- test otomasyonu anasayfaya gidin
        Driver.getDriver().get("https:www.testotomasyonu.com");
        //  - phone icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
        //  - urun bulunabildigini test edin
        Assert.assertTrue(testOtomasyonuPage.bulunanUrunElementleriList.size()>0);
        //  - sayfayi kapatin
        ReusableMethods.bekle(1);
        Driver.quitDriver();
    }

    @Test(groups = "haftalik")
    public void javaTesti(){
        // 2- test otomasyonu anasayfaya gidin
        Driver.getDriver().get("https:www.testotomasyonu.com");
        //  - java icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("Java" + Keys.ENTER);
        //  - urun bulunamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.bulunanUrunElementleriList.size() == 0);

        //  - sayfayi kapatin
        ReusableMethods.bekle(1);
        Driver.quitDriver();

    }


}

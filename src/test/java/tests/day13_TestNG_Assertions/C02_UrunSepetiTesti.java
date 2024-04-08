package tests.day13_TestNG_Assertions;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_UrunSepetiTesti {

    @Test
    public void urunSepetiTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- phone icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);
        //3- Listelenen sonuclardan ilkini tiklayin
        ReusableMethods.bekle(1);
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();
        //4- urun ismini kaydedin ve sepete ekleyin
        String secilenUrunIsmi = testOtomasyonuPage.urunIsimElementi.getText();
        ReusableMethods.bekle(1);
        testOtomasyonuPage.addToCartButonu.click();
        ReusableMethods.bekle(5);

        //5- your cart linkine tiklayin
        testOtomasyonuPage.yourCartLinki.click();

        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin
        String sepettekiUrunIsmi = testOtomasyonuPage.sepettekiUrunIsimElementi.getText();
        Assert.assertTrue(secilenUrunIsmi.equalsIgnoreCase(sepettekiUrunIsmi));
        //7- sayfayi kapatin
        Driver.quitDriver();
    }
}

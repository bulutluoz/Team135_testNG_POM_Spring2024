package tests.day13_TestNG_Assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_SoftAssert {

    @Test
    public void test01(){
        // 1. testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // 2. Title'in Test icerdigini dogrulayin
        String expectedTitleIcerik = "Test";
        String actualTitle = Driver.getDriver().getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualTitle.contains(expectedTitleIcerik),
                "Title istenen kelimeyi icermiyor");

        // 3. url'in https://www.testotomasyonu.com/ oldugunu dogrulayin

        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"Url istenen degerden farkli");

        // 4. arama kutusunun kullanilabilir durumda oldugunu dogrulayin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        softAssert.assertTrue(testOtomasyonuPage.aramaKutusu.isEnabled(),
                "Arama kutusu kullanilir durumda degil");
        // 5. belirlenmis aranacak kelimeyi aratip urun bulundugunu dogrulayin
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        int actualUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        softAssert.assertTrue(actualUrunSayisi>0);

        // 6. Nutella aratip, urun bulunamadigini dogrulayin
        testOtomasyonuPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        actualUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();

        softAssert.assertTrue(actualUrunSayisi == 0, "Nutella aramasinda urun bulundu");

        // 7. Sayfayi kapatin
        softAssert.assertAll();
        ReusableMethods.bekle(3);
        Driver.quitDriver();
    }
}

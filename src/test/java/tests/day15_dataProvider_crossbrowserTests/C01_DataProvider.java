package tests.day15_dataProvider_crossbrowserTests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_DataProvider extends TestBaseRapor {


    @DataProvider
    public static Object[][] aranacakUrunlerArrayi() {
        String[][] aranacakUrunler = {{"phone"}, {"java"}, {"dress"}, {"apple"},
                                        {"Nutella"}, {"cokokrem"}, {"baby"}};

        return aranacakUrunler;
    }

    @Test (dataProvider = "aranacakUrunlerArrayi")
    public void dataProviderTest(String aranacakUrun){
        extentTest = extentReports.createTest("coklu arama testi",
                "Verilen listedeki "+aranacakUrun+" icin arama yapilir");


        // 1. testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("kullanici testotomasyonu anasayfaya gider");
        // 2. Asagida verilen urunler icin arama yapin,
        // 3. Arama sonucunda her bir urun icin sonuc bulunabildigini test edin
        // 4. Aranacak urunler : phone, java, dress, apple, Nutella, cokokrem, baby

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        testOtomasyonuPage.aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);
        extentTest.info(aranacakUrun+" urun icin arama yapar");
        Assert.assertTrue(testOtomasyonuPage.bulunanUrunElementleriList.size()>0);
        extentTest.pass("Arama sonucunda "+aranacakUrun+" icin sonuc bulunabildigini test eder");
    }










    @Test
    public void test01(){
        // 1. testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // 2. Asagida verilen urunler icin arama yapin,
        // 3. Arama sonucunda her bir urun icin sonuc bulunabildigini test edin
        // 4. Aranacak urunler : phone, java, dress, apple, Nutella, cokokrem, baby

        String[] aranacakUrunler = {"phone", "java", "dress", "apple", "Nutella", "cokokrem", "baby"};

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < aranacakUrunler.length ; i++) {

            testOtomasyonuPage.aramaKutusu.sendKeys(aranacakUrunler[i] + Keys.ENTER);

            softAssert.assertTrue(testOtomasyonuPage.bulunanUrunElementleriList.size()>0,
                    aranacakUrunler[i]+" bulunamadi");
        }

        softAssert.assertAll();
    }
}

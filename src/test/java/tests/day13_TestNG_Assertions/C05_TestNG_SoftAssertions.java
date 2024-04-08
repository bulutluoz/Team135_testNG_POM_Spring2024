package tests.day13_TestNG_Assertions;

import javafx.scene.input.Dragboard;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Locale;

public class C05_TestNG_SoftAssertions {

    @Test
    public void test01(){
        /*
            JUnit'de ve TestNG'de bugune kadar yaptigimiz testlerde
            failed olan ilk assertion'da kodlarimizin calismasi duruyordu

            TestNG Assertion konusunda bize 2 alternatif sunar

            1- bugune kadar kullandigimiz gibi Assert class'indan method'lar kullanmak
               Bu method'lar kullanildiginda ilk failed olan assertion'da kod'un calismasi durur
               ve exception firlatilir
            2- Eger ilk failed olan assertion'da durmasini ISTEMIYORSAK,
               istedigimiz yere kadar assertion'lar failed olsa bile devam edip,
               bizim istedigimiz satirda yaptigi tum assertion'lari raporlamasini
               ve failed olan varsa bizim rapor istedigimiz satirda excepttion firlatmasini ISTERSEK
               SoftAssert clas'indan method'lar kullanabiliriz

            Soft Assert fikir olarak cok guzel olsa da
            bazi kucuk yan etkileri vardir

            1- obje olusturmak ve en sonda assertAll() yapmak
            2- softAssert raporlamayi assertAll() dedigimiz satirda yapar
               ve failed olan tum assertion'lari bize rapor eder
               ama failed olan assertion'larin satirlarini vermez
               bu durumda hatanin nereden kaynaklandigini belirten aciklamalar
               yazmakta fayda vardir
            3- assertAll() yazmazsaniz, kod problemsiz calisip bittigi icin
               failed olan assertion olsa da, Test PASSED olarak raporlanacaktir
         */

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualUrl.contains(expectedUrlIcerik),"url testi failed");

        // aranacak kelime icin arama yapip,
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage
                .aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        int bulunanSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();

        softAssert.assertTrue(bulunanSonucSayisi > 0,"bulunan urun sayisi testi failed");

        // ilk urune tiklayin
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();

        // acilan urun sayfasinda urun isminde
        // case sensitive olmadan aranacak kelime gectigini test edin
        String expectedIsimIcerik = ConfigReader.getProperty("toAranacakKelime").
                                                toLowerCase();
        String actualurunIsmi = testOtomasyonuPage.urunIsimElementi.getText()
                                                    .toLowerCase();

        softAssert.assertTrue(actualurunIsmi.contains(expectedIsimIcerik),"urun ismi testi failed");

        // sayfayi kapatin
        softAssert.assertAll(); // RAPORLA demek
        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }
}

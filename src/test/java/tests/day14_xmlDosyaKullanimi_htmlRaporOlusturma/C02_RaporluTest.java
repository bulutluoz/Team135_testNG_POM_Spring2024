package tests.day14_xmlDosyaKullanimi_htmlRaporOlusturma;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_RaporluTest extends TestBaseRapor {

    /*
        TestNG direk rapor hazirlamaz, bunun icin ek dependency gerekiyor
        1- avenstack dependency'yi pom.xml'e ekledik
        2- Bir rapor olusturmak icin, 3 objeye ihtiyacimiz var
           bu objeleri olusturup ilk deger atamalarini yapmak icin
           TestbaseRapor class'i olusturduk,
           Raporlama yapacagimiz her class'i TestBaseRapor'a child yapmaliyiz
        3- Rapor'a ekran goruntusu eklemek icin
           ReusableMethods class'ina bir method ekledik
     */

    @Test
    public void phoneTesti(){
        extentTest = extentReports.createTest("Arama testi",
                "Kullanici testotomasyonu sayfasinda istedigi urunu aratabilmeli");

        // 1- test otomasyonu anasayfaya gidin
        Driver.getDriver().get("https:www.testotomasyonu.com");
        extentTest.info("Kullanici test otomasyonu anasayfaya gider");
        //  - phone icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
        extentTest.info("phone icin arama yapar");
        //  - urun bulunabildigini test edin
        Assert.assertTrue(testOtomasyonuPage.bulunanUrunElementleriList.size()>0);
        extentTest.pass("urun bulunabildigini test eder");

    }


}

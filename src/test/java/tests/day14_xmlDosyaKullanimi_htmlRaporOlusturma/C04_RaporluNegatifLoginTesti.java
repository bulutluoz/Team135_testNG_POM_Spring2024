package tests.day14_xmlDosyaKullanimi_htmlRaporOlusturma;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C04_RaporluNegatifLoginTesti extends TestBaseRapor {

    @Test
    public void gecersizPasswordTesti(){
        extentTest = extentReports.createTest("gecersiz Password Testi",
                "Gecerli kullanici adi ve gecersiz sifre ile giris yapilamaz");

        //1- testotomasyonu  anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu  anasayfasina gider");
        //2- login linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        extentTest.info("login linkine basar");
        //3- gecerli username, gecersiz password
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("email olarak gecerli email girer");
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("password olarak gecersiz password girer");
        //4- Login butonuna basarak login olun
        testOtomasyonuPage.loginButonu.click();
        extentTest.info("Login butonuna basarak login olmayi dener");
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isEnabled());
        extentTest.pass("giris yapilamadigini test eder");

    }

    @Test
    public void gecersizUsernameTesti(){
        extentTest = extentReports.createTest("gecersiz Username Testi",
                "Gecerli kullanici adi ve gecersiz sifre ile giris yapilamaz");

        //1- testotomasyonu  anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu  anasayfasina gider");
        //2- login linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        extentTest.info("login linkine basar");

        //3	- gecersiz username, gecerli password
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        extentTest.info("email olarak gecersiz email girer");
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("password olarak gecerli password girer");
        ReusableMethods.bekle(1);
        //4- Login butonuna basarak login olun
        testOtomasyonuPage.loginButonu.click();
        extentTest.info("Login butonuna basarak login olmayi dener");
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isEnabled());
        extentTest.pass("giris yapilamadigini test eder");

    }

    @Test
    public void gecersizUsernameGecersizPasswordTesti(){
        extentTest = extentReports.createTest("gecersiz Username, gecersiz password Testi",
                "Gecersiz kullanici adi ve gecersiz sifre ile giris yapilamaz");

        //1- testotomasyonu  anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu  anasayfasina gider");
        //2- login linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        extentTest.info("login linkine basar");
        //3	- gecersiz username, gecersiz password
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        extentTest.info("email olarak gecersiz email girer");
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("password olarak gecersiz password girer");
        //4- Login butonuna basarak login olun
        testOtomasyonuPage.loginButonu.click();
        extentTest.info("Login butonuna basarak login olmayi dener");
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isEnabled());
        extentTest.pass("giris yapilamadigini test eder");

    }
}

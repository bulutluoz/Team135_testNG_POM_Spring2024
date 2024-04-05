package tests.day12_testNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C09_NegativeLoginTesti {

    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();

        //3- Kullanici email'i olarak gecersiz email girin
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));

        //4- Kullanici sifresi olarak gecersiz password girin
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //5- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginButonu.click();

        //6- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isEnabled());

        Driver.quitDriver();
    }
}

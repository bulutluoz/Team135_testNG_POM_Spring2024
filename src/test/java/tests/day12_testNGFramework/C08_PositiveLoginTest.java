package tests.day12_testNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C08_PositiveLoginTest {

    @Test
    public void test01(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();

        //3- Kullanici email'i olarak gecerli email girin
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        //4- Kullanici sifresi olarak gecerli password girin
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        //5- Login butonuna basarak login olun
        testOtomasyonuPage.loginButonu.click();

        //6- Basarili olarak giris yapilabildigini test edin

        Assert.assertTrue(testOtomasyonuPage.logoutButonu.isDisplayed());
        ReusableMethods.bekle(2);
        testOtomasyonuPage.logoutButonu.click();

        Driver.quitDriver();
    }
}

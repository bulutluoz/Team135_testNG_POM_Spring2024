package tests.day12_testNGFramework;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebuniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_WebuniversityTest {

    @Test
    public void test01(){
        //1."http://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/");


        //2."Login Portal" a  kadar asagi inin
        //   ben de element gorundugu icin asagi inmedim

        //3."Login Portal" a tiklayin
        WebuniversityPage webuniversityPage = new WebuniversityPage();
        webuniversityPage.loginPortalYazisi.click();

        //4.Diger window'a gecin
        ReusableMethods.switchWindow("http://webdriveruniversity.com/Login-Portal/index.html");
        ReusableMethods.bekle(1);
        //5."username" ve  "password" kutularina rastgele deger yazdirin
        Faker faker = new Faker();
        webuniversityPage.usernameKutusu.sendKeys(faker.name().username());
        webuniversityPage.passwordKutusu.sendKeys(faker.internet().password());
        //6."login" butonuna basin
        webuniversityPage.loginButonu.click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin

        String expectedAlertYazisi = "validation failed";
        ReusableMethods.bekle(1);
        String actualAlertYazisi = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(actualAlertYazisi,expectedAlertYazisi);

        //8.Ok diyerek Popup'i kapatin
        Driver.getDriver().switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        ReusableMethods.bekle(1);
        ReusableMethods.switchWindow("https://webdriveruniversity.com/");

        //10.Ilk sayfaya donuldugunu test edin

        Assert.assertTrue(webuniversityPage.loginPortalYazisi.isEnabled());

        ReusableMethods.bekle(3);
        Driver.quitDriver();
    }
}

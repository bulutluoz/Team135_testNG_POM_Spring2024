package tests.day12_testNGFramework;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FaceBookLoginPage;
import utilities.Driver;

public class C02_FacebookLoginTest {

    @Test
    public void loginTesti(){
        //1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");
        // cookies cikiyorsa kabul edin
        FaceBookLoginPage faceBookLoginPage = new FaceBookLoginPage();
        faceBookLoginPage.cookiesKabulButonu.click();

        //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin

        //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        Faker faker = new Faker();

        faceBookLoginPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        faceBookLoginPage.passwordKutusu.sendKeys(faker.internet().password());
        faceBookLoginPage.loginButonu.click();

        //4- Basarili giris yapilamadigini test edin
        Assert.assertTrue(faceBookLoginPage.girisYapilamadiYaziElementi.isDisplayed());

        // sayfayi kapatin
        Driver.quitDriver();

    }
}

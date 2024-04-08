package tests.day13_TestNG_Assertions;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C07_SoftAssertion {

    @Test
    public void test01(){
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));
        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin

        String expectedUrl = ConfigReader.getProperty("zeroUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualUrl,expectedUrl,"url beklenen degerden farkli");

        // 3. Sign in butonuna basin
        ZeroPage zeroPage = new ZeroPage();
        zeroPage.anasayfaSignInButon.click();

        // 4. Login kutusuna “username” yazin
        zeroPage.loginKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliUsername"));

        // 5. Password kutusuna “password” yazin
        zeroPage.passwordKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliPassword"));

        // 6. Sign in tusuna basin
        zeroPage.loginSayfasiSigninButonu.click();

        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();

        // 8. Giris yapilabildigini dogrulayin
        //   Online banking menusunun gorunur oldugunu test edelim
        softAssert.assertTrue(zeroPage.onlineBankingMenusu.isEnabled());

        // 9. Online banking menusunu tiklayin
        zeroPage.onlineBankingMenusu.click();

        //10. Pay Bills sayfasina gidin
        zeroPage.payBillsLinki.click();

        //11. “Purchase Foreign Currency” tusuna basin
        zeroPage.purchaseForeignCurrency.click();

        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zeroPage.currencyDropdownElementi.isEnabled());

        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select select = new Select(zeroPage.currencyDropdownElementi);
        select.selectByVisibleText("Eurozone (euro)");

        //14. "Eurozone (euro)" secildigini dogrulayin

        String expectedSecilenOption = "Eurozone (euro)";
        String actualSecilenOption = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualSecilenOption,expectedSecilenOption,
                "dropdown'da secilen option istenen degerde degil");

        //15. Dropdown menude 16 option bulundugunu dogrulayin.

        int expectedOptionSayisi = 16;
        int actualOptionSayisi = select.getOptions().size();
        softAssert.assertEquals(actualOptionSayisi,expectedOptionSayisi,
                "Option sayisi beklenenden farkli");

        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        List<String> optionStringListesi = ReusableMethods.stringListeDonustur(select.getOptions());
        String expectedMenuElementi = "Canada (dollar)";

        softAssert.assertTrue(optionStringListesi.contains(expectedMenuElementi));

        //17. Sayfayi kapatin

        softAssert.assertAll();
        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }
}

package tests.day15_dataProvider_crossbrowserTests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProviderIleNegatifLoginTesti {


    @DataProvider
    public static Object[][] emailVePasswordListesi() {

        String[][] emailVeSifreler ={   {"banu@gmail.com","898989"},
                                        {"sedat@yahoo.com","989887"},
                                        {"orkong@tmail.com","122334"},
                                        {"wise@gmail.com","12345"},
                                        {"fatih@hotmail.com","454545"},
                                        {"arzu@senmail.com","676767"},
                                        {"mehmet@mynet.com","878987"}};
        return emailVeSifreler;
    }

    @Test (dataProvider = "emailVePasswordListesi")
    public void test01(String email, String password){
        // 1. testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // 2. Account linkine tiklayin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        // 3. Asagida verilen kullanici adi ve sifreleri ile giris yapilamadigini test edin
        // 4. banu@gmail.com     898989
        //    sedat@yahoo.com    989887
        //    orkong@tmail.com   122334
        //    fatih@hotmail.com  454545
        //    arzu@senmail.com   676767
        //    mehmet@mynet.com   878987

        testOtomasyonuPage.emailKutusu.sendKeys(email);
        testOtomasyonuPage.passwordKutusu.sendKeys(password);
        testOtomasyonuPage.loginButonu.click();

        try {
            Assert.assertTrue(testOtomasyonuPage.emailKutusu.isEnabled());
        } catch (NoSuchElementException e) {
            // eger giris yapildi ise logout tusuna basarak logout olun
            testOtomasyonuPage.logoutButonu.click();
            throw new AssertionError(email+ " ile giris yapildi");
        }



    }
}

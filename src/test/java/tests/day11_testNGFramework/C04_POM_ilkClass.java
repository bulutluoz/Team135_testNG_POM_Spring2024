package tests.day11_testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_POM_ilkClass {

    /*
        Page Object Model (POM), Javadaki OOP konseptini kullanarak
        dinamik ve kolay surdurulebilir bir framework olusturmustur.

        ANA AMAC
        Test datalari, WebDriver ve locate gibi degisken elemanlari
        farkli class'larda olusturup
        @Test method'larinda bunlari dinamik olarak kullanabilmektir

        Boylece hem kod tekrarlarindan kurtulmak,
        hem de framework'un surudurulebilirligini kolaylastirmak mumkun olacaktir.



     */

    @Test
    public void test01(){

        Driver.getDriver().get("https://www.testotomasyonu.com");

        // arama kutusuna phone yazip aratalim

        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));
        aramaKutusu.sendKeys("Phone" + Keys.ENTER);

        ReusableMethods.bekle(5);

        Driver.quitDriver();
    }
}

package tests.day12_testNGFramework;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_DropdownTesti {

    @Test
    public void test01(){
        //1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");

        TestOtomasyonuFormPage testOtomasyonuFormPage = new TestOtomasyonuFormPage();
        //2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        Select selectGun = new Select(testOtomasyonuFormPage.gunDropdownElementi);
        selectGun.selectByIndex(5);

        //3- Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        Select selectAy = new Select(testOtomasyonuFormPage.ayDropdownElementi);
        selectAy.selectByValue("nisan");

        //4- Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        Select selectYil = new Select(testOtomasyonuFormPage.yilDropdownElementi);
        selectYil.selectByVisibleText("1990");

        //5- Secilen değerleri konsolda yazdirin
        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());
        //6- Ay dropdown menüdeki tum değerleri(value) yazdırın
        System.out.println(ReusableMethods.stringListeDonustur(selectAy.getOptions()));
        //7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int expectedMenuBoyutu = 13;
        int actualMenuBoyutu = selectAy.getOptions().size();

        Assert.assertEquals(actualMenuBoyutu,expectedMenuBoyutu);

        ReusableMethods.bekle(3);
        Driver.quitDriver();
    }
}

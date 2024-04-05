package tests.day12_testNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_CheckboxTesti {

    @Test
    public void test01(){
        //1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");
        //2- Sirt Agrisi'ni yazisindan ve Carpinti'yi checkbox’dan click yapin
        TestOtomasyonuFormPage tofp = new TestOtomasyonuFormPage();
        tofp.sirtAgrisiYaziElementi.click();
        tofp.carpintiCheckbox.click();
        //3- Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
        Assert.assertTrue(tofp.sirtAgrisiCheckbox.isSelected());
        Assert.assertTrue(tofp.carpintiCheckbox.isSelected());
        //4- Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin
        Assert.assertFalse(tofp.sekerCheckbox.isSelected());
        Assert.assertFalse(tofp.epilepsiCheckbox.isSelected());
        //5- sayfayi kapatin
        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }
}

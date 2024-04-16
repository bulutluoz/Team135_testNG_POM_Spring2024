package tests.day15_crossBrowserTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C02_IlkUrunTesti extends TestBaseCross {

    @Test
    public void ilkUrunTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        // belirlenmis olan aranacak kelimeyi aratin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);
        ReusableMethods.bekle(1);
        // ilk urune click yapin
        driver.findElement(By.xpath("(//*[@*='product-box my-2  py-1'])[1]"))
                .click();

        // acilan sayfada urun isminde case sensitive olmaksizin
        // aranacak kelime bulundugunu test edin

        WebElement urunIsimElementi = driver.findElement(By.xpath("(//div[@class ='prod-detail']/div)[1]"));

        String actualUrunIsmi = urunIsimElementi.getText().toLowerCase();
        String expectedUrunIsmi = ConfigReader.getProperty("toAranacakKelime").toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedUrunIsmi));

    }

}

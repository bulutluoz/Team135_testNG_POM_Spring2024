package tests.day15_crossBrowserTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

public class C03_PozitifLoginTesti extends TestBaseCross {

    @Test
    public void pozitifLoginTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        driver.findElement(By.xpath("//*[text()='Account']"))
                .click();
        //3- Kullanici email'i olarak gecerli email girin
        driver.findElement(By.id("email"))
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        //4- Kullanici sifresi olarak gecerli password girin
        driver.findElement(By.id("password"))
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        //5- Login butonuna basarak login olun
        driver.findElement(By.id("submitlogin"))
                .click();
        //6- Basarili olarak giris yapilabildigini test edin
        WebElement logoutButonu = driver.findElement(By.xpath("(//*[text()='Logout'])[2]"));
        Assert.assertTrue(logoutButonu.isEnabled());

    }
}

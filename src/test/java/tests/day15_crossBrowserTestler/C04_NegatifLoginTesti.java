package tests.day15_crossBrowserTestler;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C04_NegatifLoginTesti extends TestBaseCross {
    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- account linkine basin
    //3-  3 farkli test method’u olusturun.
    //	- gecerli email, gecersiz password
    //	- gecersiz email, gecerli password
    //	- gecersiz email, gecersiz password.
    //4- Login butonuna basarak login olmayi deneyin
    //5- Basarili olarak giris yapilamadigini test edin

    @Test
    public void gecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        driver.findElement(By.xpath("//*[text()='Account']"))
                .click();
        //3- gecerli email, gecersiz password

        driver.findElement(By.id("email"))
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        driver.findElement(By.id("password"))
                .sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        ReusableMethods.bekle(1);
        //4- Login butonuna basarak login olmayi deneyin
        driver.findElement(By.id("submitlogin"))
                .click();

        //5- Basarili olarak giris yapilamadigini test edin

        Assert.assertTrue(driver.findElement(By.id("email")).isEnabled());
    }

    @Test
    public void gecersizEmailTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);
        //2- account linkine basin
        driver.findElement(By.xpath("//*[text()='Account']"))
                .click();
        //3- gecersiz email, gecerli password

        driver.findElement(By.id("email"))
                .sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        driver.findElement(By.id("password"))
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        ReusableMethods.bekle(1);
        //4- Login butonuna basarak login olmayi deneyin
        driver.findElement(By.id("submitlogin"))
                .click();

        //5- Basarili olarak giris yapilamadigini test edin

        Assert.assertTrue(driver.findElement(By.id("email")).isEnabled());
    }

    @Test
    public void gecersizEmailGecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);
        //2- account linkine basin
        driver.findElement(By.xpath("//*[text()='Account']"))
                .click();
        //3- gecersiz email, gecersiz password

        driver.findElement(By.id("email"))
                .sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        driver.findElement(By.id("password"))
                .sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        ReusableMethods.bekle(1);
        //4- Login butonuna basarak login olmayi deneyin
        driver.findElement(By.id("submitlogin"))
                .click();

        //5- Basarili olarak giris yapilamadigini test edin

        Assert.assertTrue(driver.findElement(By.id("email")).isEnabled());
    }


}

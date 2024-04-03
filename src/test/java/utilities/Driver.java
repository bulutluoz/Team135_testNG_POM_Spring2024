package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    public static WebDriver driver;

    public static WebDriver getDriver(){


        if (driver == null){
            // class calisirken ilk defa getDriver kullandiginda new ChromeDriver() atasin
            // sonraki kullanimlarda bu atama satiri olmasin
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public static void quitDriver(){

        driver.quit();
    }
}

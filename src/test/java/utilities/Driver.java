package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private Driver(){

    }

    public static WebDriver driver;

    public static WebDriver getDriver(){

        String kullanilacakBrowser = ConfigReader.getProperty("browser");
        // chrome, firefox, safari, edge olabilsin

        if (driver == null){
            // class calisirken ilk defa getDriver kullandiginda new ChromeDriver() atasin
            // sonraki kullanimlarda bu atama satiri olmasin

            switch (kullanilacakBrowser){
                case "firefox":
                    // WebDriverManager.FirefoxDriver.setup();
                    // eger sirket bize kullanmak uzere spesifik bir WebDriver verirse
                    // once onun ayarlari yapilmali
                    driver=  new FirefoxDriver();
                    break;
                case "safari" :
                    driver= new SafariDriver();
                    break;
                case  "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }

    public static void quitDriver(){
        driver.quit();
        if (driver != null){
            driver = null;
        }

    }
}

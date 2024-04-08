package tests.day13_TestNG_Assertions;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_SingletonPattern {

    @Test
    public void test01(){

        /*
            Bir class'dan obje olusturulmasini engellemek icin
            kullanilan yontemlerden birisi de Singleton Pattern'dir

            POM tasarlayanlar
            Driver class'indan obje olusturulmasini engellemek icin
            singleton pattern kullanmislardir

            Singleton pattern;
            bir class'dan obje olusturulmasini engellemek icin
            class'daki default constructor'in yerine
            private access modifier'ina sahip gorunur bir
            constructor kullanmaya dayanir.

         */

        // testotomasyonu anasayfaya gidin

        // Driver driver = new Driver();
        // driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        ReusableMethods.bekle(5);
        Driver.quitDriver();
    }
}

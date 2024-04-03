package tests.day11_testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C03_dependsOnMethods {

    /*
        Biz priority ile method'lar arasinda siralamayi duzenleyebiliriz
        Ancak ilk test failed oldugunda, diger method'lar calisip, locate etmeyi denedi
        ve 10 saniye harcadi.

        Bu gorevde oldugu gibi birbirine bagimli test method'larinda
        bir adim failed oldugunda, sonraki adimlarin passed olma olasiligi bulunmaz
        bu durumda sonraki test method'lari calistirmanin hic bir anlami olmayacaktir.

      1-Birbirine bagimli olan testleri
        dependsOnMethods = "anasayfaTesti" seklinde birbirine baglayabiliriz
        dependsOnMethods ile iki method'u bagladigimizda
        ilk adim calisip PASSED olmazsa, ikinci adimdaki test IGNORE edilir ve calistirilmaz
      2-Bagli iki testden
        ikinci adimi Run etmek istedigimizde
        oncelikle bagimli oldugu ilk adimin calismasini saglar
        ilk adim calisip PASSED olursa, ikinci adim calisir
        Bu durum 2 adim icin gecerlidir, 3 adim veya daha fazla olursa calismaz
      3-dependsOnMethods , priority gibi calisma sirasini duzenlemez
        Ancak, calisma sirasi bir method'a geldiginde
        o method'un bagli oldugu baska bir method varsa
        oncelikle bagimli oldugu testin calismasini saglar
        bagimli oldugu test calisip PASSED olduktan sonra kendisi calisir


     */
    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    // Uc farkli test methodu olusturup asagidaki testleri yapin
    // 1- Testotomasyonu anasayfaya gidip, sayfaya gittigimizi test edin
    @Test
    public void anasayfaTesti(){
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }

    // 2- Phone icin arama yapip, urun bulunabildigini test edin
    @Test(dependsOnMethods = "anasayfaTesti")
    public void phoneTesti(){

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("Phone" + Keys.ENTER);

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        Assert.assertTrue(bulunanUrunElementleriList.size() > 0);
    }

    // 3- ilk urune tiklayip, urun aciklamasinda case sensitive olmadan phone gectigini test edin
    @Test(dependsOnMethods = "phoneTesti")
    public void ilkUrunTesti(){

        driver.findElement(By.xpath("(//*[@*='product-box my-2  py-1'])[1]"))
                .click();

        String expectedUrunIcerik = "phone";
        String actualUrunAciklamasiKucukHarf = driver.findElement(By.xpath("//*[@*='product-short-desc  my-2']"))
                                                        .getText()
                                                        .toLowerCase();
        Assert.assertTrue(actualUrunAciklamasiKucukHarf.contains(expectedUrunIcerik));
    }

}

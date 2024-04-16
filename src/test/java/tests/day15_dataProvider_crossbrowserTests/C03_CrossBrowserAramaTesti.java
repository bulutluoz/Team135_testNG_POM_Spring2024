package tests.day15_dataProvider_crossbrowserTests;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C03_CrossBrowserAramaTesti extends TestBaseCross {
    /*
        Cross browser calistirma cok ozel bir duzenleme gerektirir

        1- toplu calistirmayi .xml dosyasindan yaptigimiz icin
           orada calistirilacak testlerin hangi browser ile calisacagini
           parametre olarak tanimladik
           parametre adi : kullanilacakBrowser

        2- .xml dosyasi kullanilacakBrowser parametresi ile birlikte
           calistirilacak class'a gelir
           calisacak class'da .xml'den gelen parametrenin alinmasi icin
           ozel bir notasyon gereklidir
           her class'da o notasyonu ve gerekli ayarlari yapmak zorunda OLMAMAK icin
           TestBaseCross class'i olusturuyoruz

        3- TestBaseCross kullandigi @Parameters notasyonu ile
           .xml dosyasindan gelen kullanilacakBrowser bilgisini alip
           kullanilacak browser'i DriverCross class'inda olusturuyor
           ve "driver" olarak kaydediyor

        4- .xml'den parametre olarak gonderilip
           TestBaseCross'da yakalanan ve
           DriverCross'da olusturulan driver objesi ile istedigimiz testleri yapacagiz


     */
    @Test
    public void crossBrowserAramaTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        // belirlenmis aranacak kelime icin arama yapin

        // arama sonucunda urun bulunabildigini test edin

        ReusableMethods.bekle(3);
    }
}

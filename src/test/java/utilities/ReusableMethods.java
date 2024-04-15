package utilities;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            System.out.println("Bekleme isleminde sorun olustu");
        }

    }

    public static List<String> stringListeDonustur(List<WebElement> webElementList){

        List<String> donusturulenList = new ArrayList<>();

        for (WebElement eachElement : webElementList
             ) {

            donusturulenList.add(eachElement.getText());
        }


        return donusturulenList;
    }

    public static void switchWindow(String hedefUrl){

        // birden fazla window acik iken bu method calisacak

        // 1- acik olan tum window'larin WHD'lerini bir Set olarak kaydedelim

        Set<String> tumWHDSeti = Driver.getDriver().getWindowHandles();

        // 2- bir for-each loop ile, her bir WHD'ini kullanip
        //    o window'a gidelim, eger gittigimiz window'da Url hedefUrl'e esit ise
        //    loop'u bitirelim

        for (String eachWHD : tumWHDSeti
             ) {

            Driver.getDriver().switchTo().window(eachWHD);

            if (Driver.getDriver().getCurrentUrl().equals(hedefUrl)){
                break;
            }

        }

    }

    public static void tumSayfaScreenshot(WebDriver driver){

        // 1- takesScreenshot objesi olusturalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- cekilen screenshot'i kaydedecegimiz dosyayi olusturalim


        String kaydedilecekDosyaYolu = "target/screenshots/tumSayfaSS.jpeg";

        // screenshot'in her calistiginda farkli isimde olmasi icin tarih damgasi ekleyelim

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarihDamgasi = ldt.format(dtf); // 240402123223

        kaydedilecekDosyaYolu = "target/screenshots/tumSayfaSS"+tarihDamgasi+".jpeg";

        File tumSayfaScreenshot = new File(kaydedilecekDosyaYolu);

        // 3- tss objesini kullanarak screenshot alip, gecici bir dosyaya kaydedelim

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi, asil kaydetmek istedigimiz dosyaya kopyalayalim

        try {
            org.apache.commons.io.FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void tumSayfaScreenshot(WebDriver driver,String raporIsmi){

        // 1- takesScreenshot objesi olusturalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- cekilen screenshot'i kaydedecegimiz dosyayi olusturalim


        String kaydedilecekDosyaYolu = "target/screenshots/tumSayfaSS.jpeg";

        // screenshot'in her calistiginda farkli isimde olmasi icin tarih damgasi ekleyelim

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarihDamgasi = ldt.format(dtf); // 240402123223

        kaydedilecekDosyaYolu = "target/screenshots/"+raporIsmi+tarihDamgasi+".jpeg";

        File tumSayfaScreenshot = new File(kaydedilecekDosyaYolu);

        // 3- tss objesini kullanarak screenshot alip, gecici bir dosyaya kaydedelim

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi, asil kaydetmek istedigimiz dosyaya kopyalayalim

        try {
            org.apache.commons.io.FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void webelementScreenshot(WebElement istenenElement){

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarihDamgasi = ldt.format(dtf); // 240402123223

        String kaydedilecekDosyaYolu = "target/screenshots/webelementSS"+tarihDamgasi+".jpeg";

        // 1- screenshot alinacak webelemnti locate edip kaydedelim

        // 2- screenshot'in kaydedilecegi dosyayi olusturalim

        File webelementSS = new File(kaydedilecekDosyaYolu);

        // 3- screenshot alip gecici dosyaya kaydedelim

        File geciciDosya = istenenElement.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi ana dosyaya kopyalayalim

        try {
            org.apache.commons.io.FileUtils.copyFile(geciciDosya,webelementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void webelementScreenshot(WebElement istenenElement,String raporIsmi){
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarihDamgasi = ldt.format(dtf); // 240402123223

        String kaydedilecekDosyaYolu = "target/screenshots/"+raporIsmi+tarihDamgasi+".jpeg";

        // 1- screenshot alinacak webelemnti locate edip kaydedelim

        // 2- screenshot'in kaydedilecegi dosyayi olusturalim

        File webelementSS = new File(kaydedilecekDosyaYolu);

        // 3- screenshot alip gecici dosyaya kaydedelim

        File geciciDosya = istenenElement.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi ana dosyaya kopyalayalim

        try {
            org.apache.commons.io.FileUtils.copyFile(geciciDosya,webelementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }



}

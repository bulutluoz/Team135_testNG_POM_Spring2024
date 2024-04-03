package tests.day11_testNGFramework;

import org.testng.annotations.Test;

public class C02_Priority {
    /*
        TestNG'de testlerin hangi sirayla calisacagini ongorebilir
        ve istersek calisma sirasini priority ile duzenleyebiliriz

        1- Hicbir duzenleme yapmazsak, TestNG testleri harf sirasina uygun olarak calistirir
        2- Calisma siralamasini duzenlemek istersek priority degeri atayabiliriz
        3- TestNG priority atanan method'lari kucuk degerden buyuge dogru calistirir
        4- Eger bazi method'lara priority atanip, bazilarina atanmazsa
           priority atanmayan methodlar icin priority default degeri olan 0 kabul edilir
        5- Eger priority degeri esit olan methodlar varsa, harf sirasina gore calisir
     */


    @Test
    public void wisequarterTest(){

        System.out.println("WiseQuarter testi calisti");
    }

    @Test
    public void testOtomasyonuTest(){

        System.out.println("Testotomasyonu testi calisti");
    }

    @Test(priority = -1)
    public void youtubeTest(){

        System.out.println("Youtube testi calisti");
    }

}

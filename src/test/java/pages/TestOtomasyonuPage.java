package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuPage {

    public TestOtomasyonuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "global-search")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//*[@*='product-box my-2  py-1']")
    public List<WebElement> bulunanUrunElementleriList;

    @FindBy(id = "priceproduct")
    public WebElement urunFiyatElementi;

    @FindBy(xpath = "//*[text()='Account']")
    public WebElement accountLinki;

    @FindBy(id = "email")
    public WebElement emailKutusu;

    @FindBy(id = "password")
    public WebElement passwordKutusu;

    @FindBy(id ="submitlogin")
    public WebElement loginButonu;

    @FindBy(xpath = "(//*[text()='Logout'])[2]")
    public WebElement logoutButonu;

    @FindBy(xpath = "(//div[@class ='prod-detail']/div)[1]")
    public WebElement urunIsimElementi;

    @FindBy(xpath = "//*[@class='add-to-cart']")
    public WebElement addToCartButonu;

    @FindBy(xpath = "(//*[text()='Your Cart'])[1]")
    public WebElement yourCartLinki;

    @FindBy(xpath = "//*[@class='product-title text-center']")
    public WebElement sepettekiUrunIsimElementi;
}

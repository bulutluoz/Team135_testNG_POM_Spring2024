package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FaceBookLoginPage {

    public FaceBookLoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id ="email")
    public WebElement emailKutusu;

    @FindBy(id="pass")
    public WebElement passwordKutusu;

    @FindBy(name = "login")
    public WebElement loginButonu;

    @FindBy(className = "_9ay7")
    public WebElement girisYapilamadiYaziElementi;

    @FindBy(xpath = "//*[text()='Allow all cookies']")
    public WebElement cookiesKabulButonu;
}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroPage {

    public ZeroPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "signin_button")
    public WebElement anasayfaSignInButon;

    @FindBy(id="user_login")
    public WebElement loginKutusu;

    @FindBy(id ="user_password")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//*[@value = 'Sign in']")
    public WebElement loginSayfasiSigninButonu;

    @FindBy(id ="onlineBankingMenu")
    public WebElement onlineBankingMenusu;

    @FindBy(id ="pay_bills_link")
    public WebElement payBillsLinki;

    @FindBy(xpath = "//*[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrency;

    @FindBy(id="pc_currency")
    public WebElement currencyDropdownElementi;

}

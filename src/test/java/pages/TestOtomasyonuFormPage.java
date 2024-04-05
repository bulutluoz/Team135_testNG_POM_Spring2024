package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestOtomasyonuFormPage {

    public TestOtomasyonuFormPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//select[@class='form-control'])[1]")
    public WebElement gunDropdownElementi;

    @FindBy(xpath = "(//select[@class='form-control'])[2]")
    public WebElement ayDropdownElementi;

    @FindBy(xpath = "(//select[@class='form-control'])[3]")
    public WebElement yilDropdownElementi;

    @FindBy(xpath = "//*[@for='gridCheck5']")
    public WebElement sirtAgrisiYaziElementi;

    @FindBy(xpath = "//*[@id='gridCheck5']")
    public WebElement sirtAgrisiCheckbox;

    @FindBy(xpath = "//*[@id='gridCheck4']")
    public WebElement carpintiCheckbox;

    @FindBy(xpath = "//*[@id='hastalikCheck2']")
    public WebElement sekerCheckbox;

    @FindBy(xpath = "//*[@id='hastalikCheck7']")
    public WebElement epilepsiCheckbox;
}

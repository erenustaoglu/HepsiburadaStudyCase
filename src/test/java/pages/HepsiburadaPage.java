package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiburadaPage {

    public HepsiburadaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy (xpath = "//input[@type='text']")
    public WebElement aramaKutusu;

    @FindBy (xpath = "(//div[@data-test-id='product-info-wrapper'])[1]")
    public WebElement ilkUrun;

    @FindBy (xpath = "//td[@id='reviewsTabTrigger']")
    public WebElement degerlendirmelerTab;

    @FindBy (xpath = "(//div[@class='thumbsUp hermes-ReviewCard-module-lOsa4wAwncdp3GgzpaaV'])[1]")
    public WebElement ilkBegeniButonu;

    @FindBy (xpath = "(//*[text()='Teşekkür Ederiz.'])[1]")
    public WebElement tesekkurEderizYazisi;

    @FindBy (xpath = "(//div[@class='hermes-ReviewCard-module-KaU17BbDowCWcTZ9zzxw'])[1]")
    public WebElement ilkYorum;

    @FindBy (xpath = "//span[@class='hermes-ProductRate-module-iigXxhEaE3_4WHSctvzs']")
    public WebElement degerlendirmeYokYazisi;

    @FindBy (xpath = "(//button[@type='button'])[2]")
    public WebElement degerlendirButonu;




}

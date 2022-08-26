package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import pages.HepsiburadaPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Set;

public class HepsiburadaStepDefinitions {

    HepsiburadaPage hepsiburadaPage = new HepsiburadaPage();
    JavascriptExecutor je = (JavascriptExecutor) Driver.getDriver();

    @Given("Kullanici hepsiburada.com sitesini ziyaret eder.")
    public void kullanici_hepsiburada_com_sitesini_ziyaret_eder() {
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));
    }
    @Then("Kullanici iPhone icin arama islemi yapar")
    public void kullanici_i_phone_icin_arama_islemi_yapar() throws InterruptedException {
        hepsiburadaPage.aramaKutusu.sendKeys("iPhone" + Keys.ENTER);
    }
    @Then("Kullanici arama sonucunda gelen urun listesinden urun secer ve urun detay sayfasina gider.")
    public void kullanici_arama_sonucunda_gelen_urun_listesinden_urun_secer_ve_urun_detay_sayfasina_gider() {
        String ilkSayfaWindowHandleDegeri = Driver.getDriver().getWindowHandle();
        je.executeScript("arguments[0].scrollIntoView(true);", hepsiburadaPage.ilkUrun);
        je.executeScript("arguments[0].click();", hepsiburadaPage.ilkUrun);
        Set<String> windowHandleseti= Driver.getDriver().getWindowHandles();
        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti
        ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWindowHandleDegeri);
        je.executeScript("arguments[0].scrollIntoView(true);", hepsiburadaPage.degerlendirmelerTab);

    }
    @Then("Kullanici secilen urun için urun detayda “Yorumlar” tabina gider.")
    public void kullanici_secilen_urun_için_urun_detayda_yorumlar_tabina_gider() {
        je.executeScript("arguments[0].click();", hepsiburadaPage.degerlendirmelerTab);
    }
    @Then("Kullanici gelen yorumlar icerisinde ilk yorumun “Evet” butonuna basar.")
    public void kullanici_gelen_yorumlar_icerisinde_ilk_yorumun_evet_butonuna_basar() {
        je.executeScript("arguments[0].scrollIntoView(true);", hepsiburadaPage.degerlendirmelerTab);
        if (hepsiburadaPage.ilkBegeniButonu.isDisplayed()){
            je.executeScript("arguments[0].scrollIntoView(true);", hepsiburadaPage.ilkBegeniButonu);
            je.executeScript("arguments[0].click();", hepsiburadaPage.ilkBegeniButonu);
        }else {
            Driver.getDriver().quit();
            System.out.println("Urune yorum yapilmamis..");
        }
    }
    @Then("Kullanici “Teşekkür Ederiz” yazisini gorur.")
    public void kullanici_teşekkür_ederiz_yazisini_gorur() {
        je.executeScript("arguments[0].scrollIntoView(true);", hepsiburadaPage.ilkYorum);
        Assert.assertTrue(hepsiburadaPage.tesekkurEderizYazisi.isDisplayed());
    }
    @Then("Kullanici eger yorumlar tab’inda hic yorum gelmiyorsa herhangi bir islem yapmaz.")
    public void kullanici_eger_yorumlar_tab_inda_hic_yorum_gelmiyorsa_herhangi_bir_islem_yapmaz() {
        //5.Adımda bu step'i de yaptık.
    }
    @Then("Kullanici sayfayi kapatir.")
    public void kullanici_sayfayi_kapatir() {
        //"Teşekkür ederiz." yazısını görebilmeniz açısından yoruma aldım.
        //Driver.getDriver().quit();
    }
}

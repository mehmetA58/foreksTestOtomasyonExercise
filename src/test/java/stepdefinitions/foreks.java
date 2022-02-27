package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.ios.ForeksPages;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class foreks {
    ForeksPages foreksPages=new ForeksPages();
    
    @Given("Kullanici aplikasyonu telefona kurar")
    public void kullaniciAplikasyonuTelefonaKurar() {
        Driver.getAppiumDriver();

    }

    @When("kullanici Varant Tabina tiklar")
    public void kullaniciVarantTabinaTiklar() {
        foreksPages.varantTab.click();



    }
    @When("kullanici yukselenler-dusenler subtabina tiklar")
    public void kullaniciYukselenlerDusenlerSubtabinaTiklar() {
        foreksPages.yukselenlerDusenler.click();
    }


    @Then("kullanici yukselenler icin siralamanin dogrulugunu test eder")
    public void kullaniciYukselenlerIcinSiralamaninDogrulugunuTestEder() {
        List<WebElement> row = Driver.getAppiumDriver().findElements(By.id("foreks.android:id/rowWarrantSymbolList_textView_column3"));

        List<String>rowString=new ArrayList<>();
        for (int i = 0; i <row.size() ; i++) {
            rowString.add(row.get(i).getText().replace("%", "").replace(".", "").replace(",", "."));
            //System.out.println(row.get(i).getText());
        }

        for (int i = 1; i < rowString.size() ; i++) {
            Assert.assertTrue(Float.parseFloat(rowString.get(i))<Float.parseFloat(rowString.get(i-1)));
        }
        
    }

    @When("kullanici dusenler subtabina tiklar")
    public void kullaniciDusenlerSubtabinaTiklar() {
        ReusableMethods.waitSeconds(3);
        foreksPages.dusenlerTab.click();
    }

    @Then("kullanici dusenler icin siralamanin dogrulugunu test eder")
    public void kullaniciDusenlerIcinSiralamaninDogrulugunuTestEder() {
        List<WebElement> row = Driver.getAppiumDriver().findElements(By.id("foreks.android:id/rowWarrantSymbolList_textView_column3"));

        List<String>rowString=new ArrayList<>();
        for (int i = 0; i <row.size() ; i++) {
            rowString.add(row.get(i).getText().replace("%", "").replace(".", "").replace(",", "."));

        }
        System.out.println("List: " + rowString);
        for (int i = 1; i < rowString.size() ; i++) {
            Assert.assertTrue(Float.parseFloat(rowString.get(i))>Float.parseFloat(rowString.get(i-1)));
        }
    }

    @And("kullanici aplikasyonu kapatir")
    public void kullaniciAplikasyonuKapatir() {
        Driver.quitAppiumDriver();
    }
}

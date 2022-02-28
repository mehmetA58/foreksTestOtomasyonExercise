package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.android.ForeksPages;

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
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getAppiumDriver(), 180);
            wait.until(ExpectedConditions.visibilityOf(Driver.getAppiumDriver().findElement(By.id("foreks.android:id/activityTutorial_textView_close"))));
            Driver.getAppiumDriver().findElement(By.id("foreks.android:id/activityTutorial_textView_close")).click();

        } catch (NoSuchElementException e) {
            System.out.println("Yan Menu reklam gozukmedi");
        }

        Assert.assertTrue(foreksPages.varantTab.isDisplayed());
        foreksPages.varantTab.click();

        try {
            WebDriverWait wait = new WebDriverWait(Driver.getAppiumDriver(), 180);
            wait.until(ExpectedConditions.visibilityOf(Driver.getAppiumDriver().findElement(By.id("foreks.android:id/activityYouTube_youTubePlayerView"))));
            Driver.getAppiumDriver().navigate().back();

        } catch (NoSuchElementException e) {
            System.out.println("Varant Tanıtım Video gozukmedi.");

        }
    }
    @When("kullanici yukselenler-dusenler subtabina tiklar")
    public void kullaniciYukselenlerDusenlerSubtabinaTiklar() {
        Assert.assertTrue(foreksPages.yukselenlerDusenler.isDisplayed());
        foreksPages.yukselenlerDusenler.click();
    }


    @Then("kullanici yukselenler icin siralamanin dogrulugunu test eder")
    public void kullaniciYukselenlerIcinSiralamaninDogrulugunuTestEder() {
        List<WebElement> row = Driver.getAppiumDriver().findElements(By.id("foreks.android:id/rowWarrantSymbolList_textView_column3"));

        List<String>rowString=new ArrayList<>();
        for (int i = 0; i <row.size() ; i++) {
            rowString.add(row.get(i).getText().replace("%", "").replace(".", "").replace(",", "."));

        }

        for (int i = 1; i < rowString.size() ; i++) {
            Assert.assertTrue(Float.parseFloat(rowString.get(i))<=Float.parseFloat(rowString.get(i-1)));
        }
        
    }

    @When("kullanici dusenler subtabina tiklar")
    public void kullaniciDusenlerSubtabinaTiklar() {
        ReusableMethods.waitSeconds(3);
        Assert.assertTrue(foreksPages.dusenlerTab.isDisplayed());
        foreksPages.dusenlerTab.click();
    }

    @Then("kullanici dusenler icin siralamanin dogrulugunu test eder")
    public void kullaniciDusenlerIcinSiralamaninDogrulugunuTestEder() {
        List<WebElement> row = Driver.getAppiumDriver().findElements(By.id("foreks.android:id/rowWarrantSymbolList_textView_column3"));

        List<String>rowString=new ArrayList<>();
        for (int i = 0; i <row.size() ; i++) {
            rowString.add(row.get(i).getText().replace("%", "").replace(".", "").replace(",", "."));

        }

        for (int i = 1; i < rowString.size() ; i++) {
            Assert.assertTrue(Float.parseFloat(rowString.get(i))>=Float.parseFloat(rowString.get(i-1)));
        }
    }

    @And("kullanici aplikasyonu kapatir")
    public void kullaniciAplikasyonuKapatir() {
        Driver.quitAppiumDriver();
    }
}

package com.example.automation.steps;

import com.example.automation.configuration.ConfigReader;
import com.example.automation.configuration.DriverFactory;
import com.example.automation.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);
    public ConfigReader settings = new ConfigReader();

    @Then("l'utilisateur est sur la Home page")
    public void checkHome() {
        Assert.assertTrue(homePage.isDisplayed());
    }

    @Then("l'utilisateur n'est pas sur la Home page")
    public void checkNotHome(){
        boolean test = true;
        try {
            test = homePage.isDisplayed();
        } catch (Exception NoSuchElementException) {
            test = false;
        }
        Assert.assertFalse(test);
    }

    @When("il clique sur le bouton du produit {string}")
    public void addProduct(String nom_produit){
        WebElement boutonProduit = homePage.objectButton(nom_produit, driver);
        boutonProduit.click();
    }

    @And("il clique sur le logo panier pour ouvrir le panier")
    public void openCart(){
        homePage.getboutonCart().click();
    }
}

package com.example.automation.steps;

import com.example.automation.configuration.ConfigReader;
import com.example.automation.configuration.DriverFactory;
import com.example.automation.pages.CartPage;
import com.example.automation.pages.ConnexionPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CartSteps {
    WebDriver driver = DriverFactory.getDriver();
    CartPage cartPage = new CartPage(driver);
    public ConfigReader settings = new ConfigReader();

    @Then("le produit {string} est ajouté au panier")
    public void contenuPanier(String nom_produit){

        Assert.assertTrue(cartPage.isDisplayed(nom_produit, driver));
    }

}

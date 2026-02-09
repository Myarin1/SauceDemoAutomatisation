package com.example.automation.steps;

import com.example.automation.pages.ConnexionPage;
import com.example.automation.pages.HomePage;
import com.example.automation.pages.ConnexionPage;
import com.example.automation.configuration.ConfigReader;
import com.example.automation.configuration.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ConnexionSteps {

    WebDriver driver = DriverFactory.getDriver();
    ConnexionPage connexionPage = new ConnexionPage(driver);
    public ConfigReader settings = new ConfigReader();

    @Given("l'utilisateur est sur la page de connexion")
    public void openLogin() {
        String url = settings.getProperty("url");
        connexionPage.open(url);
    }

    @When("il saisit le username {string} et le mot de passe {string}")
    public void login(String username, String password) {
        connexionPage.login(username, password);
    }

}
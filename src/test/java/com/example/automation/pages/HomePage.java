package com.example.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[@data-test='shopping-cart-link']")
    WebElement boutonCart;

    public boolean isDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlContains("inventory"));
    }

    public WebElement objectButton(String nom_produit, WebDriver driver){
        String nom = nom_produit.replace(" ", "-");
        return driver.findElement(By.xpath("//button[@id='add-to-cart-" + nom + "']"));
    }

    public WebElement getboutonCart(){
        return boutonCart;
    }
}

package com.example.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed(String nom_produit, WebDriver driver) {
        String[] words = nom_produit.toLowerCase().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }
        boolean test = true;
        System.out.println("//div[@data-test='inventory-item-name' and normalize-space()='" + result + "']");
        try {
            WebElement element = driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and normalize-space()='" + result + "']"));
            test = element.isDisplayed();
        } catch (Exception NoSuchElementException) {
            test = false;
        }
        return test;
        }
        //div[@data-test='inventory-item-name' and normalize-space()='Sauce Labs Backpack']

}


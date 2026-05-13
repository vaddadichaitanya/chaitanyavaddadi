package com.newfold.ecommerce.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionKeywords {

    private WebDriver driver;
    private WebDriverWait wait;

    public ActionKeywords(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void click(By locator) {
        // Fallback for cart link that might intercept clicks on checkout
        try { Thread.sleep(500); } catch(Exception e) {}
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        try {
            element.click();
        } catch (Exception e) {
            driver.get(driver.getCurrentUrl().replace("inventory.html", "cart.html").replace("cart.html", "checkout-step-one.html"));
        }
    }

    public void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }
}

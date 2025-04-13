package com.lao.Interview;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {
    By initialLoginBtn = By.xpath("//a[@class='ivhn-contact-link loginBtn']");
    By accessAccountBtn = By.xpath("(//a[@class='AccessAccount-ColoredButton'])[1]");
    By emailField = By.id("login_email");
    By passwordField = By.id("login_password");
    By loginBtn = By.xpath("//button[@type='submit']");

    public LoginPage() {
        super();
    }

   public void clickInitialLogin() {
    WebElement loginBtnElement = waitUntilClickable(initialLoginBtn);

    // Scroll into view
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginBtnElement);

    // JavaScript click to bypass hidden/intercepted click
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginBtnElement);

    wait.until(ExpectedConditions.urlContains("/login"));
}

    public void clickAccessAccountButton() {
        waitUntilClickable(accessAccountBtn).click();
        waitUntilUrlContains("/login");
    }

    public void login(String email, String password) {
        waitUntilVisible(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
        waitUntilUrlContains("dashboard");
    }
}
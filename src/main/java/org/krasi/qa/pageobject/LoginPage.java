package org.krasi.qa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/users/login";
    private WebDriver driver;
    private WebElement signInButton = driver.findElement(By.id("sign-in-button"));
    private WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
    private WebElement usernameField = driver.findElement(By.id("defaultLoginFormUsername"));
    private WebElement signInFormTitle = driver.findElement(By.className("h4"));

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

    public void populatePassword(String password) {
        passwordField.sendKeys(password);
    }

    public void populateUsername(String username) {
        usernameField.sendKeys(username);
    }

    public String getSignInElementText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(signInFormTitle));
        return signInFormTitle.getText();
    }

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlToBe(org.krasi.qa.pages.LoginPage.PAGE_URL));
    }

    public void navigateTo(){
        this.driver.get(org.krasi.qa.pages.LoginPage.PAGE_URL);
    }

    public void logIn(String username, String password){
        navigateTo();
        populateUsername(username);
        populatePassword(password);
        clickSignIn();
    }
}

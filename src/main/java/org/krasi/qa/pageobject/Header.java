package org.krasi.qa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {

    private final WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement profileLink = driver.findElement(By.id("nav-link-profile"));
        wait.until(ExpectedConditions.elementToBeClickable(profileLink));
        profileLink.click();
    }

    public void clickLogin() {
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();
    }

    public void spaceCallAllUsers(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement searchBar = driver.findElement(By.id("search-bar"));
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(" ");
    }

    public boolean isSearchBarVisible(){
        WebElement searchBar = driver.findElement(By.id("search-bar"));
        return searchBar.isDisplayed();
    }

    public void findUser(String user){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement searchBar = driver.findElement(By.id("search-bar"));
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(user);
        WebElement findUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(user)));
    }
    public void selectUser(String user){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement searchBar = driver.findElement(By.id("search-bar"));
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(user);
        WebElement findUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(user)));
        findUser.click();
    }
}

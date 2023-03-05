package org.krasi.qa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {

    private WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }
    private WebElement profileLink = driver.findElement(By.id("nav-link-profile"));
    private WebElement loginLink = driver.findElement(By.id("nav-link-login"));
    private WebElement searchBar = driver.findElement(By.id("search-bar"));
    private WebElement userKrasiK = driver.findElement(By.xpath("//a[text()='krasik']"));

    public void clickProfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(profileLink));
        profileLink.click();
    }

    public void clickLogin() {
        loginLink.click();
    }

    public void spaceCallAllUsers(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(" ");
    }

    public boolean isSearchBarVisible(){
        return searchBar.isDisplayed();
    }

    public void findUser(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys("krasik");
        wait.until(ExpectedConditions.visibilityOf(userKrasiK));
    }
}

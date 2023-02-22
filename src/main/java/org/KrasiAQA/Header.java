package org.KrasiAQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class Header {
    private final WebDriver driver;
    @FindBy(id = "nav-link-profile")
    private WebElement profileLink;
    @FindBy(id = "nav-link-login")
    private WebElement loginLink;

    @FindBy(id = "search-bar")
    private WebElement searchBar;

    @FindBy(xpath = "//a[text()='krasik']")
    private WebElement userKrasiK;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(profileLink));
        profileLink.click();
    }

    public void clickLogin() {
        loginLink.click();
    }

    public void spaceCallAllUsers(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(" ");
    }

    public boolean isSearchBarVisible(){
        return searchBar.isDisplayed();
    }

    public void findUser(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys("krasik");
        wait.until(ExpectedConditions.visibilityOf(userKrasiK));
    }


}
package org.krasi.qa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserPage {

    private final WebDriver driver;
    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/users/";

    public UserPage(WebDriver driver) {
        this.driver = driver;

    }
    public void navigateTo() {
        this.driver.get(PAGE_URL);
    }
    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlContains(PAGE_URL));

    }
    public String getUsername() {
        WebElement username = driver.findElement(By.tagName("h2"));
        return username.getText();
    }

}

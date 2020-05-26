package com.udemi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    By signUpPopupButtonLocator = By.xpath("//*[text () = 'Sign Up']");
    By userLabelLocator = By.xpath("//span[@class='user-initials']");
    By bannerSearchFieldLocator = By.id("search-field-home");

    public void openHomePage(){
        driver.get("https://www.udemy.com/");
    }

    public void openRegistrationPopup(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpPopupButtonLocator));
        WebElement signUpPopupButton = driver.findElement(signUpPopupButtonLocator);
        signUpPopupButton.click();
    }

    public String getUserLbl() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userLabelLocator));
        WebElement userLabel = driver.findElement(userLabelLocator);
        return userLabel.getText();
    }

    public HomePage enterBannerSearchValue(String bannerSearchValue){
        wait.until(ExpectedConditions.visibilityOfElementLocated(bannerSearchFieldLocator));
        WebElement bannerSearchField = driver.findElement(bannerSearchFieldLocator);
        bannerSearchField.clear();
        bannerSearchField.sendKeys(bannerSearchValue);
        bannerSearchField.submit();
        return this;
    }
}

package com.udemi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPopup {

    private WebDriver driver;
    private WebDriverWait wait;

    public RegistrationPopup (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    By fullNameFieldLocator = By.id("id_fullname");
    By emailFieldLocator = By.xpath("//input[@type='email']");
    By passwordFieldLocator = By.id("password");
    By signUpButtonLocator = By.xpath("//input[@value='Sign Up']");

    public RegistrationPopup enterName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameFieldLocator));
        WebElement fullNameField = driver.findElement(fullNameFieldLocator);
        fullNameField.clear();
        fullNameField.sendKeys(name);
        return this;
    }

    public RegistrationPopup enterEmail (String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public RegistrationPopup enterPassword (String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public void clickOnSignUpButton() {
        WebElement signUpButton = driver.findElement(signUpButtonLocator);
        wait.until(ExpectedConditions.elementToBeClickable(signUpButtonLocator));
        signUpButton.click();
    }
}

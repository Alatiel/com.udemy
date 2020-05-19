package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegistrationTest extends BaseTest{

    @Test(description ="Registration with valid data")
    public void registrationWithValidData(){

        By signUpPopupButtonLocator = By.xpath("//*[text () = 'Sign Up']");
        By fullNameFieldLocator = By.id("id_fullname");
        By emailFieldLocator = By.xpath("//input[@type='email']");
        By passwordFieldLocator = By.id("password");
        By signUpButtonLocator = By.xpath("//input[@value='Sign Up']");
        By userLabelLocator = By.xpath("//span[@class='user-initials']");

        driver.get("https://www.udemy.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpPopupButtonLocator));
        WebElement signUpPopupButton = driver.findElement(signUpPopupButtonLocator);
        signUpPopupButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameFieldLocator));
        WebElement fullNameField = driver.findElement(fullNameFieldLocator);
        fullNameField.clear();
        fullNameField.sendKeys("Test User");

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.clear();
        emailField.sendKeys("lm"+System.currentTimeMillis()+"@appcreative.net");

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.clear();
        passwordField.sendKeys("@@testUser"+System.currentTimeMillis());


        WebElement signUpButton = driver.findElement(signUpButtonLocator);
        wait.until(ExpectedConditions.elementToBeClickable(signUpButtonLocator));
        signUpButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(userLabelLocator));
        WebElement userLabel = driver.findElement(userLabelLocator);
        Assert.assertEquals(userLabel.getText(),"TU");

        pause(5000);

    }

}

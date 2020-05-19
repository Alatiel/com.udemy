package com.udemy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    @Test (description = "Login with valid data")
    public void loginTest(){

        By headerLoginBtnLocator = By.xpath("//button[@data-purpose='header-login']");
        By loginEmailFieldLocator = By.xpath("//input[@name='email']");
        By loginPasswordFieldLocator = By.xpath("//input[@type='password']");
        By loginBtnLocator = By.xpath("//input[@type='submit']");
        By userLabelLocator = By.xpath("//span[@class='user-initials']");

        driver.get("https://www.udemy.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(headerLoginBtnLocator));
        WebElement headerLoginBtn = driver.findElement(headerLoginBtnLocator);
        headerLoginBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmailFieldLocator));
        WebElement loginEmailField = driver.findElement(loginEmailFieldLocator);
        loginEmailField.clear();
        loginEmailField.sendKeys("lm1b@appcreative.net");

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPasswordFieldLocator));
        WebElement loginPasswordField = driver.findElement(loginPasswordFieldLocator);
        loginPasswordField.clear();
        loginPasswordField.sendKeys("@LM123456");

        WebElement loginBtn = driver.findElement(loginBtnLocator);
        wait.until(ExpectedConditions.elementToBeClickable(loginBtnLocator));
        loginBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(userLabelLocator));
        WebElement userLabel = driver.findElement(userLabelLocator);
        Assert.assertEquals(userLabel.getText(),"TT");

        pause(5000);

    }

}

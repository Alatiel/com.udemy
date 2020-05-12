package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;

public class RegistrationTest {
        String Actualtext;

    @Test(description ="Registration with valid data")
    public void registrationWithValidData(){
        File chromeDriver = new File("src/main/resources/chromedriver");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();

        WebDriver driver = new ChromeDriver(chromeService);
        driver.get("https://www.udemy.com/");
        pause(4000);

        WebElement signUpPopupButton = driver.findElement(
                By.xpath("//*[text () = 'Sign Up']"));
        signUpPopupButton.click();
        pause(3000);

        WebElement fullNameField = driver.findElement(By.id("id_fullname"));
        fullNameField.clear();
        fullNameField.sendKeys("Test User");

        WebElement emailField = driver.findElement(
                By.xpath("//input[@type='email']"));
        emailField.clear();
        emailField.sendKeys("lm27@appcreative.net");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("qwerty123");
        pause(1000);

        WebElement signUpButtom = driver.findElement(
                By.xpath("//input[@value='Sign Up']"));
        signUpButtom.click();
        pause(4000);

        Actualtext = driver.findElement(
                By.xpath(("//a[@data-purpose='my-courses']"))).getText();
        Assert.assertEquals(Actualtext,"My courses");

        pause(5000);
        driver.quit();
    }

    private void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

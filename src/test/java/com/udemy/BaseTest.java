package com.udemy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod(description = "Open browser")
    public void openBrowser(){
        File chromeDriver = new File("src/main/resources/chromedriver");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();

        driver = new ChromeDriver(chromeService);
        wait = new WebDriverWait(driver, 5);
    }

    @AfterMethod(description = "Quit Browser")
    public void quitBrowser(){
        driver.quit();
        driver = null;
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

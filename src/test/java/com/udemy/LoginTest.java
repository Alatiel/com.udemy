package com.udemy;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    @Test (description = "Login with Cookies")
    public void loginTest(){

        By userLabelLocator = By.xpath("//span[@class='user-initials']");

        driver.get("https://www.udemy.com/");

        Cookie userLogin = new Cookie("dj_session_id","ue5va8vru50qk5cxbhy4614u9xbxxpm7");
        driver.manage().addCookie(userLogin);

        driver.navigate().refresh();

        wait.until(ExpectedConditions.visibilityOfElementLocated(userLabelLocator));
        WebElement userLabel = driver.findElement(userLabelLocator);
        Assert.assertEquals(userLabel.getText(),"TT");

        pause(5000);

    }

}

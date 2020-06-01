package com.udemy;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.udemi.testdata.UserData.baseUser;

public class LoginTest extends BaseTest {

    @Test (description = "Login with Cookies")
    public void loginTest(){
        homePage.openHomePage();
        Cookie userLogin = new Cookie(baseUser.getCookieName(),baseUser.getCookieValue());
        driver.manage().addCookie(userLogin);
        driver.navigate().refresh();
        Assert.assertEquals(homePage.getUserLbl(),"K");
    }

}

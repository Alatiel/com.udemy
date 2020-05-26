package com.udemy;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test (description = "Login with Cookies")
    public void loginTest(){
        homePage.openHomePage();
        Cookie userLogin = new Cookie("dj_session_id","ue5va8vru50qk5cxbhy4614u9xbxxpm7");
        driver.manage().addCookie(userLogin);
        driver.navigate().refresh();
        Assert.assertEquals(homePage.getUserLbl(),"K");
    }

}

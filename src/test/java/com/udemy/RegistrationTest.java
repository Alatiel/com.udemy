package com.udemy;

import org.testng.Assert;
import org.testng.annotations.*;

public class RegistrationTest extends BaseTest{

    @Test(description ="Registration with valid data")
    public void registrationWithValidData(){

        homePage.openHomePage();
        homePage.openRegistrationPopup();
        registrationPopup
                .enterName("Test User")
                .enterEmail("lm"+System.currentTimeMillis()+"@appcreative.net")
                .enterPassword("@@testUser"+System.currentTimeMillis())
                .clickOnSignUpButton();
        Assert.assertEquals(homePage.getUserLbl(),"TU");
    }
}

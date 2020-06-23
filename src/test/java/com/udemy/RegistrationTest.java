package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.udemi.testdata.UserData.newUser;

public class RegistrationTest extends BaseTest{

    @Test(description ="Registration with valid data")
    public void registrationWithValidData(){

        homePage.openHomePage();
        homePage.openRegistrationPopup();
                registrationPopup
                .enterName(newUser.getName())
                .enterEmail(newUser.getEmail())
                .enterPassword(newUser.getPassword())
                .clickOnSignUpButton();
        Assert.assertEquals(homePage.getUserLbl(),newUser.getUserLbl());
    }
}

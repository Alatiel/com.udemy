package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;


public class CategoriesTest extends BaseTest {

    @Test(description = "Check main site's categories")
    public void categoriesTest(){
        homePage.openHomePage();
        homePage.openHomePageCategoriesMenu();
        Assert.assertEquals(homePage.actualHomePageCategoriesList(), homePage.expectedHomePageCategoriesList());
    }
}

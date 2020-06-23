package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.udemi.constans.BaseConst.EXPECTED_HOMEPAGE_CATEGORIES;


public class CategoriesTest extends BaseTest {

    @Test(description = "Check main site's categories")
    public void categoriesTest()  {
        homePage.openHomePage();
        pause(5000);
        homePage.openHomePageCategoriesMenu();
        Assert.assertEquals(homePage.actualHomePageCategoriesList(), EXPECTED_HOMEPAGE_CATEGORIES) ;
    }
}

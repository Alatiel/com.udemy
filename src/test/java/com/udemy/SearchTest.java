package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(description = "Test banner search functionality")
    public void searchTest(){

        homePage.openHomePage();
        Assert.assertTrue(searchResultPage.isHeaderHomePageSearchFieldLocatorEmpty());
        homePage.enterBannerSearchValue("angular");
        Assert.assertFalse(searchResultPage.getFirstSearchResultTitle().startsWith("PHP"));
        Assert.assertEquals(searchResultPage.containsHeaderSearchField(),"angular" );
        Assert.assertTrue(searchResultPage.getSearchResultTitleText().contains("results for “angular”")
                & searchResultPage.getFirstSearchResultTitle().startsWith("Angular")
                & driver.getCurrentUrl().contains("ref=home"));
    }
}

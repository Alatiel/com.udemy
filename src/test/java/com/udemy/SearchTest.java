package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.udemi.constans.BaseConst.*;

public class SearchTest extends BaseTest {

    @Test(description = "Test banner search functionality")
    public void searchTest(){

        homePage.openHomePage();
        Assert.assertTrue(searchResultPage.isHeaderHomePageSearchFieldLocatorEmpty());
        homePage.enterBannerSearchValue(SEARCH_VALUE);
        Assert.assertFalse(searchResultPage.getFirstSearchResultTitle().startsWith(WRONG_SEARCH_VALUE));
        Assert.assertEquals(searchResultPage.containsHeaderSearchField(),SEARCH_VALUE );
        Assert.assertTrue(searchResultPage.getSearchResultTitleText().contains("results for “"+SEARCH_VALUE+"”")
                & searchResultPage.getFirstSearchResultTitle().startsWith("Angular")
                & driver.getCurrentUrl().contains(URL_ROUT));
    }
}

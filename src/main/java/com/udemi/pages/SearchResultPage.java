package com.udemi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchResultPage (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    By searchResultTitleLocator = By.xpath("//*[@class='search--header-container--2-Reh']");
    By firstSearchResultLocator = By.xpath("(//*[contains(@class,'udlite-focus-visible-target')])[1]");
    By headerSearchFieldLocator = By.xpath("//*[contains(@class,'js-header-search-field')]");


    public String getSearchResultTitleText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultTitleLocator));
        WebElement searchResultTitle = driver.findElement(searchResultTitleLocator);
        return searchResultTitle.getText();
    }
    public String getFirstSearchResultTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstSearchResultLocator));
        WebElement firstSearchResultTitle = driver.findElement(firstSearchResultLocator);
        return firstSearchResultTitle.getText();
    }

    public String containsHeaderSearchField(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerSearchFieldLocator));
        WebElement headerSearchField = driver.findElement(headerSearchFieldLocator);
        return headerSearchField.getAttribute("value");
    }
}

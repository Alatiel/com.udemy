package com.udemi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchResultPage (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath ="//*[@class='search--header-container--2-Reh']")
    private WebElement searchResultTitle;

    @FindBy (xpath ="(//*[contains(@class,'udlite-focus-visible-target')])[1]")
    private WebElement firstSearchResultTitle;

    @FindBy (xpath ="//*[contains(@class,'js-header-search-field')]")
    private WebElement headerSearchField;

    By searchResultTitleLocator = By.xpath("//*[@class='search--header-container--2-Reh']");
    By firstSearchResultLocator = By.xpath("(//*[contains(@class,'udlite-focus-visible-target')])[1]");
    By headerSearchFieldLocator = By.xpath("//*[contains(@class,'js-header-search-field')]");

    
    public String getSearchResultTitleText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultTitleLocator));
        return searchResultTitle.getText();
    }
    public String getFirstSearchResultTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstSearchResultLocator));
        return firstSearchResultTitle.getText();
    }

    public String containsHeaderSearchField(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerSearchFieldLocator));
        return headerSearchField.getAttribute("value");
    }
}

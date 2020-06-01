package com.udemi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static com.udemi.constans.BaseConst.BASE_URL;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    By signUpPopupButtonLocator = By.xpath("//*[text () = 'Sign Up']");
    By userLabelLocator = By.xpath("//span[@class='user-initials']");
    By bannerSearchFieldLocator = By.id("search-field-home");
    By homePageCategoriesButtonLocator = By.xpath("//a[@data-purpose='browse-courses-link']");
    By homePageCategoriesListLocator = By.xpath("//ul[contains(@class,'dropdown-menu__list--level-one')]");

    public void openHomePage(){
        driver.get(BASE_URL);
    }

    public void openRegistrationPopup(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpPopupButtonLocator));
        WebElement signUpPopupButton = driver.findElement(signUpPopupButtonLocator);
        signUpPopupButton.click();
    }

    public String getUserLbl() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userLabelLocator));
        WebElement userLabel = driver.findElement(userLabelLocator);
        return userLabel.getText();
    }

    public HomePage enterBannerSearchValue(String bannerSearchValue){
        wait.until(ExpectedConditions.visibilityOfElementLocated(bannerSearchFieldLocator));
        WebElement bannerSearchField = driver.findElement(bannerSearchFieldLocator);
        bannerSearchField.clear();
        bannerSearchField.sendKeys(bannerSearchValue);
        bannerSearchField.submit();
        return this;
    }
    public void openHomePageCategoriesMenu(){
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageCategoriesButtonLocator));
        WebElement homePageCategoriesButton = driver.findElement(homePageCategoriesButtonLocator);
        action.moveToElement(homePageCategoriesButton);
        action.perform();
    }

    public List<String> actualHomePageCategoriesList (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageCategoriesListLocator));
        WebElement homePageCategoriesMenuList = driver.findElement(homePageCategoriesListLocator);
        List<WebElement> homePageCategoriesList = homePageCategoriesMenuList.findElements(By.tagName("li"));

        List<String> homePageCategories=new ArrayList<>();

        for (WebElement webElement : homePageCategoriesList) {
            homePageCategories.add(webElement.getText());
            //System.out.println(homePageCategoriesList.get(i).getText()); //for elements checking
        }

        return homePageCategories;
    }
}

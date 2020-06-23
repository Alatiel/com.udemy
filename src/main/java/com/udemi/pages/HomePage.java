package com.udemi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
        PageFactory.initElements(driver,this);
    }
    @FindAll({
            @FindBy(xpath = "//a[contains(.,'Sign ')]"),
            @FindBy(xpath = "//*[@data-purpose='header-signup']")
    })
    private WebElement signUpPopupButton;

    @FindBy(xpath = "//span[@class='user-avatar__inner fx-c']")
    private WebElement userLabel;

    @FindBy(xpath = "//*[@placeholder='What do you want to learn?']")
    private WebElement bannerSearchField;

    @FindBy(xpath = "//*[@data-purpose='browse-courses-link' or text()='Categories']")
    private WebElement homePageCategoriesButton;

    @FindAll({
            @FindBy(xpath = "//*[contains(@class,'dropdown-menu__list--level-one')]"),
            @FindBy(xpath = "//*[contains(@class,'js-browse-nav-level-one')]")
    })
    private WebElement homePageCategoriesMenuList;

    By signUpPopupButtonLocator = By.xpath("//a[contains(.,'Sign ')] | //*[@data-purpose='header-signup']");
    By userLabelLocator = By.xpath("//span[@class='user-avatar__inner fx-c']");
    By bannerSearchFieldLocator = By.xpath("//*[@placeholder='What do you want to learn?']");
    By homePageCategoriesButtonLocator = By.xpath("//*[@data-purpose='browse-courses-link' or text()='Categories']");
    By homePageCategoriesListLocator = By.xpath("//*[contains(@class,'dropdown-menu__list--level-one')] | //*[contains(@class,'js-browse-nav-level-one')]");

    public void openHomePage(){
        driver.get(BASE_URL);
    }

    public void openRegistrationPopup(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpPopupButtonLocator));
        signUpPopupButton.click();
    }

    public String getUserLbl() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userLabelLocator));
        return userLabel.getText();
    }

    public void enterBannerSearchValue(String bannerSearchValue){
        wait.until(ExpectedConditions.visibilityOfElementLocated(bannerSearchFieldLocator));
        bannerSearchField.clear();
        bannerSearchField.sendKeys(bannerSearchValue);
        bannerSearchField.submit();
    }
    public void openHomePageCategoriesMenu() {
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageCategoriesButtonLocator));
        action.moveToElement(homePageCategoriesButton);
        action.perform();
    }

    public List<String> actualHomePageCategoriesList (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageCategoriesListLocator));
        List<WebElement> homePageCategoriesList = homePageCategoriesMenuList.findElements(By.tagName("li"));
        List<String> homePageCategories=new ArrayList<>();
        for (WebElement webElement : homePageCategoriesList) {
            homePageCategories.add(webElement.getText());
        }
        return homePageCategories;
    }
}

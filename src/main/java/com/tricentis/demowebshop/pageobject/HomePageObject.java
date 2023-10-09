package com.tricentis.demowebshop.pageobject;

import com.tricentis.demowebshop.common.BasePage;
import com.tricentis.demowebshop.helper.Log;
import com.tricentis.demowebshop.interfaces.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageObject clickLoginLink(){
        Log.allure("Click on Login link on Homepage");
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return new LoginPageObject(driver);
    }

    public ProductListPageObject clickBookTopMenuLink(){
        Log.allure("Click on Book subcategory on top menu");
        clickToElement(driver,HomePageUI.TOPMENU_DYNAMIC_LINK,"Books");
        return  new ProductListPageObject(driver);
    }
}

package com.tricentis.demowebshop.pageobject;

import com.tricentis.demowebshop.common.BasePage;
import com.tricentis.demowebshop.helper.Log;
import com.tricentis.demowebshop.interfaces.HomePageUI;
import com.tricentis.demowebshop.interfaces.WelcomeSignInPageUI;
import org.openqa.selenium.WebDriver;

public class WelcomeSignInPageObject extends BasePage {
    private WebDriver driver;

    public WelcomeSignInPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public CheckOutPageObject clickCheckOutAsGuest(){
        Log.allure("Click on Book subcategory on top menu");
        clickToElement(driver, WelcomeSignInPageUI.CHECK_OUT_AS_GUEST_BTN);
        return  new CheckOutPageObject(driver);
    }
}

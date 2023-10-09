package com.tricentis.demowebshop.pageobject;

import com.tricentis.demowebshop.helper.Log;
import org.openqa.selenium.WebDriver;

public class PageGenerator{
    public static HomePageObject getHomepage(WebDriver driver) {
        Log.allure("Open Home page");
        return new HomePageObject(driver);
    }

    public static LoginPageObject getLoginPage(WebDriver driver) {
        Log.allure("Open Login page");
        return new LoginPageObject(driver);
    }
}

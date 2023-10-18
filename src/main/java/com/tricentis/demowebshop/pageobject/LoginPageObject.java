package com.tricentis.demowebshop.pageobject;

import com.tricentis.demowebshop.common.BasePage;
import com.tricentis.demowebshop.helper.Log;
import com.tricentis.demowebshop.interfaces.LoginPageUI;
import com.tricentis.demowebshop.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class LoginPageObject extends BasePage{
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {

        this.driver = driver;
    }

    public void verifyTitleOfLoginPage(){
        Log.allure("Verify title of Login Page");
        Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login");
    }
    public void Login(String email, String password){
        Log.allure("enter Email " + email+ " and Password " +password);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TXT,email);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TXT,password);
        clickToElement(driver, LoginPageUI.LOGIN_BTN);
    }
    public void verifyMessage(String expectedMessage) {
        Assert.assertTrue(isElementDisplay(driver,LoginPageUI.ERROR_MESSAGE,expectedMessage));
    }
}

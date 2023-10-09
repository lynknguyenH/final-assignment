package com.tricentis.demowebshop.pageobject;

import com.tricentis.demowebshop.common.BasePage;
import com.tricentis.demowebshop.helper.Log;
import com.tricentis.demowebshop.interfaces.LoginUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageObject extends BasePage{
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void Login(String email, String password){
        Log.allure("enter Email " + email+ " and Password " +password);
        sendKeyToElement(driver, LoginUI.EMAIL_TXT,email);
        sendKeyToElement(driver,LoginUI.PASSWORD_TXT,password);
        clickToElement(driver,LoginUI.LOGIN_BTN);
    }

    public void verifyMessage(String expectedMessage){
        Boolean isMessageDisplayed = isElementDisplay(driver,LoginUI.ERROR_MESSAGE);
        if(isMessageDisplayed){
            String actualMessage = getTextElement(driver,LoginUI.ERROR_MESSAGE);
            Assert.assertEquals(actualMessage,expectedMessage);
            Log.allure("Expected Message: "+expectedMessage + "Actual Message: " +actualMessage);
        }else if (!isMessageDisplayed){
            Log.allure("Login successfully");
        }else {
            String validatedMessage = getTextElement(driver,LoginUI.VALIDATED_MESSAGE);
            Assert.assertEquals(validatedMessage,expectedMessage);
            Log.allure("Expected Message: "+expectedMessage + "Validated Message: " + validatedMessage);
        }
    }
}

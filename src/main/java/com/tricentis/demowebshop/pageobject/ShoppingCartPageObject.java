package com.tricentis.demowebshop.pageobject;

import com.tricentis.demowebshop.common.BasePage;
import com.tricentis.demowebshop.helper.Log;
import com.tricentis.demowebshop.interfaces.HomePageUI;
import com.tricentis.demowebshop.interfaces.ShoppingCartPageUI;
import com.tricentis.demowebshop.interfaces.WelcomeSignInPageUI;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPageObject extends BasePage {
    private WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean decreaseQuantityOfProduct(int number){
        int itemNumBefore = Integer.parseInt(getAttributeElement(driver, ShoppingCartPageUI.QUANTITY_TXT,"value"));
        Log.allure("Number of Items in cart " +itemNumBefore);
        Log.allure("Take one item out of the cart");
        sendKeyToElement(driver, ShoppingCartPageUI.QUANTITY_TXT, String.valueOf(number));
        clickToElement(driver,ShoppingCartPageUI.UPDATE_SHOPPING_CART_BTN);
        int itemNumAfter = Integer.parseInt(getAttributeElement(driver, ShoppingCartPageUI.QUANTITY_TXT,"value"));
        Log.allure("Number of Items in cart after take out one item " +itemNumAfter);
        return (itemNumBefore - 1) == itemNumAfter;
    }

    public WelcomeSignInPageObject clickCheckOut(){
        Log.allure("Click on Checkout Button");
        clickToElement(driver,ShoppingCartPageUI.TERM_OF_SERVICE_CKB);
        clickToElement(driver, ShoppingCartPageUI.CHECK_OUT_BTN);
        return  new WelcomeSignInPageObject(driver);
    }
}

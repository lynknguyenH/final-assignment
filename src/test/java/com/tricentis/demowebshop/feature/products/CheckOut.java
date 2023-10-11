package com.tricentis.demowebshop.feature.products;

import com.tricentis.demowebshop.common.BaseTest;
import com.tricentis.demowebshop.helper.Log;
import com.tricentis.demowebshop.interfaces.CheckOutPageUI;
import com.tricentis.demowebshop.pageobject.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("demowebshop")
@Feature("Shopping Cart")
@Story("Check out")
public class CheckOut extends BaseTest {
    private WebDriver driver;
    private String expectedMessage1 = "The product has been added to your shopping cart";
    private String expectedMessage2 = "Your order has been successfully processed!";
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(@Optional("CHROME") String browser) {
        Log.allure("Start Browser " + browser);
        driver = getBrowserDriver(browser);
    }

    @Test
    public void checkOutSuccessfully(){
        HomePageObject homePage = PageGenerator.getHomepage(driver);
        homePage.verifyTitle(driver,"Demo Web Shop");
        ProductListPageObject productListPage = homePage.clickDigitalDownloadLink();
        productListPage.addRandomProductToCard(expectedMessage1);
        ShoppingCartPageObject shoppingCartPage = homePage.clickOnShoppingCart();
        WelcomeSignInPageObject welcomeSignInPage = shoppingCartPage.clickCheckOut();
        CheckOutPageObject checkOutPage = welcomeSignInPage.clickCheckOutAsGuest();
        checkOutPage.inputInfoOfCheckout();
        Assert.assertEquals(checkOutPage.getTextElement(driver,CheckOutPageUI.INFO_CHECKOUT_LBL,"2"),"Linh Nguyen");
        Assert.assertEquals(checkOutPage.getTextElement(driver,CheckOutPageUI.INFO_CHECKOUT_LBL,"3"),"Email: linh@gmail.com");
        Assert.assertEquals(checkOutPage.getTextElement(driver,CheckOutPageUI.INFO_CHECKOUT_LBL,"4"),"Phone: 928272232");
        Assert.assertEquals(checkOutPage.getTextElement(driver,CheckOutPageUI.INFO_CHECKOUT_LBL,"6"),"abc");
        Assert.assertEquals(checkOutPage.getTextElement(driver,CheckOutPageUI.INFO_CHECKOUT_LBL,"7"),"abd street");
        Assert.assertEquals(checkOutPage.getTextElement(driver,CheckOutPageUI.INFO_CHECKOUT_LBL,"9"),"Viet Nam");
        Assert.assertEquals(checkOutPage.getTextElement(driver,CheckOutPageUI.INFO_CHECKOUT_LBL,"11"),"Cash On Delivery (COD)");
        checkOutPage.sleepInSecond(10);
        boolean isCorrectTotal = checkOutPage.verifyTotal();
        Assert.assertTrue(isCorrectTotal);
        checkOutPage.clickToElement(driver, CheckOutPageUI.CONFIRM_BNT);
        String actualMsg = checkOutPage.getTextElement(driver, CheckOutPageUI.MESSAGE_SUCCESS_LBL);
        Assert.assertEquals(actualMsg,expectedMessage2);
        checkOutPage.clickToElement(driver,CheckOutPageUI.CONTINUE_FINAL_BNT);
        homePage.verifyTitle(driver,"Demo Web Shop");
    }

}

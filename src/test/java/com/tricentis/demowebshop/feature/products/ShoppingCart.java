package com.tricentis.demowebshop.feature.products;

import com.tricentis.demowebshop.common.BaseTest;
import com.tricentis.demowebshop.helper.Log;
import com.tricentis.demowebshop.pageobject.HomePageObject;
import com.tricentis.demowebshop.pageobject.PageGenerator;
import com.tricentis.demowebshop.pageobject.ProductListPageObject;
import com.tricentis.demowebshop.pageobject.ShoppingCartPageObject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("demowebshop")
@Feature("Shopping Cart")
public class ShoppingCart extends BaseTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(@Optional("CHROME") String browser) {
        Log.allure("Start Browser " + browser);
        driver = getBrowserDriver(browser);
    }

    @Test
    public void decreaseItemsOfShoppingCart(){
        HomePageObject homePage = PageGenerator.getHomepage(driver);
        homePage.verifyTitle(driver,"Demo Web Shop");
        homePage.scrollToBottomPage(driver);
        ProductListPageObject productListPage = new ProductListPageObject(driver);
        String expectedMessage = "The product has been added to your shopping cart";
        productListPage.addSpecificProductToCart(expectedMessage,"14.1-inch Laptop");
        ShoppingCartPageObject shoppingCartPage = homePage.clickOnShoppingCart();
        shoppingCartPage.verifyTitle(driver,"Demo Web Shop. Shopping Cart");
        boolean isQuantityDecrease = shoppingCartPage.decreaseQuantityOfProduct(2);
        Assert.assertTrue(isQuantityDecrease);
    }
}

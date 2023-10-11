package com.tricentis.demowebshop.feature.products;

import com.tricentis.demowebshop.common.BaseTest;
import com.tricentis.demowebshop.helper.Log;
import com.tricentis.demowebshop.pageobject.HomePageObject;
import com.tricentis.demowebshop.pageobject.PageGenerator;
import com.tricentis.demowebshop.pageobject.ProductListPageObject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

@Epic("demowebshop")
@Feature("Top Menu - Books")
@Story("Add Product to card")
public class BooksProduct extends BaseTest {

    private WebDriver driver;
    private String expectedMessage = "The product has been added to your shopping cart";
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(@Optional("CHROME") String browser) {
        Log.allure("Start Browser " + browser);
        driver = getBrowserDriver(browser);
    }
    @Test
    public void addProductWithHighestRatingToCard(){
        HomePageObject homePage = PageGenerator.getHomepage(driver);
        homePage.verifyTitle(driver,"Demo Web Shop");
        ProductListPageObject productListPage = homePage.clickBookTopMenuLink();
        productListPage.verifyTitle(driver,"Demo Web Shop. Books");
        List<String> addedProducts = productListPage.addHighestRatingProductToCart(expectedMessage);
        Log.allure("List of product was added to cart: " +addedProducts);
        List<String> productsInCart = productListPage.getProductListInCart();
        Log.allure("List product in cart: " +productsInCart);
        boolean isProductAdded = productListPage.verifyProductAddedToCart(addedProducts,productsInCart);
        productListPage.sleepInSecond(10);
        Assert.assertTrue(isProductAdded);
    }
}

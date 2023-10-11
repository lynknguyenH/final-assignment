package com.tricentis.demowebshop.pageobject;

import com.tricentis.demowebshop.common.BasePage;
import com.tricentis.demowebshop.helper.Log;
import com.tricentis.demowebshop.interfaces.ProductListPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductListPageObject extends BasePage {
    private final WebDriver driver;

    public ProductListPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getProductListWithSortedRating() {
        List<WebElement> ratingOfProducts = getListWebElements(driver, ProductListPageUI.RATING_OF_PRODUCTS_CAN_ADDTOCART);
        List<String> productListRating = new ArrayList<>();
        for (WebElement ratingOfProduct : ratingOfProducts) {
            String rating = ratingOfProduct.getAttribute("style");
            String ratePercent = rating.substring(7, 9);
            productListRating.add(ratePercent);
        }
        productListRating.sort(Collections.reverseOrder());
        return productListRating;
    }

    public List<String> getProductListInCart(){
        hoverOverShoppingCart();
        List<WebElement> listElement = getListWebElements(driver,ProductListPageUI.PRODUCT_IN_CART);
        List<String> productNameList = new ArrayList<>();
        for (WebElement webElement : listElement) {
            productNameList.add(webElement.getText());
        }
        Collections.sort(productNameList);
        return productNameList;
    }

    public List<String> addProductToCart(String expectedMessage) {
        List<String> productCanAddToCard = getProductListWithSortedRating();
        List<String> productAddedToCard = new ArrayList<>();
        for (int i = 0; i<2 ; i++){
            productAddedToCard.add(getTextElement(driver,ProductListPageUI.PRODUCTNAME_DYNAMIC,productCanAddToCard.get(i)));
            clickToElement(driver, ProductListPageUI.ADDTOCARD_DYNAMIC_BTN, productCanAddToCard.get(i), "1");
            waitForElementInvisible(driver,ProductListPageUI.LOADING_IMAGE);
            verifyMessage(expectedMessage);
            waitForElementInvisible(driver,ProductListPageUI.ADDTOCART_MESSAGE1);
            verifyNumberOfItems((i+1) + " item(s)");
            Log.allure("Number of items in cart: " +(i+1));
        }
        Collections.sort(productAddedToCard);
        return productAddedToCard;
    }

    public List<String> getProductNameList(){
        List<String> productCanAddToCard = getProductListWithSortedRating();
        List<String> productNameList = new ArrayList<>();
        for (String s : productCanAddToCard) {
            productNameList.add(getTextElement(driver, ProductListPageUI.PRODUCTNAME_DYNAMIC, s));
        }
        return productNameList;
    }

    public void addSpecificProductToCart(String expectedMessage, String productName) {
        List<String> productList = getProductNameList();
        for (String product:productList){
            if(product.equals(productName)){
                for(int i = 0; i < 3; i++){
                    clickToElement(driver, ProductListPageUI.ADD_TO_CART_SPECIFIC_PRODUCT,productList.get(i));
                    waitForElementInvisible(driver,ProductListPageUI.LOADING_IMAGE);
                    verifyMessage(expectedMessage);
                    waitForElementInvisible(driver,ProductListPageUI.ADDTOCART_MESSAGE1);
                    verifyNumberOfItems((i+1) + " item(s)");
                    Log.allure("Number of items in cart: " +(i+1));
                }
            }
        }
    }

    public boolean verifyProductAddedToCart(List<String> list1,List<String> list2){
        return list1.equals(list2);
    }

    public void verifyMessage(String expectedMessage){
        String actualMessage = getTextElement(driver,ProductListPageUI.ADDTOCART_MESSAGE1);
        Log.allure("Verify message when add product to cart. Expect message: " + expectedMessage +
                " Actual message: " + actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    public void verifyNumberOfItems(String expectedItem){
        scrollToTopPage(driver);
        hoverOverShoppingCart();
        Assert.assertEquals(getTextElement(driver,ProductListPageUI.ITEMNUMBER_LBL),expectedItem);
    }

    public void hoverOverShoppingCart(){
        hoverMouseToElement(driver,ProductListPageUI.SHOPPINGCART_LINK);
    }
}

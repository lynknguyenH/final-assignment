package com.tricentis.demowebshop.pageobject;

import com.tricentis.demowebshop.common.BasePage;
import com.tricentis.demowebshop.helper.Log;
import com.tricentis.demowebshop.interfaces.ProductListPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductListPageObject extends BasePage {
    private WebDriver driver;

    public ProductListPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getProductListWithSortedRating() {
        List<WebElement> addToCartElements = getListWebElements(driver, ProductListPageUI.ADDTOCART_BTN);
        List<WebElement> ratingElements = new ArrayList<>();
        for (int i = 0; i < addToCartElements.size(); i++) {
            ratingElements.add(getWebElement(driver,ProductListPageUI.RATING_DYNAMIC, String.valueOf(i+1)));
        }
        List<String> productListRating = new ArrayList<>();
        for (int i = 0; i < addToCartElements.size(); i++) {
            String rating = ratingElements.get(i).getAttribute("style");
            String ratePercent = rating.substring(7, 9);
            productListRating.add(ratePercent);
        }
        Collections.sort(productListRating);
        return productListRating;
    }

    public List<String> getProductNameList(int number){
        List<String> productCanAddToCard = getProductListWithSortedRating();
        List<String> productNameList = new ArrayList<>();
        for (int i = 0; i<number ; i++){
            productNameList.add(getTextElement(driver,ProductListPageUI.PRODUCTNAME_DYNAMIC,productCanAddToCard.get(i)));
        }
        return productNameList;
    }
    public List<String> getProductListInCart(){
        List<WebElement> listElement = getListWebElements(driver,ProductListPageUI.PRODUCTINCART);
        List<String> productNameList = new ArrayList<>();
        for (int i = 0; i<listElement.size() ; i++){
            productNameList.add(listElement.get(i).getText());
        }
        Collections.sort(productNameList);
        return productNameList;
    }

    public List<String> addProductToCart(String expectedMessage) {
        List<String> productCanAddToCard = getProductListWithSortedRating();
        Log.allure("List rating: " +productCanAddToCard.toString());
        List<String> productAddedToCard = new ArrayList<>();
        for (int i = 0; i<2 ; i++){
            productAddedToCard.add(getTextElement(driver,ProductListPageUI.PRODUCTNAME_DYNAMIC,productCanAddToCard.get(i)));
            clickToElement(driver, ProductListPageUI.ADDTOCARD_DYNAMIC_BTN, productCanAddToCard.get(i), String.valueOf(i+1));
            verifyMessage(expectedMessage);
            hoverOverShoppingCart();
            verifyNumberOfItems((i+1) + " item(s)");
        }
        Collections.sort(productAddedToCard);
        return productAddedToCard;
    }

    public boolean verifyProductAddedToCart(List<String> list1,List<String> list2){
        Log.allure("List of product added to cart: " +list1.toString());
        Log.allure("List of product in the cart: " +list2.toString());
        if(list1.equals(list2)){
            return true;
        }else
            return false;
    }

    public void verifyMessage(String expectedMessage){
        String actualMessage = getTextElement(driver,ProductListPageUI.ADDTOCART_MESSAGE1);
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    public void verifyNumberOfItems(String expectedItem){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getTextElement(driver,ProductListPageUI.ITEMNUMBER_LBL),expectedItem);
    }

    public void hoverOverShoppingCart(){
        hoverMouseToElement(driver,ProductListPageUI.SHOPPINGCART_LINK);
    }
}

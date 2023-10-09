package com.tricentis.demowebshop.pageobject;

import com.tricentis.demowebshop.common.BasePage;
import com.tricentis.demowebshop.interfaces.ProductListPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductListPageObject extends BasePage {
    private WebDriver driver;

    public ProductListPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private List<String> getProductListWithRating() {
        List<WebElement> elements = getListWebElements(driver, ProductListPageUI.ALL_PRODUCT_HAVE_RATING);
        List<String> productListRating = new ArrayList<>();
        for (WebElement element : elements) {
            String rating = element.getAttribute("style");
            String ratePercent = rating.substring(7, 8);
            productListRating.add(ratePercent);
        }
        return productListRating;
    }

    public List<String> getProductListCanAddToCart() {
        List<String> ratingList = getProductListWithRating();
        List<String> productCanAddToCard = new ArrayList<>();
        for (String ratePercent : ratingList) {
            boolean isAddToCardDisplayed = isElementDisplay(driver, ProductListPageUI.ADDTOCARD_DYNAMIC_BTN, ratePercent);
            if (isAddToCardDisplayed) {
                productCanAddToCard.add(ratePercent);
            }
        }
        Collections.sort(productCanAddToCard);
        return productCanAddToCard;
    }

    public void addProductToCart(String ratePercent) {
        clickToElement(driver, ProductListPageUI.ADDTOCARD_DYNAMIC_BTN, ratePercent);
    }


    public void verifyMessage(String expectedMessage){
        String actualMessage = getTextElement(driver,ProductListPageUI.ADDTOCARD_MESSAGE1) +" "+
                getTextElement(driver,ProductListPageUI.ADDTOCARD_MESSAGE2);
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    public void verifyNumberOfItems(String expectedItem){
        Assert.assertEquals(getTextElement(driver,ProductListPageUI.ITEMNUMBER_LBL),expectedItem);
    }

    public void hoverOverShoppingCart(){
        hoverMouseToElement(driver,ProductListPageUI.SHOPPINGCART_LINK);
    }
}

package com.tricentis.demowebshop.interfaces;

public class ProductListPageUI {
    public static final String ALL_PRODUCT_HAVE_RATING= "//div[contains(@style,'width')]";
    public static final String ADDTOCART_BTN= "//input[@value='Add to cart']";
    public static final String RATING_DYNAMIC= "(//input[@value='Add to cart'])[%s]//preceding::div[contains(@style,'width')]";
    public static final String PRODUCTNAME_DYNAMIC= "//div[contains(@style,'%s')]/../../parent::div//h2//a";
    public static final String ADDTOCARD_DYNAMIC_BTN= "(//div[contains(@style,'%s')]//following::input)[%s]";
    public static final String LOADING_IMAGE= "//div[@class='loading-image']";
    public static final String PRODUCT_IN_CART = "//div[@class='name']//a";
    public static final String ADDTOCART_MESSAGE1= "//p[@class='content']";
    public static final String ADDTOCART_MESSAGE2= "//p[@class='content']//a";
    public static final String ITEMNUMBER_LBL= "//a[@class='items']";
    public static final String SHOPPINGCART_LINK= "//li[@id='topcartlink']//a";
    public static final String RATING_OF_PRODUCTS_CAN_ADDTOCART= "//input[@value='Add to cart']/../..//" +
                                                                "preceding-sibling::div[@class='product-rating-box']" +
                                                                "//div[@class='rating']//div";
    public static final String SPECIFIC_PRODUCT_BY_NAME= "//h2[contains(.,'%s')]";
    public static final String ADD_TO_CART_SPECIFIC_PRODUCT= "//h2[contains(.,'14.1-inch Laptop')]//parent::div//div//div//input";
}

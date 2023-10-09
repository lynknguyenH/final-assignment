package com.tricentis.demowebshop.interfaces;

public class ProductListPageUI {
    public static final String ALL_PRODUCT_HAVE_RATING= "//div[contains(@style,'width')]";
    public static final String ADDTOCARD_BTN= "//input[@value='Add to cart']";
    public static final String ADDTOCARD_DYNAMIC_BTN= "//div[contains(@style,'%s')]//following::input";
    public static final String ADDTOCARD_MESSAGE1= "//p[@class='content']";
    public static final String ADDTOCARD_MESSAGE2= "//p[@class='content']//a";
    public static final String ITEMNUMBER_LBL= "//a[@class='items']";
    public static final String SHOPPINGCART_LINK= "//li[@id='topcartlink']//a";
}

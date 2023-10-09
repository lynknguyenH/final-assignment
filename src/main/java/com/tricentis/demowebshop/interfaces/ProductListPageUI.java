package com.tricentis.demowebshop.interfaces;

public class ProductListPageUI {
    public static final String ALL_PRODUCT_HAVE_RATING= "//div[contains(@style,'width')]";
    public static final String ADDTOCART_BTN= "//input[@value='Add to cart']";
    public static final String RATING_DYNAMIC= "(//input[@value='Add to cart'])[%s]//preceding::div[contains(@style,'width')]";
    public static final String PRODUCTNAME_DYNAMIC= "//div[contains(@style,'%s')]/../../parent::div//h2//a";
    public static final String ADDTOCARD_DYNAMIC_BTN= "(//div[contains(@style,'%s')]//following::input)[%s]";
    public static final String PRODUCTINCART= "//div[@class='name']//a";
    public static final String ADDTOCART_MESSAGE1= "//p[@class='content']";
    public static final String ADDTOCART_MESSAGE2= "//p[@class='content']//a";
    public static final String ITEMNUMBER_LBL= "//a[@class='items']";
    public static final String SHOPPINGCART_LINK= "//li[@id='topcartlink']//a";
}

package com.tricentis.demowebshop.interfaces;

public class ShoppingCartPageUI {
    public static final String PRODUCT_NAME_LBL= "//a[@class='product-name' and contains(text(),'%s')]";
    public static final String PRODUCT_NAME_LIST_LBL= "//a[@class='product-name' and contains(text(),'%s')]";
    public static final String QUANTITY_TXT= "//input[@class='qty-input']";
    public static final String UPDATE_SHOPPING_CART_BTN= "//input[@name='updatecart']";
    public static final String TERM_OF_SERVICE_CKB= "//input[@id='termsofservice']";
    public static final String CHECK_OUT_BTN= "//button[@id='checkout']";
}

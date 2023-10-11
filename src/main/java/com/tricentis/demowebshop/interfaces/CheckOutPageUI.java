package com.tricentis.demowebshop.interfaces;

public class CheckOutPageUI {
    public static final String FIRST_NAME_TXT = "//input[@id='BillingNewAddress_FirstName']";
    public static final String LAST_NAME_TXT = "//input[@id='BillingNewAddress_LastName']";
    public static final String EMAIL_TXT = "//input[@id='BillingNewAddress_Email']";
    public static final String COMPANY_TXT = "//input[@id='BillingNewAddress_Company']";
    public static final String COUNTRY_DDL = "//select[@id='BillingNewAddress_CountryId']";
    public static final String CITY_TXT = "//input[@id='BillingNewAddress_City']";
    public static final String ADDRESS1_TXT = "//input[@id='BillingNewAddress_Address1']";
    public static final String ADDRESS2_TXT = "//input[@id='BillingNewAddress_Address2']";
    public static final String ZIP_CODE_TXT= "//input[@id='BillingNewAddress_ZipPostalCode']";
    public static final String PHONE_NUMBER_TXT = "//input[@id='BillingNewAddress_PhoneNumber']";
    public static final String CONTINUE_BNT = "//div[@id='%s']//input";
    public static final String CONFIRM_BNT = "//div[@id='confirm-order-buttons-container']//input";
    public static final String CONTINUE_FINAL_BNT = "//input[@value='Continue']";
    public static final String INFO_CHECKOUT_LBL = "(//ul[@class='billing-info']//li)[%s]";
    public static final String SUB_TOTAL_LBL = "(//span[@class='product-price'])[1]";
    public static final String FEE_LBL = "(//span[@class='product-price'])[2]";
    public static final String TOTAL_LBL = "//span[@class='product-price order-total']//strong";
    public static final String MESSAGE_SUCCESS_LBL = "//div[@class='title']//strong";


}

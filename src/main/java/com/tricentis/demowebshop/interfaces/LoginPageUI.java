package com.tricentis.demowebshop.interfaces;

public class LoginPageUI {
    public static final String EMAIL_TXT = "//input[@id='Email']";
    public static final String PASSWORD_TXT = "//input[@id='Password']";
    public static final String REMEMBERME_CKB = "//input[@id='RememberMe']";
    public static final String LOGIN_BTN = "//input[@value='Log in']";
    public static final String ERROR_MESSAGE = "//*[contains(text(),'%s')]";
    public static final String VALIDATED_MESSAGE = "//span[@for='Email']";
}

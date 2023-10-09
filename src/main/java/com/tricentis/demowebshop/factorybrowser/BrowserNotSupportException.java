package com.tricentis.demowebshop.factorybrowser;

import org.openqa.selenium.WebDriver;

public class BrowserNotSupportException extends IllegalStateException{
    private static final long serialVersionUID = 1L;

    public BrowserNotSupportException(String browserName) {
        super(String.format("Browser not support : %s", browserName));
    }
}

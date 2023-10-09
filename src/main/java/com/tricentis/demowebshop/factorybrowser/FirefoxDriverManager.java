package com.tricentis.demowebshop.factorybrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--disable-inforbars");
        firefoxOptions.addArguments("--disable-notifications");
        firefoxOptions.setBinary(firefoxBinary);
        firefoxOptions.setHeadless(true);
        return new FirefoxDriver(firefoxOptions);
    }
}

package com.tricentis.demowebshop.factorybrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadlessDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-inforbars");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--headless");
        return new ChromeDriver(chromeOptions);
    }
}

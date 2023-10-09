package com.tricentis.demowebshop.factorybrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--disable-inforbars");
        edgeOptions.addArguments("--disable-notifications");
        return new EdgeDriver(edgeOptions);
    }
}

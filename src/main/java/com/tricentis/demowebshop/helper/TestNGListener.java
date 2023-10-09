package com.tricentis.demowebshop.helper;

import com.tricentis.demowebshop.common.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        Log.info("Test start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("Test success");
        Log.info("---------- " + result.getName() + " pass test ----------");
        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
//        saveScreenShot(webDriver);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info("Test skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        Log.info("Start");
    }

    @Override
    public void onFinish(ITestContext context) {
        Log.info("Finish");
    }

//    @Attachment()
//    public static byte[] saveScreenShot(WebDriver driver) {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.info("---------- " + result.getName() + " FAILED test ----------");
        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
//        saveScreenShot(webDriver);
    }
}

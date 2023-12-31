package com.tricentis.demowebshop.feature.login;

import com.tricentis.demowebshop.common.BaseTest;
import com.tricentis.demowebshop.helper.Log;
import com.tricentis.demowebshop.pageobject.HomePageObject;
import com.tricentis.demowebshop.pageobject.LoginPageObject;
import com.tricentis.demowebshop.pageobject.PageGenerator;
import com.tricentis.demowebshop.utilities.ExcelUtils;
import com.tricentis.demowebshop.utilities.Utilities;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Epic("demowebshop")
@Feature("Login")
public class Login extends BaseTest {
    private WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(@Optional("CHROME") String browser) {
        Log.allure("Start Browser " + browser);
        driver = getBrowserDriver(browser);
    }
    @BeforeTest
    public void setTestData(){
        Log.allure("Read test data");
        ExcelUtils.setExcelFileSheet("LoginData");
    }

    @Test(dataProvider = "testdata",  dataProviderClass = Utilities.class)
    public void VerifyLoginForm(String STT, String userName, String password, String expectedMessage){
        HomePageObject homePage = PageGenerator.getHomepage(driver);
        homePage.verifyTitleOfHomePage();
        LoginPageObject loginPage = homePage.clickLoginLink();
        loginPage.verifyTitleOfLoginPage();
        loginPage.Login(userName,password);
        loginPage.verifyMessage(expectedMessage);
    }
}

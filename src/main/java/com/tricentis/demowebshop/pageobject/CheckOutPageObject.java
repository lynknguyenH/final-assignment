package com.tricentis.demowebshop.pageobject;

import com.tricentis.demowebshop.common.BasePage;
import com.tricentis.demowebshop.helper.Log;
import com.tricentis.demowebshop.interfaces.CheckOutPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckOutPageObject extends BasePage {
    private WebDriver driver;

    List<String> personInfo = new ArrayList<>(
            List.of("Linh",
                    "Nguyen",
                    "linh@gmail.com",
                    "abc",
                    "Viet Nam",
                    "Hanoi",
                    "abd street",
                    "10000",
                    "928272232",
                    "Cash On Delivery (COD)"));
    List<String> continueButtonArr = new ArrayList<>(
        List.of("billing-buttons-container",
                "payment-method-buttons-container",
                "payment-info-buttons-container",
                "confirm-order-buttons-container"));

    public CheckOutPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void inputInfoOfCheckout(){
        Log.allure("Enter information for Billing Address");
        sendKeyToElement(driver, CheckOutPageUI.FIRST_NAME_TXT,personInfo.get(0));
        sendKeyToElement(driver,CheckOutPageUI.LAST_NAME_TXT,personInfo.get(1));
        sendKeyToElement(driver,CheckOutPageUI.EMAIL_TXT,personInfo.get(2));
        sendKeyToElement(driver,CheckOutPageUI.COMPANY_TXT,personInfo.get(3));
        selectItemInDefaultDropdownByText(driver,CheckOutPageUI.COUNTRY_DDL,personInfo.get(4));
        sendKeyToElement(driver,CheckOutPageUI.CITY_TXT,personInfo.get(5));
        sendKeyToElement(driver,CheckOutPageUI.ADDRESS1_TXT,personInfo.get(6));
        sendKeyToElement(driver,CheckOutPageUI.ZIP_CODE_TXT,personInfo.get(7));
        sendKeyToElement(driver,CheckOutPageUI.PHONE_NUMBER_TXT,personInfo.get(8));
        clickToElement(driver,CheckOutPageUI.CONTINUE_BNT,continueButtonArr.get(0));
        clickToElement(driver,CheckOutPageUI.CONTINUE_BNT,continueButtonArr.get(1));
        clickToElement(driver,CheckOutPageUI.CONTINUE_BNT,continueButtonArr.get(2));
    }
    public List<String> getPersonInfo(){
        List<WebElement> elements = getListWebElements(driver,CheckOutPageUI.INFO_CHECKOUT_LBL);
        Log.allure(elements.toString());
        List<String> personInfoList = new ArrayList<>();
        for (WebElement e: elements){
            if(e.getText().equals(null)){
                personInfoList.add(e.getText());
            }
        }
        return personInfoList;
    }
    public boolean verifyTotal() {
        double subTotal = Double.parseDouble(getTextElement(driver, CheckOutPageUI.SUB_TOTAL_LBL));
        double fee = Double.parseDouble(getTextElement(driver, CheckOutPageUI.FEE_LBL));
        double total = Double.parseDouble(getTextElement(driver, CheckOutPageUI.TOTAL_LBL));
        Log.allure("Total" + total);
        return total == (subTotal + fee);
    }
}

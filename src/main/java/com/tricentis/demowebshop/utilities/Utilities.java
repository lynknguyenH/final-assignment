package com.tricentis.demowebshop.utilities;

import com.tricentis.demowebshop.common.BasePage;
import org.testng.annotations.DataProvider;

public class Utilities{
    @DataProvider(name= "testdata")
    public static Object[][] getExcelDataTable(){
        Object[][] testObjArray = ExcelUtils.getExcelData();
        return (testObjArray);
    }

    @DataProvider(name = "ExpectedMessage")
    public static Object[] getErrorMessageFromExcel(){
        Object[] errorMessage = new String[]{ExcelUtils.getDataValue(1, 3)};
        return errorMessage;
    }
}

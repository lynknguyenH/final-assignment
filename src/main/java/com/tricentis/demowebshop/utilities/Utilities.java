package com.tricentis.demowebshop.utilities;

import com.tricentis.demowebshop.common.BaseTest;
import org.testng.annotations.DataProvider;

public class Utilities{
    @DataProvider(name= "testdata")
    public Object[][] getExcelDataTable(){
        Object[][] testObjArray = ExcelUtils.getExcelData();
        return (testObjArray);
    }
}

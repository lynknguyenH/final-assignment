package com.tricentis.demowebshop.utilities;

import com.tricentis.demowebshop.helper.Log;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

public class ExcelUtils {
    public static final String testDataExelFileName = "testdata.xlsx";
    public static final String currentDir = System.getProperty("user.dir");
    public static String testDataExcelPath = null;
    private static XSSFWorkbook excelWBook;
    public static XSSFSheet excelWSheet;
    public static XSSFCell cell;
    public static XSSFRow row;
    public static int rowNumber;
    public static int columnNumber;

    @SneakyThrows
    public static void setExcelFileSheet(String sheetName){
        if(Platform.getCurrent().toString().equalsIgnoreCase("MAC")){
            testDataExcelPath = currentDir + "/src/test/resources/";
        } else if (Platform.getCurrent().toString().contains("WIN")){
            testDataExcelPath = currentDir + "\\src\\test\\resources\\";
        }
        FileInputStream excelFile = new FileInputStream(testDataExcelPath + testDataExelFileName);
        excelWBook = new XSSFWorkbook(excelFile);
        excelWSheet =excelWBook.getSheet(sheetName);
    }


    public static int getRowNumber(){
        excelWSheet = excelWBook.getSheetAt(0);
        return excelWSheet.getPhysicalNumberOfRows();
    }

    public static int getColumnNumber(){
        excelWSheet = excelWBook.getSheetAt(0);
        return excelWSheet.getRow(0).getLastCellNum();
    }

    public static String getDataValue(int rowNum, int colNum){
        excelWSheet = excelWBook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();
        try {
            return formatter.formatCellValue(excelWSheet.getRow(rowNum).getCell(colNum));
        }catch (NullPointerException e){
            e.printStackTrace();
            return "";
        }
    }

    public static Object[][] getExcelData(){
        int rowNum = getRowNumber();
        int colNum = getColumnNumber();
        Object[][] objects = new Object[rowNum-1][colNum];
        for (int i = 1; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                objects[i-1][j]= getDataValue(i,j);
            }
        }
        return objects;
    }

    @SneakyThrows
    public static void setCellData(String value, int rowNum, int colNum){
        row = excelWSheet.getRow(rowNum);
        cell = row.getCell(colNum);
        if(cell == null){
            cell = row.createCell(colNum);
            cell.setCellValue(value);
        } else {
            cell.setCellValue(value);
        }
        FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExelFileName);
        excelWBook.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }

}


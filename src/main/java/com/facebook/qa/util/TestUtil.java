package com.facebook.qa.util;


import com.facebook.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class TestUtil extends TestBase
{
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    public static void takeScreenshotAtEndOfTest(){
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        try {
            FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String TESTDATA_SHEET_PATH = "C:\\Users\\HP\\IdeaProjects\\FacebookTestAutomation\\src\\main\\java\\" +
            "com\\facebook\\qa\\testdata\\FBTestData.xlsx";
    static Workbook book;
    static Sheet sheet;

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (EncryptedDocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                try {
                    data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }
}
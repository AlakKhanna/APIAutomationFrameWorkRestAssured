package org.example.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel {
    //workbook,sheet, row and column, Cells

    static Workbook book;
    static Sheet sheet;

    public static  String File_name ="src/test/Resource/TestData.xlsx";
    public static Object[][] getTestData(String sheetName) {
        //write the logic to read the Excel file and convert this to 2D array
        //only one time you need to create this file
        FileInputStream file = null;

        try {
            file = new FileInputStream(File_name);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sheet = book.getSheet(sheetName);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }

        return data;
    }

    @DataProvider
    public  Object[][] getdata(){
        return getTestData("sheet1");

    }


}

package com.newfold.ecommerce.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static Object[][] getTestData(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();

            Object[][] data = new Object[rowCount][colCount];

            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    if(cell != null) {
                        data[i - 1][j] = cell.getStringCellValue();
                    } else {
                        data[i - 1][j] = "";
                    }
                }
            }
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return new Object[][]{{"standard_user", "secret_sauce"}}; // Fallback
        }
    }
}

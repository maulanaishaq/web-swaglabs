package com.web.swaglabs.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;




public class ExcelUtils {


    public static Object[][] getTestData(String excelPath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(new File(excelPath));
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getLastCellNum();

            Object[][] data = new Object[rowCount - 1][colCount];
            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    data[i - 1][j] = getCellValue(row.getCell(j));
                }
            }
            workbook.close();
            fis.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Object getCellValue(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> cell.getNumericCellValue();
            case BOOLEAN -> cell.getBooleanCellValue();
            default -> "";
        };
    }





}

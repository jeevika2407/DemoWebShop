package com.util;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelMethod {

    @DataProvider(name = "excelData", parallel = true)
    public Object[][] excelDP() throws IOException {
        String loc = "C:\\Users\\kirub\\Downloads\\demotestdata.xlsx";
        return getData(loc, "Sheet1");
    }

    public String[][] getData(String file, String sheet) throws IOException {
        String[][] data = null;
        try (FileInputStream fis = new FileInputStream(file);
             XSSFWorkbook wrkBk = new XSSFWorkbook(fis)) {
            XSSFSheet sht = wrkBk.getSheet(sheet);
            int r = sht.getLastRowNum() + 1; // Fix row count issue
            int c = sht.getRow(0).getLastCellNum(); // Get column count
            data = new String[r][c];

            for (int i = 0; i < r; i++) {
                XSSFRow row = sht.getRow(i);
                if (row != null) {
                    for (int j = 0; j < c; j++) {
                        Cell cell = row.getCell(j, XSSFRow.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        data[i][j] = (cell != null) ? cell.toString().trim() : "";
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading Excel: " + e.getMessage());
        }
        return data;
    }
}

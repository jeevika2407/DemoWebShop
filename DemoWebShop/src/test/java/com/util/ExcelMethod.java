package com.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class ExcelMethod {
	
	    @DataProvider(name="excelData",parallel=true)
	    public Object[][] excelDP() throws IOException {
    	
        String loc = "C:\\Users\\kirub\\Downloads\\DemoTest1.xlsx";
	        return getData(loc, "Sheet1");
	    	
//	    	String loc=System.getProperty("user.dir")+"C:\\Users\\kirub\\eclipse-testNG\\DemoWebShop\\src\\test\\resources\\DemoTest1.xlsx";
//	  	    Object[][] obj=getData(loc,"Sheet1");
//	  	    return obj;
	    }
	    public String[][] getData(String file, String sheet) throws IOException {
	        String[][] data = null;
	        try (FileInputStream fis=new FileInputStream(file);
	             XSSFWorkbook wrkBk=new XSSFWorkbook(fis)) {
	            XSSFSheet sht=wrkBk.getSheet(sheet);
	            int r=sht.getPhysicalNumberOfRows();
	            int c=sht.getRow(0).getLastCellNum();
	            data=new String[r][c];
	           
	            for (int i=0;i<r; i++) {
	                XSSFRow row=sht.getRow(i);
	                if (row !=null) {
	                    for (int j=0; j < c; j++) {
	                        Cell cell=row.getCell(j);
	                        data[i][j]=cell.getStringCellValue();
	                    }
	                }
	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        return data;
	    }
	}

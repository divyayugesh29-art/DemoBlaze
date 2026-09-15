package com.utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

public class ReadExcelData {
 public static String getParticularData(int rowValue,int columnValue) {
     String data="";
     try {
         File file = new File("C:\\Users\\yugesh\\OneDrive\\Documents\\DataDriven_IPT.xlsx");
         Workbook book = new XSSFWorkbook(file);
         Sheet sheet= book.getSheet("sheet2");
         Row row = sheet.getRow(rowValue);
         Cell cell = row.getCell(columnValue);
         DataFormatter dataFormat=new DataFormatter();
         data = dataFormat.formatCellValue(cell);




     } catch (Exception e) {
         e.printStackTrace();
     }
     return data;

     }}
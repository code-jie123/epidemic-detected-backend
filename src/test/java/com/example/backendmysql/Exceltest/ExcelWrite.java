package com.example.backendmysql.Exceltest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {
    @Test
//    03版本xls
    public void write03() throws IOException {
//        创建一个工作簿
        Workbook workbook=new HSSFWorkbook();
//        创建一个工作表
        Sheet sheet=workbook.createSheet("sheet1");
//        创建一行
        Row row1=sheet.createRow(0);
//        创建一个单元格(1,1)
       Cell cell1= row1.createCell(0);
//       写入数据
        cell1.setCellValue("test");
//        创建一个单元格(1,2)
        Cell cell2=row1.createCell(1);
//        日期
      String s=  new DateTime().toString("yyyy-MM-dd HH:mm:ss");
      cell2.setCellValue(s);
//      生成一张表,IO
       FileOutputStream fileOutputStream= new FileOutputStream("C:\\Users\\86151\\Desktop\\"+"test.xls");
       workbook.write(fileOutputStream);
//       关闭流
        fileOutputStream.close();
        System.out.println("文件生成完毕");
    }

//    07版本xlsx
@Test
    public void write07() throws IOException {
//        创建一个工作簿
        Workbook workbook=new XSSFWorkbook();
//        创建一个工作表
        Sheet sheet=workbook.createSheet("sheet1");
//        创建一行
        Row row1=sheet.createRow(0);
//        创建一个单元格(1,1)
        Cell cell1= row1.createCell(0);
//       写入数据
        cell1.setCellValue("test07");
//        创建一个单元格(1,2)
        Cell cell2=row1.createCell(1);
//        日期
        String s=  new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell2.setCellValue(s);
//      生成一张表,IO
        FileOutputStream fileOutputStream= new FileOutputStream("C:\\Users\\86151\\Desktop\\"+"test07.xlsx");
        workbook.write(fileOutputStream);
//       关闭流
        fileOutputStream.close();
        System.out.println("文件生成完毕");
    }

}

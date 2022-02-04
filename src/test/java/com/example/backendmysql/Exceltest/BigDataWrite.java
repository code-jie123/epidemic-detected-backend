package com.example.backendmysql.Exceltest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class BigDataWrite {
    @Test
    public void write03() throws IOException {
//        开始时间
        long begin=System.currentTimeMillis();
//        创建一个工作簿
        Workbook workbook=new HSSFWorkbook();

       Sheet sheet= workbook.createSheet();
        for(int rownumber=0;rownumber<65536;rownumber++)
        {
            Row row=sheet.createRow(rownumber);
            for(int col=0;col<10;col++){
               Cell cell= row.createCell(col);
                cell.setCellValue(col);
            }
        }
        System.out.println("ok");
       FileOutputStream fileOutputStream= new FileOutputStream("C:\\Users\\86151\\Desktop\\"+"test0.xls");

       workbook.write(fileOutputStream);
       fileOutputStream.close();
        long end=System.currentTimeMillis();
        System.out.println((double) (end-begin)/1000);
    }

    @Test
    public void write07() throws IOException{
        //        开始时间
        long begin=System.currentTimeMillis();
//        创建一个工作簿
        Workbook workbook=new XSSFWorkbook();

        Sheet sheet= workbook.createSheet();
        for(int rownumber=0;rownumber<65536;rownumber++)
        {
            Row row=sheet.createRow(rownumber);
            for(int col=0;col<10;col++){
                Cell cell= row.createCell(col);
                cell.setCellValue(col);
            }
        }
        System.out.println("ok");
        FileOutputStream fileOutputStream= new FileOutputStream("C:\\Users\\86151\\Desktop\\"+"test0.xlsx");

        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long end=System.currentTimeMillis();
        System.out.println((double) (end-begin)/1000);
    }

    @Test
    public void write07plus() throws IOException{
        //        开始时间
        long begin=System.currentTimeMillis();
//        创建一个工作簿,此方法会生成临时文件
        Workbook workbook=new SXSSFWorkbook();

        Sheet sheet= workbook.createSheet();
        for(int rownumber=0;rownumber<100000;rownumber++)
        {
            Row row=sheet.createRow(rownumber);
            for(int col=0;col<10;col++){
                Cell cell= row.createCell(col);
                cell.setCellValue(col);
            }
        }
        System.out.println("ok");
        FileOutputStream fileOutputStream= new FileOutputStream("C:\\Users\\86151\\Desktop\\"+"test0.xlsx");

        workbook.write(fileOutputStream);
        ((SXSSFWorkbook) workbook).dispose();//清除临时文件
        fileOutputStream.close();
        long end=System.currentTimeMillis();
        System.out.println((double) (end-begin)/1000);
    }
}

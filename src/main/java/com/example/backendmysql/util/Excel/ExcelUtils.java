package com.example.backendmysql.util.Excel;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.example.backendmysql.entity.Cases;
import org.joda.time.DateTime;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/*
@autor
*/
public class ExcelUtils {
    private static final String XLSX=".xlsx";//07版excel
    private static final String XLS=".xls";//03版excel

//    导出Excel文件
    public void excelExport(String excelName, List<Cases> listcases, HttpServletResponse httpServletResponse) throws IOException {
        String EXCELNAME=excelName;//导出的文件名
//excel写入，默认为.xls；bigexcelwriter适合于大文件的写入
        BigExcelWriter excelWriter= (BigExcelWriter) ExcelUtil.getBigWriter();


//        设置工作表
        excelWriter.setSheet("Sheet1");
//        去掉多出的第一列
        excelWriter.setOnlyAlias(true);
//        设置列名
        excelWriter.addHeaderAlias("cid","病例id");
        excelWriter.addHeaderAlias("name","姓名");
        excelWriter.addHeaderAlias("sex","性别");
        excelWriter.addHeaderAlias("date","确诊日期");
        excelWriter.addHeaderAlias("age","年龄");
        excelWriter.addHeaderAlias("phone","电话");
        excelWriter.addHeaderAlias("address","地址");
        excelWriter.addHeaderAlias("type","病情程度");
        excelWriter.addHeaderAlias("illtype","感染类型");
        excelWriter.addHeaderAlias("vaccine","是否接种疫苗");
        excelWriter.addHeaderAlias("professional","职业");
//
// 一次性写出内容
        excelWriter.write(listcases);
//        自适应列宽度，数据量较大时，导出速度较慢
//        excelWriter.autoSizeColumnAll();
// 设置编码，防止乱码
//
       EXCELNAME= URLEncoder.encode(EXCELNAME,"utf-8");

//       导出xlsx版本，响应到客户端
        httpServletResponse.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        httpServletResponse.setHeader("Content-Disposition","attachment;filename="+EXCELNAME+new DateTime().toString("yyyy-MM-dd")+XLSX);
//        将excel文件信息写入输出流
        ServletOutputStream out=null;

        try{
            out=httpServletResponse.getOutputStream();
           excelWriter.flush(out,true);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
//            关闭excelwriter，释放内存
            excelWriter.close();
//
        }
//        关闭输出Servlet流
        IoUtil.close(out);
    }
//    导入Excel文件
    /*
    * @param   filepath:文件路径
    * */
    public List<Cases> excelImport(String filepath){
        ExcelReader reader=ExcelUtil.getReader(filepath);
// 解决导入文件的列头和实体类不匹配的问题
        reader.addHeaderAlias("病例id","cid");
        reader.addHeaderAlias("姓名","name");
        reader.addHeaderAlias("性别","sex");
        reader.addHeaderAlias("确诊日期","date");
        reader.addHeaderAlias("年龄","age");
        reader.addHeaderAlias("电话","phone");
        reader.addHeaderAlias("地址","address");
        reader.addHeaderAlias("病情程度","type");
        reader.addHeaderAlias("感染类型","illtype");
        reader.addHeaderAlias("是否接种疫苗","vaccine");
        reader.addHeaderAlias("职业","professional");
        //读取为Bean列表，Bean中的字段名为标题，字段值为标题对应的单元格值
        List<Cases>all=reader.readAll(Cases.class);
        return all;
    }
}

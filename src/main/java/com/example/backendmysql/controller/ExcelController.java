package com.example.backendmysql.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.example.backendmysql.entity.Cases;
import com.example.backendmysql.mapper.CaseMapper;
import com.example.backendmysql.util.Excel.ExcelUtils;
import com.example.backendmysql.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author codejie
 * @since 2022-01-24
 */

@Controller
@CrossOrigin /**解决跨域问题*/
@RequestMapping(value = "/excel")
public class ExcelController {
    @Autowired
    private CaseMapper caseMapper;
//后端IP
    private static final String IP="http://localhost";
//    端口
    @Value("${server.port}")
    private String port;

    ExcelUtils excelUtils=new ExcelUtils();

    //导出excel数据
    @RequestMapping(value = "/export")
    @ResponseBody
    public Result<List<Cases>> getCase(HttpServletResponse response)  {
        List<Cases> allCases =caseMapper.allCase();
        if(allCases !=null){
            try {
                excelUtils.excelExport("病例表", allCases,response);
            }catch (IOException e){
                e.printStackTrace();
            }
            return  Result.success(200,"导出数据成功");
        }else{
            //如果为空，则不导出
            return Result.error(204,"无资源可导出");
        }
    }

//    导入excel数据
    @PostMapping(value = "/import")
    @ResponseBody
    public Result<List<Cases>>importCase(MultipartFile file)  {

//        返回文件的URL
        String fileURL;

        String originalFileName=file.getOriginalFilename();//获取文件原名称
//        定义文件唯一标识(前缀)

        String flag= IdUtil.fastSimpleUUID();
//        根目录
        String rootPath=System.getProperty("user.dir");
        System.out.println(rootPath);//控制台输出根目录进行验证
//        文件所在相对目录
        String path="/src/main/resources/files/"+flag+"_"+originalFileName;
        String filepath=rootPath+path;
        try {
       //将文件写入到上传路径files，如果文件路径错误，会创建一个新路径，文件会存入该路径下
            FileUtil.writeBytes(file.getBytes(), filepath);
        }catch (IOException e){
            e.printStackTrace();
        }
        fileURL=IP+":"+port+"/files/"+flag;
        System.out.println(fileURL);
        return Result.success(200,"导入成功");
//        return Result.error(500,"导入失败");
    }
}

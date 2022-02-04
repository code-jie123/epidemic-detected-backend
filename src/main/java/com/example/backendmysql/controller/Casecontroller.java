package com.example.backendmysql.controller;

import com.example.backendmysql.entity.Cases;
import com.example.backendmysql.mapper.CaseMapper;
import com.example.backendmysql.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author codejie
 * @since 2022-01-24
 */

@RestController
public class Casecontroller {
    @Autowired
    private CaseMapper caseMapper;
    //所有病例数据
    @PostMapping(value = "/case")
    public Result<List<Cases>>getCase(){
        List<Cases> allCases =caseMapper.allCase();
        if(allCases !=null){
            return  Result.success(200,"post请求成功", allCases);
        }else{
            return Result.error(500,"post请求失败", allCases);
        }
    }

//    新增确诊病例
    @PostMapping(value = "/addCase")
//    requestbody将请求传递的参数映射为实体类Cases
    public Result<?>addCase(@RequestBody Cases ca){

        caseMapper.insert(ca);
        return Result.success(200,"添加成功");
    }

}

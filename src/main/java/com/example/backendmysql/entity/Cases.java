package com.example.backendmysql.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/*
* 病例
* */
@Data
@TableName(value = "cases")
public class Cases {
    @TableId(type=IdType.AUTO)
    //病例ID
    private Integer cid;

    private String name;

    private String sex;
    //确诊日期
    private String date;

    private Integer age;
    private String phone;
    private String address;
    //城市
    private String city;
    //区
    private String area;
    //病情程度
    private String type;
    //感染病毒类型
    private String illtype;
    //是否接种疫苗
    private String vaccine;
    //职业
    private String professional;
    //住址经度
    private String lng;
    //纬度
    private String lat;

}

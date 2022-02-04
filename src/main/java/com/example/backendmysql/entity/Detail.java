package com.example.backendmysql.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value = "detail")
@Data
public class Detail {
    @TableId(type = IdType.AUTO)
     private int id;
    private int cid;
    private String date;
    private String time;
    private String sname;//出发地
    private long slng;//
    private long slat;
    private String dname;//目的地
    private long dlng;
    private long dlat;
    private String traffic;//交通工具
    private String purpose;//目的
}

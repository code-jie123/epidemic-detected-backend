package com.example.backendmysql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backendmysql.entity.Cases;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CaseMapper extends BaseMapper<Cases> {
    //返回所有确诊病例
    @Select("SELECT * FROM cases")
    List<Cases>allCase();
    //批量插入数据
//    @Insert("insert into `case` value ")

}

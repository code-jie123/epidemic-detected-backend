package com.example.backendmysql.mapper;

import com.example.backendmysql.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
//     查找用户
     @Select("Select * from user where name =#{name} and password=#{password}")
     User finduser(@Param("name") String name,@Param("password") String password);

}

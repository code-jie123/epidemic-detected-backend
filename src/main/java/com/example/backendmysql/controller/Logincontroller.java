package com.example.backendmysql.controller;

import com.example.backendmysql.entity.User;
import com.example.backendmysql.mapper.UserMapper;
import com.example.backendmysql.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codejie
 * @since 2022-01-24
 */
//处理登录请求
@RestController
public class Logincontroller {
     @Autowired
    private UserMapper userMapper;
     @GetMapping(value = "/login")
    public Result<User> handleLogin(@RequestParam("username")String username,@RequestParam("password")String password){
         User user= userMapper.finduser(username,password);
         if(user!=null) {
             return Result.success(200, "请求成功", user);
         }
         else{
             return Result.error(500,"请求失败",user);}
     }
}

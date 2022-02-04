package com.example.backendmysql.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName(value="user")
@Data
public class User {
  private String name;
  private String password;
}

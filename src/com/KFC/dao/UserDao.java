package com.KFC.dao;

import com.KFC.pojo.User;

import java.util.List;

public interface UserDao {
    //获取登录的对象
   List <User> getUser();

   //根据用户名 密码获取登录对象
    User getUser(String uname,String pwd);
}

package com.KFC.service.Impl;

import com.KFC.dao.UserDao;
import com.KFC.dao.impl.UserDaoImpl;
import com.KFC.pojo.User;
import com.KFC.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User login(String uname, String pwd) {
        UserDao dao=new UserDaoImpl();
        return dao.getUser(uname,pwd);
    }
}

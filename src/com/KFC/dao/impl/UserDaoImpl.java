package com.KFC.dao.impl;

import com.KFC.dao.UserDao;
import com.KFC.pojo.User;
import com.KFC.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> getUser() {

        Connection connection=JDBCUtil.getConnection();
        String sql="select * from tb_user";
        ResultSet set=null;
        PreparedStatement statement=null;
        List<User> userList=new ArrayList<>();
        try {
            statement=connection.prepareStatement(sql);
            set=statement.executeQuery();
            while(set.next())
            {

                int id=set.getInt(1);
                int loginid=set.getInt(2);
                String pwd=set.getString(3);
                String nickName=set.getString(4);
                String realName=set.getString(5);
                User user=new User();
                user.setLoginid(loginid);
                user.setPwd(pwd);
                user.setNickName(nickName);
                user.setRealName(realName);
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.close(set,statement,connection);
        }

        return null;
    }

    @Override
    public User getUser(String uname, String pwd) {
        Connection connection=JDBCUtil.getConnection();
        String sql="select * from tb_user where nickName=? and pwd=? ";
        ResultSet set=null;
        PreparedStatement statement=null;
        User user=null;
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,uname);
            statement.setString(2,pwd);
            set=statement.executeQuery();
            if(set.next())
            {
                int id=set.getInt(1);
                int loginId=set.getInt(2);
                String password=set.getString(3);
                String nickName=set.getString(4);
                String realName=set.getString(5);
                user=new User(id,loginId,password,nickName,realName);
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.KFC.dao.impl;

import com.KFC.dao.categoryDao;
import com.KFC.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class categoryDaoImpl implements categoryDao {
    @Override
    public String getCname(int id) {

        //传进来商品的类别编号 ，返回名称
        Connection connection=JDBCUtil.getConnection();
        ResultSet set=null;
        String sql="select cname from tb_category where cid=?";
        PreparedStatement statement=null;
        String cname=null;
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            set=statement.executeQuery();
            if(set.next())
            {
                cname=set.getString(1);
            }

            return cname;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.close(set,statement,connection);
        }
        return null;
    }
}

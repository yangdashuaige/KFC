package com.KFC.dao.impl;

import com.KFC.dao.GoodsDao;
import com.KFC.dao.cartItemDao;
import com.KFC.pojo.Goods;
import com.KFC.pojo.cartItem;
import com.KFC.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class cartItemDaoImpl implements cartItemDao {
    @Override
    public boolean addCart(cartItem cartItem) {
        Connection connection=JDBCUtil.getConnection();
        ResultSet set=null;
        PreparedStatement statement=null;
        int id=cartItem.getId();
        int sessionid=cartItem.getSessionId();
        int uid=cartItem.getUid();
        String sql="insert into tb_cartitem values(?,?,?,?,?)";
        Map<Goods,Integer> goods=cartItem.getGoods();
        for(Map.Entry<Goods,Integer> entry:goods.entrySet())
        {
            int gid=entry.getKey().getId();
            int count=entry.getValue();
            try {
                statement=connection.prepareStatement(sql);
                statement.setInt(1,id);
                statement.setInt(2,gid);
                statement.setInt(3,count);
                statement.setInt(4,sessionid);
                statement.setInt(5,uid);
                int P=statement.executeUpdate();
                if(P<0)
                {
                    return  false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return true;
    }
}

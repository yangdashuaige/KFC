package com.KFC.dao.impl;

import com.KFC.dao.GoodsDao;
import com.KFC.pojo.Goods;
import com.KFC.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class GoodsDaoImpl implements GoodsDao {
    @Override
    public List<Goods> getGoods() {
        Connection connection=JDBCUtil.getConnection();
        ResultSet set=null;
        String sql="select * from tb_good";
        PreparedStatement statement=null;
        List<Goods> goodsList=new ArrayList<>();
        try {
            statement=connection.prepareStatement(sql);
            set=statement.executeQuery();
            while(set.next())
            {
                Goods goods=new Goods();
                goods.setId(set.getInt(1));
                goods.setGname(set.getString(2));
                goods.setPrice(set.getDouble(3));
                goods.setImg(set.getString(4));
                goods.setCategoryid(set.getInt(5));
                goodsList.add(goods);
            }
            return  goodsList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Goods getGoodsById(int id) {
        Connection connection=JDBCUtil.getConnection();
        PreparedStatement statement=null;
        ResultSet set=null;
        String sql="select * from tb_good where id=? ";
        Goods goods=null;
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            set=statement.executeQuery();
            if(set.next())
            {
                int gid=set.getInt(1);
                 String name=set.getString(2);
                 double price=set.getDouble(3);
                 String img=set.getString(4);
                 int catid=set.getInt(5);
                goods=new Goods(gid,name,price,img,catid);
            }
            return  goods;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.close(set,statement,connection);
        }
        return null;
    }

    @Override
    public List<Goods> selectGoodsById(int id) {
        Connection connection=JDBCUtil.getConnection();
        ResultSet set=null;
        String sql="select * from tb_good where categoryId=? ";
        PreparedStatement statement=null;
        List<Goods> goodsList=new ArrayList<>();
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            set=statement.executeQuery();
            while(set.next())
            {
                Goods goods=new Goods();
                goods.setId(set.getInt(1));
                goods.setGname(set.getString(2));
                goods.setPrice(set.getDouble(3));
                goods.setImg(set.getString(4));
                goods.setCategoryid(set.getInt(5));
                goodsList.add(goods);
            }
            return goodsList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.close(set,statement,connection);
        }
        return null;
    }
}

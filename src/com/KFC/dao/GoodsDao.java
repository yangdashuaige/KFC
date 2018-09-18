package com.KFC.dao;

import com.KFC.pojo.Goods;

import java.util.List;

public interface GoodsDao {

    //对商品类的展示
    List<Goods> getGoods();

    //根据ID搜索商品
    Goods getGoodsById(int id);

    //根据类别从tb_goods中返回商品
    List<Goods> selectGoodsById(int id);
}

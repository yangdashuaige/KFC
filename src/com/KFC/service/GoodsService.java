package com.KFC.service;

import com.KFC.pojo.Goods;

import java.util.List;

public interface GoodsService {
    //获得tb_good中所有的商品
    List<Goods> getAllGoods();

    //根据商品id 返回一个Goods对象
    Goods getGoodsById(int id);

    //根据商品的类别id返回该类的所有商品
    List<Goods> getAllGoodsById(int id);
}

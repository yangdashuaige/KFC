package com.KFC.service.Impl;

import com.KFC.dao.GoodsDao;
import com.KFC.dao.impl.GoodsDaoImpl;
import com.KFC.pojo.Goods;
import com.KFC.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {

    @Override
    public List<Goods> getAllGoods() {
        GoodsDao dao=new GoodsDaoImpl();
        return dao.getGoods();
    }

    @Override
    public Goods getGoodsById(int id) {
        GoodsDao dao=new GoodsDaoImpl();

        return dao.getGoodsById(id);
    }

    @Override
    public List<Goods> getAllGoodsById(int id) {
        GoodsDao dao=new GoodsDaoImpl();
        return dao.selectGoodsById(id);
    }
}

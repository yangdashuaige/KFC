package com.KFC.pojo;

import java.util.List;
import java.util.Map;

public class cartItem {
    private int id;
    private Map<Goods,Integer> goods;
    int uid;
    int sessionId;

    public cartItem(int id, Map<Goods, Integer> goods, int uid, int sessionId) {
        this.id = id;
        this.goods = goods;
        this.uid = uid;
        this.sessionId = sessionId;
    }

    public cartItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Goods, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<Goods, Integer> goods) {
        this.goods = goods;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }
}

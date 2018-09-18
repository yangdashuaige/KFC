package com.KFC.pojo;

public class category {
    private int id;  //商品的编号
    private String cname;  //商品的种类名

    public category(int id, String cname) {
        this.id = id;
        this.cname = cname;
    }

    public category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}

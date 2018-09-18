package com.KFC.pojo;

public class User {
    private int id;
    private int loginid; //登录的号码
    private String pwd;  //密码
    private String nickName;  //
    private String realName;

    public User() {
    }

    public User(int id, int loginid, String pwd, String nickName, String realName) {
        this.id = id;
        this.loginid = loginid;
        this.pwd = pwd;
        this.nickName = nickName;
        this.realName = realName;
    }

    public void setLoginid(int loginid) {
        this.loginid = loginid;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getId() {

        return id;
    }

    public int getLoginid() {
        return loginid;
    }

    public String getPwd() {
        return pwd;
    }

    public String getNickName() {
        return nickName;
    }

    public String getRealName() {
        return realName;
    }
}

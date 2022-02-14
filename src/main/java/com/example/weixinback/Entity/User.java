package com.example.weixinback.Entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private String userNO;
    private String userName;
    private Date createDate;
    private Date lastLoginTime;
    private String weiXinNO;
    private int tag;

    public String getUserNO() {
        return userNO;
    }

    public void setUserNO(String userNO) {
        this.userNO = userNO;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getWeiXinNO() {
        return weiXinNO;
    }

    public void setWeiXinNO(String weiXinNO) {
        this.weiXinNO = weiXinNO;
    }
}

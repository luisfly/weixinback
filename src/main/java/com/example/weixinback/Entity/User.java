package com.example.weixinback.Entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private String uesrNO;
    private String uesrName;
    private Date createDate;
    private Date lastLoginTime;
    private String weiXinNO;
    private int tag;

    public String getUesrNO() {
        return uesrNO;
    }

    public void setUesrNO(String uesrNO) {
        this.uesrNO = uesrNO;
    }

    public String getUesrName() {
        return uesrName;
    }

    public void setUesrName(String uesrName) {
        this.uesrName = uesrName;
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

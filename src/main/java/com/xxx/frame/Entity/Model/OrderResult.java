package com.xxx.frame.Entity.Model;

import com.xxx.frame.Entity.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class OrderResult implements Serializable {
    private static final long serialVersionUID = -669181288408984883L;
    private BaseOrderInfo orderinfo;
    private ClassInfo classInfo;
    private UserInfo userInfo;
    private ClassColumn classColumn;

    public OrderResult(BaseOrderInfo orderinfo, ClassInfo classInfo, UserInfo userInfo) {
        this.orderinfo = orderinfo;
        this.classInfo = classInfo;
        this.userInfo = userInfo;
    }


    public ClassColumn getClassColumn() {
        return classColumn;
    }

    public void setClassColumn(ClassColumn classColumn) {
        this.classColumn = classColumn;
    }

    public OrderResult() {
    }

    public BaseOrderInfo getOrderinfo() {
        return orderinfo;
    }

    public void setOrderinfo(BaseOrderInfo orderinfo) {
        this.orderinfo = orderinfo;
    }

    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }


    //seach
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date minOrderTimeStr;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date maxOrderTimeStr;

    public Date getMinOrderTimeStr() {
        return minOrderTimeStr;
    }

    public void setMinOrderTimeStr(Date minOrderTimeStr) {
        this.minOrderTimeStr = minOrderTimeStr;
    }

    public Date getMaxOrderTimeStr() {
        return maxOrderTimeStr;
    }

    public void setMaxOrderTimeStr(Date maxOrderTimeStr) {
        this.maxOrderTimeStr = maxOrderTimeStr;
    }
}

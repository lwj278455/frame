package com.xxx.frame.Entity;

import com.xxx.frame.Entity.Model.OrderResult;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OnLineOrder extends BaseOrderInfo implements Serializable {
    public OnLineOrder(Integer id, String orderno, Integer classid, String userid, BigDecimal payment, Integer status, Date creattime, Date paytime, Date closetime) {
        super(id, orderno, classid, userid, payment, status, creattime, paytime, closetime);
    }
    public OnLineOrder() {
    }
}
package com.xxx.frame.Entity;

import com.xxx.frame.Entity.Model.OrderResult;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OffLineOrder extends BaseOrderInfo implements Serializable {
    public OffLineOrder(Integer id, String orderno, Integer classid, String userid, BigDecimal payment, Integer status, Date creattime, Date paytime, Date closetime) {
        super(id, orderno, classid, userid, payment, status, creattime, paytime, closetime);
    }
    public OffLineOrder() {
    }

    private List<Member> members;

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
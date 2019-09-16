package com.xxx.frame.Entity;

import com.xxx.frame.Util.ConstantManger;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BaseOrderInfo implements Serializable {
    private Integer id;

    private String orderno;

    private Integer classid;

    private String userid;

    private BigDecimal payment;

    private Integer status;

    private Date creattime;

    private Date paytime;

    private Date closetime;

    private static final long serialVersionUID = 1L;

    public BaseOrderInfo(Integer id, String orderno, Integer classid, String  userid, BigDecimal payment, Integer status, Date creattime, Date paytime, Date closetime) {
        this.id = id;
        this.orderno = orderno;
        this.classid = classid;
        this.userid = userid;
        this.payment = payment;
        this.status = status;
        this.creattime = creattime;
        this.paytime = paytime;
        this.closetime = closetime;
    }

    public BaseOrderInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Date getClosetime() {
        return closetime;
    }

    public void setClosetime(Date closetime) {
        this.closetime = closetime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BaseOrderInfo other = (BaseOrderInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getOrderno() == null ? other.getOrderno() == null : this.getOrderno().equals(other.getOrderno()))
                && (this.getClassid() == null ? other.getClassid() == null : this.getClassid().equals(other.getClassid()))
                && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
                && (this.getPayment() == null ? other.getPayment() == null : this.getPayment().equals(other.getPayment()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getCreattime() == null ? other.getCreattime() == null : this.getCreattime().equals(other.getCreattime()))
                && (this.getPaytime() == null ? other.getPaytime() == null : this.getPaytime().equals(other.getPaytime()))
                && (this.getClosetime() == null ? other.getClosetime() == null : this.getClosetime().equals(other.getClosetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderno() == null) ? 0 : getOrderno().hashCode());
        result = prime * result + ((getClassid() == null) ? 0 : getClassid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getPayment() == null) ? 0 : getPayment().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreattime() == null) ? 0 : getCreattime().hashCode());
        result = prime * result + ((getPaytime() == null) ? 0 : getPaytime().hashCode());
        result = prime * result + ((getClosetime() == null) ? 0 : getClosetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderno=").append(orderno);
        sb.append(", classid=").append(classid);
        sb.append(", userid=").append(userid);
        sb.append(", payment=").append(payment);
        sb.append(", status=").append(status);
        sb.append(", creattime=").append(creattime);
        sb.append(", paytime=").append(paytime);
        sb.append(", closetime=").append(closetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public String getStatuStr(){
        return ConstantManger.ORDERSTATUS[this.status];
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

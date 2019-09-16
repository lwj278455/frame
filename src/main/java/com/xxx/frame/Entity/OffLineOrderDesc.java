package com.xxx.frame.Entity;

import java.io.Serializable;

public class OffLineOrderDesc implements Serializable {
    private Integer id;

    private String userid;

    private Integer classinfoid;

    private Integer orderid;

    private Integer memberid;

    private static final long serialVersionUID = 1L;

    public OffLineOrderDesc(Integer id, String userid, Integer classinfoid, Integer orderid, Integer memberid) {
        this.id = id;
        this.userid = userid;
        this.classinfoid = classinfoid;
        this.orderid = orderid;
        this.memberid = memberid;
    }

    public OffLineOrderDesc() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getClassinfoid() {
        return classinfoid;
    }

    public void setClassinfoid(Integer classinfoid) {
        this.classinfoid = classinfoid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
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
        OffLineOrderDesc other = (OffLineOrderDesc) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getClassinfoid() == null ? other.getClassinfoid() == null : this.getClassinfoid().equals(other.getClassinfoid()))
            && (this.getOrderid() == null ? other.getOrderid() == null : this.getOrderid().equals(other.getOrderid()))
            && (this.getMemberid() == null ? other.getMemberid() == null : this.getMemberid().equals(other.getMemberid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getClassinfoid() == null) ? 0 : getClassinfoid().hashCode());
        result = prime * result + ((getOrderid() == null) ? 0 : getOrderid().hashCode());
        result = prime * result + ((getMemberid() == null) ? 0 : getMemberid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", classinfoid=").append(classinfoid);
        sb.append(", orderid=").append(orderid);
        sb.append(", memberid=").append(memberid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.xxx.frame.Entity;

import java.io.Serializable;

public class AdminDesc implements Serializable {
    private Integer adminuserid;

    private String userid;

    private static final long serialVersionUID = 1L;

    public AdminDesc(Integer adminuserid, String userid) {
        this.adminuserid = adminuserid;
        this.userid = userid;
    }

    public AdminDesc() {
        super();
    }

    public Integer getAdminuserid() {
        return adminuserid;
    }

    public void setAdminuserid(Integer adminuserid) {
        this.adminuserid = adminuserid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
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
        AdminDesc other = (AdminDesc) that;
        return (this.getAdminuserid() == null ? other.getAdminuserid() == null : this.getAdminuserid().equals(other.getAdminuserid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdminuserid() == null) ? 0 : getAdminuserid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminuserid=").append(adminuserid);
        sb.append(", userid=").append(userid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
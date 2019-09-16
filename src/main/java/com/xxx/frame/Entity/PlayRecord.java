package com.xxx.frame.Entity;

import java.io.Serializable;
import java.util.Date;

public class PlayRecord implements Serializable {
    private Integer id;

    private String userid;

    private Integer classid;

    private Date playdate;

    private int weekTag;

    public int getWeekTag() {
        return weekTag;
    }

    public void setWeekTag(int weekTag) {
        this.weekTag = weekTag;
    }

    private static final long serialVersionUID = 1L;

    public PlayRecord(Integer id, String userid, Integer classid, Date playdate) {
        this.id = id;
        this.userid = userid;
        this.classid = classid;
        this.playdate = playdate;
    }

    public PlayRecord() {
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

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Date getPlaydate() {
        return playdate;
    }

    public void setPlaydate(Date playdate) {
        this.playdate = playdate;
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
        PlayRecord other = (PlayRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getClassid() == null ? other.getClassid() == null : this.getClassid().equals(other.getClassid()))
            && (this.getPlaydate() == null ? other.getPlaydate() == null : this.getPlaydate().equals(other.getPlaydate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getClassid() == null) ? 0 : getClassid().hashCode());
        result = prime * result + ((getPlaydate() == null) ? 0 : getPlaydate().hashCode());
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
        sb.append(", classid=").append(classid);
        sb.append(", playdate=").append(playdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
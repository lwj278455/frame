package com.xxx.frame.Entity;

import java.io.Serializable;

public class MemberMien implements Serializable {
    private Integer mienid;

    private String title;

    private String imgurl;

    private Integer columnid;

    private static final long serialVersionUID = 1L;

    public MemberMien(Integer mienid, String title, String imgurl, Integer columnid) {
        this.mienid = mienid;
        this.title = title;
        this.imgurl = imgurl;
        this.columnid = columnid;
    }

    public MemberMien() {
        super();
    }

    public Integer getMienid() {
        return mienid;
    }

    public void setMienid(Integer mienid) {
        this.mienid = mienid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public Integer getColumnid() {
        return columnid;
    }

    public void setColumnid(Integer columnid) {
        this.columnid = columnid;
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
        MemberMien other = (MemberMien) that;
        return (this.getMienid() == null ? other.getMienid() == null : this.getMienid().equals(other.getMienid()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getImgurl() == null ? other.getImgurl() == null : this.getImgurl().equals(other.getImgurl()))
            && (this.getColumnid() == null ? other.getColumnid() == null : this.getColumnid().equals(other.getColumnid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMienid() == null) ? 0 : getMienid().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getImgurl() == null) ? 0 : getImgurl().hashCode());
        result = prime * result + ((getColumnid() == null) ? 0 : getColumnid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mienid=").append(mienid);
        sb.append(", title=").append(title);
        sb.append(", imgurl=").append(imgurl);
        sb.append(", columnid=").append(columnid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
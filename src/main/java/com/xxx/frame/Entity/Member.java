package com.xxx.frame.Entity;

import java.io.Serializable;

public class Member implements Serializable {
    private Integer id;

    private String userId;

    private String mobile;

    private String memebername;

    private String certificatetype;

    private String certificatecode;

    private String firmname;

    private String industry;

    private Integer isself;

    private static final long serialVersionUID = 1L;

    public Member(Integer id, String userId, String mobile, String memebername, String certificatetype, String certificatecode, String firmname, String industry, Integer isself) {
        this.id = id;
        this.userId = userId;
        this.mobile = mobile;
        this.memebername = memebername;
        this.certificatetype = certificatetype;
        this.certificatecode = certificatecode;
        this.firmname = firmname;
        this.industry = industry;
        this.isself = isself;
    }

    public Member() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getMemebername() {
        return memebername;
    }

    public void setMemebername(String memebername) {
        this.memebername = memebername == null ? null : memebername.trim();
    }

    public String getCertificatetype() {
        return certificatetype;
    }

    public void setCertificatetype(String certificatetype) {
        this.certificatetype = certificatetype == null ? null : certificatetype.trim();
    }

    public String getCertificatecode() {
        return certificatecode;
    }

    public void setCertificatecode(String certificatecode) {
        this.certificatecode = certificatecode == null ? null : certificatecode.trim();
    }

    public String getFirmname() {
        return firmname;
    }

    public void setFirmname(String firmname) {
        this.firmname = firmname == null ? null : firmname.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public Integer getIsself() {
        return isself;
    }

    public void setIsself(Integer isself) {
        this.isself = isself;
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
        Member other = (Member) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getMemebername() == null ? other.getMemebername() == null : this.getMemebername().equals(other.getMemebername()))
            && (this.getCertificatetype() == null ? other.getCertificatetype() == null : this.getCertificatetype().equals(other.getCertificatetype()))
            && (this.getCertificatecode() == null ? other.getCertificatecode() == null : this.getCertificatecode().equals(other.getCertificatecode()))
            && (this.getFirmname() == null ? other.getFirmname() == null : this.getFirmname().equals(other.getFirmname()))
            && (this.getIndustry() == null ? other.getIndustry() == null : this.getIndustry().equals(other.getIndustry()))
            && (this.getIsself() == null ? other.getIsself() == null : this.getIsself().equals(other.getIsself()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getMemebername() == null) ? 0 : getMemebername().hashCode());
        result = prime * result + ((getCertificatetype() == null) ? 0 : getCertificatetype().hashCode());
        result = prime * result + ((getCertificatecode() == null) ? 0 : getCertificatecode().hashCode());
        result = prime * result + ((getFirmname() == null) ? 0 : getFirmname().hashCode());
        result = prime * result + ((getIndustry() == null) ? 0 : getIndustry().hashCode());
        result = prime * result + ((getIsself() == null) ? 0 : getIsself().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", mobile=").append(mobile);
        sb.append(", memebername=").append(memebername);
        sb.append(", certificatetype=").append(certificatetype);
        sb.append(", certificatecode=").append(certificatecode);
        sb.append(", firmname=").append(firmname);
        sb.append(", industry=").append(industry);
        sb.append(", isself=").append(isself);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
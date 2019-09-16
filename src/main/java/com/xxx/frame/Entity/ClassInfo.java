package com.xxx.frame.Entity;

import com.xxx.frame.Util.ConstantManger;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ClassInfo implements Serializable {
    private Integer id;

    private String classname;

    private String classcontent;

    private Integer classtype;

    private Integer isreferral;

    private Integer pricetype;

    private BigDecimal price;

    private Long duration;

    private String filepath;

    private Date creattime;

    private String classimg;

    private Integer linetype;

    private String speaker;

    private Long playcount;

    private Integer columnid;

    private Integer membercount;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date applydate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date attendtime;

    private String introduction;

    private static final long serialVersionUID = 1L;

    public ClassInfo(Integer id, String classname, String classcontent, Integer classtype, Integer isreferral, Integer pricetype, BigDecimal price, Long duration, String filepath, Date creattime, String classimg, Integer linetype, String speaker, Long playcount, Integer columnid, Integer membercount, Date applydate, Date attendtime, String introduction) {
        this.id = id;
        this.classname = classname;
        this.classcontent = classcontent;
        this.classtype = classtype;
        this.isreferral = isreferral;
        this.pricetype = pricetype;
        this.price = price;
        this.duration = duration;
        this.filepath = filepath;
        this.creattime = creattime;
        this.classimg = classimg;
        this.linetype = linetype;
        this.speaker = speaker;
        this.playcount = playcount;
        this.columnid = columnid;
        this.membercount = membercount;
        this.applydate = applydate;
        this.attendtime = attendtime;
        this.introduction = introduction;
    }

    public ClassInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getClasscontent() {
        return classcontent;
    }

    public void setClasscontent(String classcontent) {
        this.classcontent = classcontent == null ? null : classcontent.trim();
    }

    public Integer getClasstype() {
        return classtype;
    }

    public void setClasstype(Integer classtype) {
        this.classtype = classtype;
    }

    public Integer getIsreferral() {
        return isreferral;
    }

    public void setIsreferral(Integer isreferral) {
        this.isreferral = isreferral;
    }

    public Integer getPricetype() {
        return pricetype;
    }

    public void setPricetype(Integer pricetype) {
        this.pricetype = pricetype;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public String getClassimg() {
        return classimg;
    }

    public void setClassimg(String classimg) {
        this.classimg = classimg == null ? null : classimg.trim();
    }

    public Integer getLinetype() {
        return linetype;
    }

    public void setLinetype(Integer linetype) {
        this.linetype = linetype;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker == null ? null : speaker.trim();
    }

    public Long getPlaycount() {
        return playcount;
    }

    public void setPlaycount(Long playcount) {
        this.playcount = playcount;
    }

    public Integer getColumnid() {
        return columnid;
    }

    public void setColumnid(Integer columnid) {
        this.columnid = columnid;
    }

    public Integer getMembercount() {
        return membercount;
    }

    public void setMembercount(Integer membercount) {
        this.membercount = membercount;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public Date getAttendtime() {
        return attendtime;
    }

    public void setAttendtime(Date attendtime) {
        this.attendtime = attendtime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
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
        ClassInfo other = (ClassInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClassname() == null ? other.getClassname() == null : this.getClassname().equals(other.getClassname()))
            && (this.getClasscontent() == null ? other.getClasscontent() == null : this.getClasscontent().equals(other.getClasscontent()))
            && (this.getClasstype() == null ? other.getClasstype() == null : this.getClasstype().equals(other.getClasstype()))
            && (this.getIsreferral() == null ? other.getIsreferral() == null : this.getIsreferral().equals(other.getIsreferral()))
            && (this.getPricetype() == null ? other.getPricetype() == null : this.getPricetype().equals(other.getPricetype()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getDuration() == null ? other.getDuration() == null : this.getDuration().equals(other.getDuration()))
            && (this.getFilepath() == null ? other.getFilepath() == null : this.getFilepath().equals(other.getFilepath()))
            && (this.getCreattime() == null ? other.getCreattime() == null : this.getCreattime().equals(other.getCreattime()))
            && (this.getClassimg() == null ? other.getClassimg() == null : this.getClassimg().equals(other.getClassimg()))
            && (this.getLinetype() == null ? other.getLinetype() == null : this.getLinetype().equals(other.getLinetype()))
            && (this.getSpeaker() == null ? other.getSpeaker() == null : this.getSpeaker().equals(other.getSpeaker()))
            && (this.getPlaycount() == null ? other.getPlaycount() == null : this.getPlaycount().equals(other.getPlaycount()))
            && (this.getColumnid() == null ? other.getColumnid() == null : this.getColumnid().equals(other.getColumnid()))
            && (this.getMembercount() == null ? other.getMembercount() == null : this.getMembercount().equals(other.getMembercount()))
            && (this.getApplydate() == null ? other.getApplydate() == null : this.getApplydate().equals(other.getApplydate()))
            && (this.getAttendtime() == null ? other.getAttendtime() == null : this.getAttendtime().equals(other.getAttendtime()))
            && (this.getIntroduction() == null ? other.getIntroduction() == null : this.getIntroduction().equals(other.getIntroduction()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClassname() == null) ? 0 : getClassname().hashCode());
        result = prime * result + ((getClasscontent() == null) ? 0 : getClasscontent().hashCode());
        result = prime * result + ((getClasstype() == null) ? 0 : getClasstype().hashCode());
        result = prime * result + ((getIsreferral() == null) ? 0 : getIsreferral().hashCode());
        result = prime * result + ((getPricetype() == null) ? 0 : getPricetype().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getDuration() == null) ? 0 : getDuration().hashCode());
        result = prime * result + ((getFilepath() == null) ? 0 : getFilepath().hashCode());
        result = prime * result + ((getCreattime() == null) ? 0 : getCreattime().hashCode());
        result = prime * result + ((getClassimg() == null) ? 0 : getClassimg().hashCode());
        result = prime * result + ((getLinetype() == null) ? 0 : getLinetype().hashCode());
        result = prime * result + ((getSpeaker() == null) ? 0 : getSpeaker().hashCode());
        result = prime * result + ((getPlaycount() == null) ? 0 : getPlaycount().hashCode());
        result = prime * result + ((getColumnid() == null) ? 0 : getColumnid().hashCode());
        result = prime * result + ((getMembercount() == null) ? 0 : getMembercount().hashCode());
        result = prime * result + ((getApplydate() == null) ? 0 : getApplydate().hashCode());
        result = prime * result + ((getAttendtime() == null) ? 0 : getAttendtime().hashCode());
        result = prime * result + ((getIntroduction() == null) ? 0 : getIntroduction().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", classname=").append(classname);
        sb.append(", classcontent=").append(classcontent);
        sb.append(", classtype=").append(classtype);
        sb.append(", isreferral=").append(isreferral);
        sb.append(", pricetype=").append(pricetype);
        sb.append(", price=").append(price);
        sb.append(", duration=").append(duration);
        sb.append(", filepath=").append(filepath);
        sb.append(", creattime=").append(creattime);
        sb.append(", classimg=").append(classimg);
        sb.append(", linetype=").append(linetype);
        sb.append(", speaker=").append(speaker);
        sb.append(", playcount=").append(playcount);
        sb.append(", columnid=").append(columnid);
        sb.append(", membercount=").append(membercount);
        sb.append(", applydate=").append(applydate);
        sb.append(", attendtime=").append(attendtime);
        sb.append(", introduction=").append(introduction);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    //seach
    private BigDecimal maxPrice;//最大金额
    private BigDecimal minPrice;//最小金额

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }
    public String getLineTypeStr(){
        if(this.linetype==null){
            return "";
        }
        return ConstantManger.LINETYPE[this.linetype];}

    public String getPayTypeStr(){
        if(this.pricetype==null){
            return "";
        }
        return ConstantManger.PAYTYPE[this.pricetype];}

    public String getClassTypeStr(){
        if(this.classtype==null){
            return "";
        }
        for(ClassType c:ConstantManger.classTypeList){
            if(this.classtype==c.getTag()){
                return c.getClasstype();
            }
        }
        return "";}

}
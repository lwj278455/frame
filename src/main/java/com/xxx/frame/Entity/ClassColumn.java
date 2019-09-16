package com.xxx.frame.Entity;

import com.xxx.frame.Util.ConstantManger;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ClassColumn implements Serializable {
    private Integer id;

    private String columnname;

    private String columncontent;

    private BigDecimal columnprice;

    private String columnimg;

    private String paytype;

    private String filepath;

    private Integer linetype;

    private String introduction;

    private String speaker;

    private List<ClassInfo> classList;
    private List<MemberMien> mien;
    private ClientAuthentication clientAuthentication;

    public List<MemberMien> getMien() {
        return mien;
    }

    public void setMien(List<MemberMien> mien) {
        this.mien = mien;
    }

    public ClientAuthentication getClientAuthentication() {
        return clientAuthentication;
    }

    public void setClientAuthentication(ClientAuthentication clientAuthentication) {
        this.clientAuthentication = clientAuthentication;
    }

    public List<ClassInfo> getClassList() {
        return classList;
    }

    public void setClassList(List<ClassInfo> classList) {
        this.classList = classList;
    }

    private static final long serialVersionUID = 1L;

    public ClassColumn(Integer id, String columnname, String columncontent, BigDecimal columnprice, String columnimg, String paytype, String filepath, Integer linetype, String introduction, String speaker) {
        this.id = id;
        this.columnname = columnname;
        this.columncontent = columncontent;
        this.columnprice = columnprice;
        this.columnimg = columnimg;
        this.paytype = paytype;
        this.filepath = filepath;
        this.linetype = linetype;
        this.introduction = introduction;
        this.speaker = speaker;
    }


    public ClassColumn() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname == null ? null : columnname.trim();
    }

    public String getColumncontent() {
        return columncontent;
    }

    public void setColumncontent(String columncontent) {
        this.columncontent = columncontent == null ? null : columncontent.trim();
    }

    public BigDecimal getColumnprice() {
        return columnprice;
    }

    public void setColumnprice(BigDecimal columnprice) {
        this.columnprice = columnprice;
    }

    public String getColumnimg() {
        return columnimg;
    }

    public void setColumnimg(String columnimg) {
        this.columnimg = columnimg == null ? null : columnimg.trim();
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public Integer getLinetype() {
        return linetype;
    }

    public void setLinetype(Integer linetype) {
        this.linetype = linetype;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker == null ? null : speaker.trim();
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
        ClassColumn other = (ClassColumn) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getColumnname() == null ? other.getColumnname() == null : this.getColumnname().equals(other.getColumnname()))
            && (this.getColumncontent() == null ? other.getColumncontent() == null : this.getColumncontent().equals(other.getColumncontent()))
            && (this.getColumnprice() == null ? other.getColumnprice() == null : this.getColumnprice().equals(other.getColumnprice()))
            && (this.getColumnimg() == null ? other.getColumnimg() == null : this.getColumnimg().equals(other.getColumnimg()))
            && (this.getPaytype() == null ? other.getPaytype() == null : this.getPaytype().equals(other.getPaytype()))
            && (this.getFilepath() == null ? other.getFilepath() == null : this.getFilepath().equals(other.getFilepath()))
            && (this.getLinetype() == null ? other.getLinetype() == null : this.getLinetype().equals(other.getLinetype()))
            && (this.getIntroduction() == null ? other.getIntroduction() == null : this.getIntroduction().equals(other.getIntroduction()))
            && (this.getSpeaker() == null ? other.getSpeaker() == null : this.getSpeaker().equals(other.getSpeaker()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getColumnname() == null) ? 0 : getColumnname().hashCode());
        result = prime * result + ((getColumncontent() == null) ? 0 : getColumncontent().hashCode());
        result = prime * result + ((getColumnprice() == null) ? 0 : getColumnprice().hashCode());
        result = prime * result + ((getColumnimg() == null) ? 0 : getColumnimg().hashCode());
        result = prime * result + ((getPaytype() == null) ? 0 : getPaytype().hashCode());
        result = prime * result + ((getFilepath() == null) ? 0 : getFilepath().hashCode());
        result = prime * result + ((getLinetype() == null) ? 0 : getLinetype().hashCode());
        result = prime * result + ((getIntroduction() == null) ? 0 : getIntroduction().hashCode());
        result = prime * result + ((getSpeaker() == null) ? 0 : getSpeaker().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", columnname=").append(columnname);
        sb.append(", columncontent=").append(columncontent);
        sb.append(", columnprice=").append(columnprice);
        sb.append(", columnimg=").append(columnimg);
        sb.append(", paytype=").append(paytype);
        sb.append(", filepath=").append(filepath);
        sb.append(", linetype=").append(linetype);
        sb.append(", introduction=").append(introduction);
        sb.append(", speaker=").append(speaker);
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
}
package com.xxx.frame.Entity;

import java.io.Serializable;
import java.util.List;

public class AdminUser implements Serializable {
    private Integer id;

    private String name;

    private String username;

    private String password;

    private String adminlevel;

    private String qrcodeurl;

    private List<UserInfo> userInfoList;

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }

    private static final long serialVersionUID = 1L;

    public AdminUser(Integer id) {
        this.id = id;
    }

    public AdminUser(Integer id, String name, String username, String password, String adminlevel, String qrcodeurl) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.adminlevel = adminlevel;
        this.qrcodeurl = qrcodeurl;
    }

    public AdminUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAdminlevel() {
        return adminlevel;
    }

    public void setAdminlevel(String adminlevel) {
        this.adminlevel = adminlevel == null ? null : adminlevel.trim();
    }

    public String getQrcodeurl() {
        return qrcodeurl;
    }

    public void setQrcodeurl(String qrcodeurl) {
        this.qrcodeurl = qrcodeurl == null ? null : qrcodeurl.trim();
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
        AdminUser other = (AdminUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getAdminlevel() == null ? other.getAdminlevel() == null : this.getAdminlevel().equals(other.getAdminlevel()))
            && (this.getQrcodeurl() == null ? other.getQrcodeurl() == null : this.getQrcodeurl().equals(other.getQrcodeurl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getAdminlevel() == null) ? 0 : getAdminlevel().hashCode());
        result = prime * result + ((getQrcodeurl() == null) ? 0 : getQrcodeurl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", adminlevel=").append(adminlevel);
        sb.append(", qrcodeurl=").append(qrcodeurl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
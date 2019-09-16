package com.xxx.frame.Service;

import com.xxx.frame.Entity.CompanyProfile;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Entity.UserInfo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public interface UserInfoService {
    Map<String,Object> findPage(UserInfo userInfo);

    ResultModel registerUser(UserInfo userInfo,Integer adminId);

    ResultModel userLogin(UserInfo userInfo) throws UnsupportedEncodingException;

    ResultModel updateUser(UserInfo userInfo);

    ResultModel queryUserInfo(String attribute) throws IOException;

    List<CompanyProfile> selectCompanyProfile();

    void insertUserInfoByAdminId(UserInfo userInfo, String substring);

    ResultModel VIPPay(String attribute);
}

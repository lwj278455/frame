package com.xxx.frame.Controller.Api;

import com.alibaba.fastjson.JSONObject;
import com.xxx.frame.Annotation.Api;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Entity.Model.SmsResult;
import com.xxx.frame.Entity.UserInfo;
import com.xxx.frame.Entity.Wechat.AccessTokenMode;
import com.xxx.frame.Entity.Wechat.UserInfoMode;
import com.xxx.frame.Interceptor.ApiInterceptor;
import com.xxx.frame.Service.UserInfoService;
import com.xxx.frame.Util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Random;

@RequestMapping("api/user")
@RestController
public class ApiUserController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private HttpServletRequest request;


    @RequestMapping("queryUserInfo")
    public ResultModel queryUserInfo(){
        String attribute = (String)request.getAttribute(ApiInterceptor.LOGIN_USER_KEY);
        try {
            return userInfoService.queryUserInfo(attribute);
        } catch (IOException e) {
            return new ResultModel(500,e.getMessage());
        }
    }
    @Api
    @RequestMapping("companyProfile")
    public ResultModel companyProfile(){
        return new ResultModel(200,"ok",userInfoService.selectCompanyProfile());
    }



   /* @Api
    @RequestMapping("register")
    public ResultModel register(@RequestBody String jsonParam ){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        Integer adminId = jsonObject.get("adminId")==null?null:(Integer)jsonObject.get("adminId");
        String code = jsonObject.get("code")==null?null:(String)jsonObject.get("code");
        if(code==null){
            return new ResultModel(500,"Code can not be null");
        }
        AccessTokenMode openId = null;
        try {
            openId = WeChatUtil.getOpenId(code);
        } catch (Exception e) {
            return new ResultModel(500,"请求微信服务失败！");
        }
        UserInfo userInfo = JSONObject.parseObject(jsonObject.get("userInfo").toString(),UserInfo.class);
        userInfo.setOpenid(openId.getOpenid());
        userInfo.setUserLevel("0");
        userInfo.setAvatarurl("/serverdata/image/ERROR/ERROR.jpg");
        return userInfoService.registerUser( userInfo, adminId);
    }*/

    @Api
    @RequestMapping("login")
    public ResultModel login(@RequestBody String jsonParam ){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        String code = jsonObject.get("code")==null?null:(String)jsonObject.get("code");
        if(code==null){
            return new ResultModel(500,"Code can not be null");
        }
        try {
            AccessTokenMode openId = WeChatUtil.getOpenId(code);
            if(openId.getErrcode()!=0){
                return new ResultModel(500,"微信服务器返回异常",openId);
            }
            UserInfo userinfo = WeChatUtil.userinfo(openId);
            if(userinfo.getErrcode()!=0){
                return new ResultModel(500,"微信服务器返回异常",userinfo);
            }
            if(userinfo.getSubscribe()==0){
                return new ResultModel(201,"用户未关注公众平台");
            }
            return userInfoService.userLogin(userinfo);
        } catch (Exception e) {
            return new ResultModel(500,e.getMessage());
        }
    }
    @RequestMapping("updateUser")
    public ResultModel updateUser(@RequestBody String jsonParam ) throws UnsupportedEncodingException {
        UserInfo userInfo = JSONObject.parseObject(jsonParam,UserInfo.class);
        if(userInfo.getHeadimgurl()!=null){
            ResultModel resultModel = UpLoadFileUtil.GenerateImage(userInfo.getHeadimgurl());
            if(resultModel.getErrcode()==200){
                userInfo.setHeadimgurl(resultModel.getErrmsg());
            }else{
                return resultModel;
            }
        }
        if(userInfo.getNickname()!=null){
            //编码
            final BASE64Encoder encoder = new BASE64Encoder();
            final String encodedText = encoder.encode(userInfo.getNickname().getBytes("UTF-8"));
            userInfo.setNickname(encodedText);
        }
        userInfo.setId((String)request.getAttribute(ApiInterceptor.LOGIN_USER_KEY));
        return userInfoService.updateUser(userInfo);
    }

    @Api
    @RequestMapping(value = {"/sendVCode"})
    public ResultModel sendVCode(@RequestBody String jsonParam ){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        String phone = jsonObject.get("phone").toString();
        SmsResult smsResult ;
        try {
            smsResult =  SendMsgUtil.sendVCode(phone);
        } catch (Exception e) {
            return new ResultModel(200,"短信接口调用异常");
        }
        return new ResultModel(200,"ok",smsResult);
    }


    @Api
    @RequestMapping(value = {"/checkVCode"})
    public ResultModel checkVCode(@RequestBody String jsonParam ){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        String phone = jsonObject.get("phone").toString();
        String vCode = jsonObject.get("vCode").toString();

        Cache cacheInfo = CacheManager.getCacheInfo(phone);
        if(cacheInfo==null||cacheInfo.isExpired()){
            return new ResultModel(500,"验证失败！");
        }
        if(cacheInfo.getData().toString().equals(vCode)){
            return new ResultModel(200,"验证成功！");
        }
        return new ResultModel(500,"验证失败！");
    }


    @RequestMapping("VIPPay")
    public ResultModel VIPPay(){
        String attribute = (String)request.getAttribute(ApiInterceptor.LOGIN_USER_KEY);
        return userInfoService.VIPPay(attribute);
    }

}

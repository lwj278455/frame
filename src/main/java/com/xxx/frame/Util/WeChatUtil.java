package com.xxx.frame.Util;

import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xxx.frame.Entity.UserInfo;
import com.xxx.frame.Entity.Wechat.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class WeChatUtil {

    /**
     * 获取用户的openid
     * @param code
     * @return
     * @throws Exception
     */
       public static AccessTokenMode getOpenId(String code) throws Exception {
           String url  = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxaf8f85909a019bd8&secret=eeefba613c49f57ac61d97b989c34dfd&code=%%%%%%%%%%%&grant_type=authorization_code";
           url = url.replace("%%%%%%%%%%%", code);
           String s = HttpClientUtils.doGet(url);
           AccessTokenMode accessTokenMode = JSONObject.parseObject(s, AccessTokenMode.class);
           return accessTokenMode;
        }


    /**
     * 获取公众号的accToken
     * @return
     * @throws Exception
     */
    public static AccTokenMode getAccToken() throws Exception {
        String url  = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxaf8f85909a019bd8&secret=eeefba613c49f57ac61d97b989c34dfd";
        String s = HttpClientUtils.doGet(url);
        AccTokenMode accessTokenMode = JSONObject.parseObject(s, AccTokenMode.class);
        return accessTokenMode;
    }

    /**
     * 获取用户的基本信息
     * @param accessTokenMode
     */
    public static UserInfo  userinfo(AccessTokenMode accessTokenMode) throws Exception {
       // String url  = "https://api.weixin.qq.com/sns/userinfo?" +
        String url = "https://api.weixin.qq.com/cgi-bin/user/info?"+
                "access_token="+ConstantManger.accToken+"&" +
                "openid="+accessTokenMode.getOpenid();
        String s = HttpClientUtils.doGet(url);
        System.out.println("----------------------------------------------");
        UserInfo userInfo = JSONObject.parseObject(s, UserInfo.class);

        if(userInfo.getErrcode()!=0&&userInfo.getErrmsg()!=null&& userInfo.getErrmsg().contains("access_token")){//返回异常时
            AccTokenMode accToken = WeChatUtil.getAccToken();
            ConstantManger.accToken = accToken.getAccess_token();
            return WeChatUtil.userinfo(accessTokenMode);
        }
        userInfo.setId(accessTokenMode.getOpenid());
        return userInfo;
    }

    /** 生成二维码并保存到本地
     * https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN
     */
    public static String getqrCode(String SceneId,String userName) throws Exception {
        String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+ConstantManger.accToken;
        String jsonParam = "{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": "+SceneId+"}}}";
        String s = HttpClientUtils.doPostWithJson(url, jsonParam);
        TicketMode ticketMode = JSONObject.parseObject(s, TicketMode.class);

        if(ticketMode.getErrcode()!=0&&ticketMode.getErrmsg()!=null&& ticketMode.getErrmsg().contains("access_token")){//返回异常时
            AccTokenMode accToken = WeChatUtil.getAccToken();
            ConstantManger.accToken = accToken.getAccess_token();
            return WeChatUtil.getqrCode(SceneId,userName);
        }

        return UpLoadFileUtil.upLoadQrCodeImg("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+ticketMode.getTicket(),userName).getErrmsg();
    }


    public static void main(String[] args) {
        try {
            String s=getqrCode("123","离散");
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }













    /*public Object wxSign(String repayId){
        try {
            SignInfo signInfo = new SignInfo();
            signInfo.setAppId(WECHATCONSTANT.WECHAT_APPID);
            long time = System.currentTimeMillis()/1000;
            signInfo.setTimeStamp(String.valueOf(time));
            signInfo.setNonceStr(RandomStringGenerator.getRandomStringByLength(32));
            signInfo.setRepay_id("prepay_id="+repayId);
            signInfo.setSignType("MD5");
            //生成签名
            String sign = generateSignature(signInfo);
            JSONObject json = new JSONObject();
            json.put("timeStamp", signInfo.getTimeStamp());
            json.put("nonceStr", signInfo.getNonceStr());
            json.put("package", signInfo.getRepay_id());
            json.put("signType", signInfo.getSignType());
            json.put("paySign", sign);
            return json;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }



    *//**
     * 签名算法
     * @param o 要参与签名的数据对象
     * @return 签名
     * @throws IllegalAccessException
     *//*
    private static String generateSignature(Object o) throws IllegalAccessException {
        ArrayList<String> list = new ArrayList<String>();
        Class cls = o.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            if (f.get(o) != null && f.get(o) != "") {
                String name = f.getName();
                XStreamAlias anno = f.getAnnotation(XStreamAlias.class);
                if(anno != null)
                    name = anno.value();
                list.add(name + "=" + f.get(o) + "&");
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + WECHATCONSTANT.WECHAT_MACHID_KEY;
        System.out.println("签名数据："+result);
        result = MD5Util.md5Encrypt32Upper(result);
        return result;
    }*/
}

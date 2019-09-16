package com.xxx.frame.Util;

import com.thoughtworks.xstream.XStream;
import com.xxx.frame.Entity.Model.SmsResult;

import java.util.Random;

public class SendMsgUtil {

    private static final String userid = "10264";//企业id
    private static final String userName = "rbfxueyuan";//账号
    private static final String passWord = "rbfxueyuan";//密码


    public static SmsResult sendVCode(String phone) throws Exception {
       long timestamp = System.currentTimeMillis();
        String sign = MD5Util.md5Encrypt32Lower(userName+passWord+timestamp);
        String verifyCode = String
                .valueOf(new Random().nextInt(899999) + 100000);//生成短信验证码
        //设置缓存
        Cache cache = new Cache();
        cache.setKey(phone);
        cache.setData(verifyCode);
        cache.setTimeOut(timestamp+300000);//3分钟
        //cache.setTimeOut(timestamp+180000);//5分钟
        CacheManager.putCache(phone,cache);
        //生成请求数据
        String url = "http://120.77.14.55:8888/v2sms.aspx?action=send&userid="+userid+"&timestamp="+timestamp+"&sign="+sign+"&mobile="+phone+"&content=【睿铂弗商学院】验证码："+verifyCode;
        String xml = HttpClientUtils.doGet(url);
        XStream xStream = new XStream();
        //JSONObject.
        xStream.processAnnotations(SmsResult.class);
        return (SmsResult)xStream.fromXML(xml);
    }

}

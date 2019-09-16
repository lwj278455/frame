package com.xxx.frame;

import com.alibaba.fastjson.JSONObject;
import com.xxx.frame.Entity.Model.OrderResult;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.UserInfo;
import com.xxx.frame.Entity.Wechat.SignInfo;
import com.xxx.frame.Service.UserInfoService;
import com.xxx.frame.Util.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class FrameApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void contextLoads() throws UnsupportedEncodingException {
        try {
            String s = HttpClientUtils.doGet("http://192.168.2.188:8080/mumic/api/addCourseTime?openId=1&xingqi=1&times=11:00-12:00&state=1&uid=1");
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void t() throws UnsupportedEncodingException {
        int i = 1/0;
        int e1 = 0/1;
        String result = "https://www.rebirth901.com/class/register?isre=1";
        try {
            result = java.net.URLEncoder.encode(result,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    @Test
    public void ccc() {
        Object o = wxSign("1");
        System.out.println(o);
    }

    public Object wxSign(String repayId){
        try {
            SignInfo signInfo = new SignInfo();
            signInfo.setAppId(WECHATCONSTANT.WECHAT_APPID);
            signInfo.setTimeStamp("1556269565");
            signInfo.setNonceStr("aiqoys9ecgx7l43yd6n85h6uyagduipo");
            signInfo.setRepay_id("wx26170547201556fa41c1775f3022896106");
            signInfo.setSignType("MD5");


            //生成签名
            String sign = SignUtil.generateSignature(signInfo);
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
/**
 *
 *
 *
 */



// 全局数组
private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
        "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 返回形式只为数字
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    public static String GetMD5Code(String string,String key) {
        string=string+"&key="+key;
//    	 System.out.println("签名字符串:"+string);
        String resultString = null;
        try {
            resultString = new String(string);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest(string.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }
    /*
     * 中付签名
     * */
    public static String GetZFMD5Code(String string,String key) {
        string=string+key;
        System.out.println(string);
        String resultString = null;
        try {
            resultString = new String(string);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest(string.getBytes()));
        } catch(NoSuchAlgorithmException ex){
            ex.printStackTrace();
        }
        return resultString;
    }

    /**
     * MD5加密算法
     *
     * 说明：32位加密算法
     *
     * @param
     * @return 加密结果，全小写的字符串(utf-8)
     */
    public static String md5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] btInput = s.getBytes("utf-8");
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Test
    public void asd() throws Exception {
        String s = md5("appId=wxaf8f85909a019bd8&nonceStr=aiqoys9ecgx7l43yd6n85h6uyagduipo&repay_id=wx26170547201556fa41c1775f3022896106&signType=MD5&timeStamp=1556269565&key=846886269A2FFE9D082C2AC44D5A26E6");
        System.out.println(s);
    }


}

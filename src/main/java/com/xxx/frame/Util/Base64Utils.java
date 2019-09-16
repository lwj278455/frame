package com.xxx.frame.Util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Base64Utils {
     //编码
    private static final BASE64Encoder encoder = new BASE64Encoder();
    private static final BASE64Decoder decoder = new BASE64Decoder();

    /**
     * 加密
     * @param str
     * @return
     */
    public static  String encode(String str){
        try {
           return encoder.encode(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 解密
     * @return
     */
    public static String decoder(String str){
        try {
            return new String(decoder.decodeBuffer(str),"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }



}

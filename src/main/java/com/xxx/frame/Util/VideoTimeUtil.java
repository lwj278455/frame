package com.xxx.frame.Util;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;

public class VideoTimeUtil {
    /**
     * 获取视频时间长度
     * @param source
     * @return
     */
   public static Long countVideoTime(File source){
       Encoder encoder = new Encoder();
       long ls =0;
       try {
           MultimediaInfo m = encoder.getInfo(source);
           ls = m.getDuration()/1000;//ls是获取到的秒数
       } catch (Exception e) {
           e.printStackTrace();
       }
       return  ls*1000;
   }
}

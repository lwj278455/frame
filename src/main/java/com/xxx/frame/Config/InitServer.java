package com.xxx.frame.Config;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.xxx.frame.Controller.Api.ApiController;
import com.xxx.frame.Dao.ClassTypeMapper;
import com.xxx.frame.Entity.ClassTypeExample;
import com.xxx.frame.Entity.Wechat.AccTokenMode;
import com.xxx.frame.Util.ConstantManger;
import com.xxx.frame.Util.WeChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 项目启动后执行
 */
@Component
@Order(1)
public class InitServer implements CommandLineRunner {
    private static final Logger logger = new LoggerContext().getLogger(ApiController.class);
    @Autowired
    private ClassTypeMapper classTypeMapper;

    @Override
    public void run(String... args) throws Exception {
        logger.info("项目启动"+new SimpleDateFormat("yyyy MM dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
        logger.info("初始化课程类型信息");
        ConstantManger.classTypeList = classTypeMapper.selectAllType();
    }


    //3.添加定时任务

    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    @Scheduled(fixedRate = 3600000)//不到2个小时执行一次替换token
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
        AccTokenMode accToken = null;
        try {
            accToken = WeChatUtil.getAccToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(accToken!=null&&accToken.getAccess_token()!=null){
            ConstantManger.accToken = accToken.getAccess_token();
        }
        System.err.println("accToken替换为:   " + accToken.getAccess_token());
        System.err.println("执行静态定时任务结束时间: " + LocalDateTime.now());
    }

    @Scheduled(fixedRate = 5000)//不到2个小时执行一次替换token
    private void te() {
        System.err.println("定时任务测试------           "+ConstantManger.accToken);
    }
}

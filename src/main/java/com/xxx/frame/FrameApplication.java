package com.xxx.frame;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;


/*@MapperScan("com.xxx.frame")*/
@MapperScan("com.xxx.frame.Dao")
@SpringBootApplication
@EnableScheduling
public class FrameApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FrameApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(FrameApplication.class, args);
    }

}

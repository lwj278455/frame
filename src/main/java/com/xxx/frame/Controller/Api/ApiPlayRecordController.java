package com.xxx.frame.Controller.Api;

import com.alibaba.fastjson.JSONObject;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Entity.PlayRecord;
import com.xxx.frame.Interceptor.ApiInterceptor;
import com.xxx.frame.Service.PlayRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("api/playRecord")
public class ApiPlayRecordController {

    @Autowired
    private PlayRecordService playRecordService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("findRecord")
    public ResultModel findRecord(@RequestBody String jsonParam){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        int pageNum = (int) jsonObject.get("pageNum");
        int pageSize = (int) jsonObject.get("pageSize");
        int weekTag =  (int)jsonObject.get("weekTag");
        String attribute = (String)request.getAttribute(ApiInterceptor.LOGIN_USER_KEY);
        PlayRecord playRecord = new PlayRecord();
        playRecord.setWeekTag(weekTag);
        playRecord.setUserid(attribute);
        Calendar c = Calendar.getInstance();
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, - 7);
        Date d = c.getTime();
        playRecord.setPlaydate(d);
       return new ResultModel(200,"ok",playRecordService.selectByE(playRecord,pageNum,pageSize));
    }


    @RequestMapping("addRecord")
    public ResultModel addRecord(@RequestBody String jsonParam){
        PlayRecord playRecord = JSONObject.parseObject(jsonParam, PlayRecord.class);
        playRecord.setUserid((String)request.getAttribute(ApiInterceptor.LOGIN_USER_KEY));
        playRecord.setPlaydate(new Date());
        return playRecordService.addRecord(playRecord);
    }

}

package com.xxx.frame.Controller.Api;

import com.alibaba.fastjson.JSONObject;
import com.xxx.frame.Annotation.Api;
import com.xxx.frame.Entity.ClassInfo;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Entity.PlayRecord;
import com.xxx.frame.Interceptor.ApiInterceptor;
import com.xxx.frame.Service.ClassInfoService;
import com.xxx.frame.Service.PlayRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@RequestMapping("api/classInfo")
@RestController
public class ApiClassInfoController {
    @Autowired
    private ClassInfoService classInfoService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private PlayRecordService playRecordService;

    /**
     * 课程分页查询
      * @param jsonParam
     * @return
     */
    @Api
    @RequestMapping(value = "findPage")
    public ResultModel findPage(
           @RequestBody String jsonParam){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        int pageNum = (int)jsonObject.get("pageNum");
        int pageSize = (int)jsonObject.get("pageSize");
        ClassInfo classInfo = JSONObject.parseObject(jsonObject.get("classInfo").toString(),ClassInfo.class);
        PageResult page = classInfoService.findPage(pageNum, pageSize, classInfo);
        return new ResultModel(200,"success",page);
    }

    /**
     * 线下课程分页查询
     * @param jsonParam
     * @return
     */
    @RequestMapping("offLineClassPage")
    public ResultModel findOffLineClass(
            @RequestBody String jsonParam) {
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        int pageNum = (int) jsonObject.get("pageNum");
        int pageSize = (int) jsonObject.get("pageSize");
        ClassInfo classInfo = new ClassInfo();
        classInfo.setLinetype(1);//查询线下的课程
        PageResult page = classInfoService.findPage(pageNum, pageSize, classInfo);
        return new ResultModel(200, "success", page);
    }

    /**
     * 查询单个课程
     * @param jsonParam
     * @return
     */
    @Api
    @RequestMapping(value = "findClassInfo")
    public ResultModel findClassInfo(@RequestBody String jsonParam){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        Object userId = request.getAttribute(ApiInterceptor.LOGIN_USER_KEY);
        if(userId!=null){
            PlayRecord playRecord = new PlayRecord();
            playRecord.setClassid((Integer)jsonObject.get("id"));
            playRecord.setUserid((String)userId);
            playRecord.setPlaydate(new Date());
        }
        return new ResultModel(200,"success",classInfoService.selectById((Integer)jsonObject.get("id")));
    }

    /**
     * 查询课程列表
     * @param jsonParam
     * @return
     */
    @Api
    @RequestMapping(value = "findClassList")
    public ResultModel findClassList( @RequestBody String jsonParam){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        return classInfoService.findClassList((Integer)jsonObject.get("id"),(Integer)jsonObject.get("pageNum"),(Integer)jsonObject.get("pageSize"));
    }

    /**
     * 判断是否存在课程的关联信息
     * @param jsonParam
     * @return
     */
    @RequestMapping(value = "checkUserClass")
    public ResultModel checkUserClass(@RequestBody String jsonParam){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        String userId = (String)request.getAttribute(ApiInterceptor.LOGIN_USER_KEY);
        return classInfoService.checkUserClass(userId, (Integer)jsonObject.get("id"));
    }

    /**
     * 申请线下课程
     * @param jsonParam
     * @return
     */
    @RequestMapping(value = "applyClass")
    public ResultModel applyClass(@RequestBody String jsonParam){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        String userId = (String)request.getAttribute(ApiInterceptor.LOGIN_USER_KEY);
        return classInfoService.applyClass(userId, (Integer)jsonObject.get("id"));
    }











}

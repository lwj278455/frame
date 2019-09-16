package com.xxx.frame.Controller.Api;

import com.alibaba.fastjson.JSONObject;
import com.xxx.frame.Annotation.Api;
import com.xxx.frame.Entity.ClassColumn;
import com.xxx.frame.Entity.ClassInfo;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/column")
@RestController
public class ApiColumnController {

    @Autowired
    private ColumnService columnService;


    @Api
    @RequestMapping("findPage")
    public ResultModel findPage(
            @RequestBody String jsonParam) {
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        int pageNum = (int) jsonObject.get("pageNum");
        int pageSize = (int) jsonObject.get("pageSize");
        ClassColumn classInfo = JSONObject.parseObject(jsonObject.get("classColumn").toString(),ClassColumn.class);
        PageResult page = columnService.findPage(pageNum, pageSize, classInfo);
        return new ResultModel(200, "success", page);
        //return null;
    }

    @Api
    @RequestMapping("findById")
    public ResultModel findById(
            @RequestBody String jsonParam) {
        ClassColumn classInfo = JSONObject.parseObject(jsonParam,ClassColumn.class);
        ClassColumn page = columnService.findByID(classInfo);
        return new ResultModel(200, "success", page);
    }



}

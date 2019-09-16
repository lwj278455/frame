package com.xxx.frame.Controller.Api;

import com.alibaba.fastjson.JSONObject;
import com.xxx.frame.Annotation.Api;
import com.xxx.frame.Entity.Content;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/content")
@RestController
public class ApiContentController {

    @Autowired
    private ContentService contentService;


    @Api
    @RequestMapping("selectContent")
    public ResultModel selectContent(@RequestBody String jsonParam){
        Content content = JSONObject.parseObject(jsonParam,Content.class);
        List<Content> contents = contentService.selectByE(content);
        return new ResultModel(200,"OK",contents);
    }

    @Api
    @RequestMapping("selectContentt")
    public ResultModel selectContentt(@RequestParam("ctype") String ctype){
        Content content = new Content();
        content.setCtype(ctype);
        List<Content> contents = contentService.selectByE(content);
        return new ResultModel(200,"OK",contents);
    }
}

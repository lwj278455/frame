package com.xxx.frame.Controller.Api;

import com.alibaba.fastjson.JSONObject;
import com.xxx.frame.Annotation.Api;
import com.xxx.frame.Entity.ClassInfo;
import com.xxx.frame.Entity.Comment;
import com.xxx.frame.Entity.Content;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Interceptor.ApiInterceptor;
import com.xxx.frame.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequestMapping("api/content")
@RestController
public class ApiCommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("addContent")
    public ResultModel addContent(@RequestBody String jsonParam){
        Comment comment = JSONObject.parseObject(jsonParam, Comment.class);
        comment.setUserid((String)request.getAttribute(ApiInterceptor.LOGIN_USER_KEY));
        comment.setCreateTime(new Date());
        return commentService.addContent(comment);
    }

    @Api
    @RequestMapping("findPage")
    public ResultModel findPage(@RequestBody String jsonParam){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        int pageNum = (int)jsonObject.get("pageNum");
        int pageSize = (int)jsonObject.get("pageSize");
        Comment comment = JSONObject.parseObject(jsonObject.get("comment").toString(),Comment.class);
        return commentService.findPage(pageNum,pageSize,comment);
    }

}

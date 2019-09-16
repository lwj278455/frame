package com.xxx.frame.Controller.Api;

import com.alibaba.fastjson.JSONObject;
import com.xxx.frame.Entity.Member;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/member")
@RestController
public class ApiMemberController {
    @Autowired
    private MemberService memekerService;

    @RequestMapping("findMembers")
    public ResultModel findMembers(){
        return memekerService.findMembers();
    }

    @RequestMapping("addMember")
    public ResultModel addMember(@RequestBody String jsonParam){
        Member member = JSONObject.parseObject(jsonParam,Member.class);
        return memekerService.addMember(member);
    }

    @RequestMapping("findById")
    public ResultModel findById(@RequestBody String jsonParam){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        return memekerService.findById((Integer)jsonObject.get("id"));
    }

    @RequestMapping("updateMember")
    public ResultModel updateMember(@RequestBody String jsonParam){
        Member member = JSONObject.parseObject(jsonParam,Member.class);
        return memekerService.updateMember(member);
    }
    @RequestMapping("delMember")
    public ResultModel delMember(@RequestBody String jsonParam){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        return memekerService.delMember((Integer)jsonObject.get("id"));
    }
}

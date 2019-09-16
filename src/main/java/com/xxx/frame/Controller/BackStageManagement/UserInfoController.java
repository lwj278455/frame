package com.xxx.frame.Controller.BackStageManagement;

import com.xxx.frame.Annotation.Login;
import com.xxx.frame.Entity.AdminUser;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.UserInfo;
import com.xxx.frame.Service.AdminUserService;
import com.xxx.frame.Service.PlayRecordService;
import com.xxx.frame.Service.UserInfoService;
import com.xxx.frame.Util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("Manager")
@Controller
public class UserInfoController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private PlayRecordService recordService;


    @RequestMapping("userManage_{pageCurrent}_{pageSize}_{pageCount}")
    public String userManage(
            @PathVariable("pageCurrent") int pageCurrent,
            @PathVariable("pageSize") int pageSize,
            @PathVariable("pageCount") int pageCount ,
            AdminUser adminUser,
            Model model){
        //初始化分页条件
        if (pageSize == 0) pageSize = 10;
        if (pageCurrent == 0) pageCurrent = 1;
        //查询数据列表
        PageResult r = adminUserService.findPage(pageCurrent,pageSize,adminUser);
        //生成分页模板
        if (pageCount == 0) pageCount = (int) (r.getTotal() % pageSize == 0 ? (r.getTotal() / pageSize) : (r.getTotal() / pageSize) + 1);
        String pageHTML = PageUtil.getPageContent("userManage_{pageCurrent}_{pageSize}_{pageCount}", pageCurrent, pageSize, pageCount);
        //将数据放置至Model
        model.addAttribute("pageHTML", pageHTML);
        model.addAttribute("pageInfo",r.getRows());
        model.addAttribute("adminUser",adminUser);
        return "user/userManage";
    }

    @RequestMapping("ListUser")
    public String ListUser(UserInfo userInfo,
            Model model){
        //初始化分页条件
        if(userInfo!=null&&userInfo.getNickname()!=null){
            userInfo.setNickname(userInfo.encodeNickName());
        }
        //查询数据列表
        Map<String, Object> page = userInfoService.findPage(userInfo);
        //生成分页模板
        //将数据放置至Model
        model.addAttribute("page",page);
        model.addAttribute("userInfo",userInfo);
        return "user/userList";
    }

    @RequestMapping("selectPlayRecord")
    public String selectPlayRecord(UserInfo userInfo,
                           Model model){
        model.addAttribute("playRecord", recordService.selectByUserId(userInfo.getId()));
        return "user/playRecord";
    }

    @RequestMapping("/upLev")
    public String upLev(UserInfo userInfo){
        userInfo.setUserLevel("1");
        userInfoService.updateUser(userInfo);
        return "redirect:ListUser";
    }


    @RequestMapping("/downLev")
    public String downLev(UserInfo userInfo){
        userInfo.setUserLevel("0");
        userInfoService.updateUser(userInfo);
        return "redirect:ListUser";
    }

}

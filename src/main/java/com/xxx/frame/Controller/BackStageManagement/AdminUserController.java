package com.xxx.frame.Controller.BackStageManagement;

import com.xxx.frame.Entity.AdminUser;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Entity.Wechat.TicketMode;
import com.xxx.frame.Service.AdminUserService;
import com.xxx.frame.Util.ConstantManger;
import com.xxx.frame.Util.UpLoadFileUtil;
import com.xxx.frame.Util.WeChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("Manager")
@Controller
public class AdminUserController {

    @Autowired
    private AdminUserService  adminUserService;
    @Autowired
    private HttpServletRequest request;


    @RequestMapping("adminUserEdit")
    public String adminUserEdit(Integer id, Model model){
        if(id!=null){
            model.addAttribute("adminUser",adminUserService.findById(id));
        }
        return "/user/userEdit";
    }

    @RequestMapping("adminUserAddOrUpdate")
    public String adminUserAddOrUpdate(AdminUser adminUser,Model model) throws Exception {
        ResultModel resultModel = adminUserService.adminUserAddOrUpdate(adminUser);
        if(resultModel.getErrcode()!=200){
            model.addAttribute("errorMsg",resultModel.getErrmsg());
            model.addAttribute("adminUser",adminUser);
            return "/user/userEdit";
        }
        return "redirect:userManage_0_0_0";
    }


    @RequestMapping("getQrcode")
    public String getQrcode(){
        return "/user/QrCode";
    }

    @RequestMapping("dleadminUser")
    public String dleadminUser(Integer id){
        adminUserService.delAdminUser(id);
        return "redirect:userManage_0_0_0";
    }
}

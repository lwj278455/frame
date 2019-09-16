package com.xxx.frame.Controller.BackStageManagement;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.xxx.frame.Annotation.Login;
import com.xxx.frame.Controller.Api.ApiController;
import com.xxx.frame.Entity.AdminUser;
import com.xxx.frame.Entity.UserInfo;
import com.xxx.frame.Service.AdminUserService;
import com.xxx.frame.Util.WeChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@RequestMapping("Manager")
@Controller
public class UserController {
    private static final Logger logger = new LoggerContext().getLogger(ApiController.class);

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private HttpSession httpSession;

    @Login
    @GetMapping("/login")
    public String toLogin(){
        logger.info("login");
        return "login";
    }

    /**
     * 登录
     *
     * @param
     * @param model
     * @param
     * @return
     */
    @Login
    @PostMapping("/login")
    public String loginPost(AdminUser user, Model model) {
        if(user.getUsername()==null||user.getPassword()==null){
            model.addAttribute("error", "账号密码不能为空！");
            return "login";
        }
        logger.info(adminUserService.toString());
        AdminUser finduser = adminUserService.login(user);
        if (finduser != null) {
            httpSession.setAttribute("user", finduser);
            AdminUser name = (AdminUser) httpSession.getAttribute("user");
            return "redirect:dashboard";
        } else {
            model.addAttribute("error", "用户名或密码错误，请重新登录！");
            return "login";
        }
    }

    @RequestMapping("/loginOut")
    public String loginOut(){
        httpSession.removeAttribute("user");
        return "redirect:login";
    }

    @RequestMapping("/newQrCode")
    public String newQrCode() throws Exception {
        AdminUser user = (AdminUser) httpSession.getAttribute("user");
        WeChatUtil.getqrCode(user.getId().toString(),user.getUsername());
        return "redirect:getQrcode";
    }


}

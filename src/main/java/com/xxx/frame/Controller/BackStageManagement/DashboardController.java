package com.xxx.frame.Controller.BackStageManagement;

import com.xxx.frame.Annotation.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 仪表板页面
 *
 * @param model
 * @return
 */

/**
 */
@RequestMapping("Manager")
@Controller
public class DashboardController {


    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "/dashboard";
    }



}
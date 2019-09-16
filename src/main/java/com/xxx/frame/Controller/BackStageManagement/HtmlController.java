package com.xxx.frame.Controller.BackStageManagement;

import com.xxx.frame.Annotation.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("Manager")
@Controller
public class HtmlController {

    @Login
    @RequestMapping("{url}.html")
    public String tohtml(@PathVariable("url") String url){
        return "demo/"+url;
    }


}

package com.xxx.frame.Controller.Api;

import com.xxx.frame.Annotation.Api;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Service.ClassTypeService;
import com.xxx.frame.Util.ConstantManger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/classType")
@RestController
public class ApiClassTypeController {

    @Autowired
    private ClassTypeService classTypeService;

    @Api
    @RequestMapping("selectClassType")
    public ResultModel selectClassType(){
        return new ResultModel(200,"查询成功", ConstantManger.classTypeList);
    }


}

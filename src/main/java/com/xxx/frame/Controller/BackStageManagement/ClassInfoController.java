package com.xxx.frame.Controller.BackStageManagement;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.xxx.frame.Entity.ClassInfo;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Service.ClassInfoService;
import com.xxx.frame.Service.ColumnService;
import com.xxx.frame.Util.ConstantManger;
import com.xxx.frame.Util.PageUtil;
import com.xxx.frame.Util.UpLoadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequestMapping("Manager")
@Controller
public class ClassInfoController {
    private static final Logger logger = new LoggerContext().getLogger(ClassInfoController.class);
    @Autowired
    private ClassInfoService classInfoService;
    @Autowired
    private ColumnService columnService;




    @RequestMapping("classManger_{pageCurrent}_{pageSize}_{pageCount}")
    public String classManger(
            @PathVariable("pageCurrent") int pageCurrent,
            @PathVariable("pageSize") int pageSize,
            @PathVariable("pageCount") int pageCount ,
            ClassInfo classInfo,
            Model model){
        //初始化分页条件
        if (pageSize == 0) pageSize = 10;
        if (pageCurrent == 0) pageCurrent = 1;
        //查询数据列表
        PageResult r = classInfoService.findPage(pageCurrent,pageSize,classInfo);
        //生成分页模板
        if (pageCount == 0) pageCount = (int) (r.getTotal() % pageSize == 0 ? (r.getTotal() / pageSize) : (r.getTotal() / pageSize) + 1);
        String pageHTML = PageUtil.getPageContent("classManger_{pageCurrent}_{pageSize}_{pageCount}", pageCurrent, pageSize, pageCount);
        //将数据放置至Model
        model.addAttribute("pageHTML", pageHTML);
        model.addAttribute("pageInfo",r.getRows());
        model.addAttribute("classInfo",classInfo);
        model.addAttribute("ConstantManger",ConstantManger.getConstantManger());
        return "classInfo/classManger";
    }

    @RequestMapping("classEdit")
    public String classEdit(Integer id,Model model){
        model.addAttribute("columnList",columnService.selectAll());
        if(id!=null){
            model.addAttribute("classInfo",classInfoService.selectById(id));
        }
        model.addAttribute("ConstantManger",ConstantManger.getConstantManger());
        return "/classInfo/classInfoEdit";
    }


    @RequestMapping("classAddOrUpdate")
    public String classAddOrUpdate(/*@RequestParam(value = "file",required = false) MultipartFile file,//课程图片*/
                                   //@RequestParam(value = "ClassFile",required = false) MultipartFile ClassFile, //课程文件
                                   ClassInfo classInfo,
                                   Model model){
        model.addAttribute("ConstantManger",ConstantManger.getConstantManger());
        model.addAttribute("classInfo",classInfo);
        //如果不是课件类型，修改课程信息时文件可能为空
       /* if(classInfo.getLinetype() == 0 && classInfo.getClasstype()!=2 && ClassFile!=null && ClassFile.getSize()>0){
            //上传课程文件
            ResultModel resultModel2 = UpLoadFileUtil.fileUpload(ClassFile);
            if(0==resultModel2.getErrcode()){
                classInfo.setFilepath(resultModel2.getErrmsg());
            }else{
                model.addAttribute("error","课程文件上传失败！");
                return "/classInfo/classInfoEdit";
            }
        }*/
        //更新课程更新时间
        classInfo.setCreattime(new Date());
        //如果有ID执行update，否则插入新的数据
        if(classInfo.getId()==null){
            classInfo.setPlaycount(0l);
            classInfoService.insertClass(classInfo);
        }else{
            classInfoService.updateClassByPrimaryKey(classInfo);
        }
        return "redirect:classManger_0_0_0";
    }

    @GetMapping("dleClass")
    public String dleClass(Integer id){
        classInfoService.delClass(id);
        return "redirect:classManger_0_0_0";
    }




}

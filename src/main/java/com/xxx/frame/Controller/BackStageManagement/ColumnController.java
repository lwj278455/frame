package com.xxx.frame.Controller.BackStageManagement;


import com.xxx.frame.Entity.ClassColumn;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Service.ColumnService;
import com.xxx.frame.Util.ConstantManger;
import com.xxx.frame.Util.PageUtil;
import com.xxx.frame.Util.UpLoadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@RequestMapping("Manager")
@Controller
public class ColumnController {

    @Autowired
    private ColumnService columnService;


    @RequestMapping("columnManger_{pageCurrent}_{pageSize}_{pageCount}")
    public String classManger(
            @PathVariable("pageCurrent") int pageCurrent,
            @PathVariable("pageSize") int pageSize,
            @PathVariable("pageCount") int pageCount ,
            ClassColumn classColumn,
            Model model){
        //初始化分页条件
        if (pageSize == 0) pageSize = 10;
        if (pageCurrent == 0) pageCurrent = 1;
        pageCurrent = pageCurrent -1 ;
        //查询数据列表
        PageResult r = columnService.findPage(pageCurrent,pageSize,classColumn);
        //生成分页模板
        if (pageCount == 0) pageCount = (int) (r.getTotal() % pageSize == 0 ? (r.getTotal() / pageSize) : (r.getTotal() / pageSize) + 1);
        String pageHTML = PageUtil.getPageContent("columnManger_{pageCurrent}_{pageSize}_{pageCount}", pageCurrent, pageSize, pageCount);
        //将数据放置至Model
        model.addAttribute("pageHTML", pageHTML);
        model.addAttribute("pageInfo",r.getRows());
        model.addAttribute("classColumn",classColumn);
        model.addAttribute("ConstantManger", ConstantManger.getConstantManger());
        return "column/columnManger";
    }

    @RequestMapping("classColumnEdit")
    public String classColumnEdit(Integer id,Model model){
        model.addAttribute("ConstantManger",ConstantManger.getConstantManger());
        if(id!=null){
            model.addAttribute("classColumn",columnService.selectById(id));
        }
        return "column/classColumnEdit";
    }

    @RequestMapping("delClassColumn")
    public String delClassColumn(Integer id){
        columnService.delClassColumn(id);
        return "redirect:columnManger_0_0_0";
    }



    @RequestMapping("classColumnAddOrUpdate")
    public String classColumnAddOrUpdate(/*@RequestParam(value = "file",required = false) MultipartFile file,//课程图片*/
            @RequestParam(value = "ClassFile",required = false) MultipartFile ClassFile, //课程文件
            ClassColumn classColumn,
            Model model){
        //上传课程文件
        if(ClassFile.getSize()>0){
            ResultModel resultModel2 = UpLoadFileUtil.fileUpload(ClassFile);
            if(0==resultModel2.getErrcode()){
                classColumn.setFilepath(resultModel2.getErrmsg());
            }else{
                model.addAttribute("error","课程文件上传失败！");
                return "column/classColumnEdit";
            }
        }


        if(classColumn.getId()==null){
            columnService.insertClassColumn(classColumn);
        }else{
            columnService.updateClassColumn(classColumn);
        }
        return "redirect:columnManger_0_0_0";
    }


}

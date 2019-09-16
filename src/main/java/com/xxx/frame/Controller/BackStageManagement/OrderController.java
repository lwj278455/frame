package com.xxx.frame.Controller.BackStageManagement;

import com.xxx.frame.Entity.BaseOrderInfo;
import com.xxx.frame.Entity.Member;
import com.xxx.frame.Entity.Model.OrderResult;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.OffLineOrder;
import com.xxx.frame.Entity.OnLineOrder;
import com.xxx.frame.Service.OffLineOderService;
import com.xxx.frame.Service.OnLineOderService;
import com.xxx.frame.Util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("Manager")
@Controller
public class OrderController {
    @Autowired
    private OffLineOderService offLineOderService;
    @Autowired
    private OnLineOderService onLineOderService;

    @RequestMapping("offLineOrderManage_{pageCurrent}_{pageSize}_{pageCount}")
    public String classManger(
            @PathVariable("pageCurrent") int pageCurrent,
            @PathVariable("pageSize") int pageSize,
            @PathVariable("pageCount") int pageCount ,
            BaseOrderInfo order,
            Model model){
        //初始化分页条件
        if (pageSize == 0) pageSize = 50;
        if (pageCurrent == 0) pageCurrent = 1;
        //查询数据列表
        PageResult r = offLineOderService.findPage(pageCurrent,pageSize,order);
        //生成分页模板
        if (pageCount == 0) pageCount = (int) (r.getTotal() % pageSize == 0 ? (r.getTotal() / pageSize) : (r.getTotal() / pageSize) + 1);
        String pageHTML = PageUtil.getPageContent("offLineOrderManger_{pageCurrent}_{pageSize}_{pageCount}", pageCurrent, pageSize, pageCount);
        //将数据放置至Model
        model.addAttribute("pageHTML", pageHTML);
        model.addAttribute("pageInfo",r.getRows());
        model.addAttribute("order",order);
        model.addAttribute("orderType","offLine");
        return "order/orderManage";
    }




    @RequestMapping("onLineOrderManage_{pageCurrent}_{pageSize}_{pageCount}")
    public String onLineOrderManage(
            @PathVariable("pageCurrent") int pageCurrent,
            @PathVariable("pageSize") int pageSize,
            @PathVariable("pageCount") int pageCount ,
            BaseOrderInfo order,
            Model model){
        //初始化分页条件
        if (pageSize == 0) pageSize = 50;
        if (pageCurrent == 0) pageCurrent = 1;
        //查询数据列表
        PageResult r = onLineOderService.findPage(pageCurrent,pageSize,order);
        //生成分页模板
        if (pageCount == 0) pageCount = (int) (r.getTotal() % pageSize == 0 ? (r.getTotal() / pageSize) : (r.getTotal() / pageSize) + 1);
        String pageHTML = PageUtil.getPageContent("offLineOrderManger_{pageCurrent}_{pageSize}_{pageCount}", pageCurrent, pageSize, pageCount);
        //将数据放置至Model
        model.addAttribute("pageHTML", pageHTML);
        model.addAttribute("pageInfo",r.getRows());
        model.addAttribute("order",order);
        model.addAttribute("orderType","onLine");
        return "order/orderManage";
    }


    @RequestMapping("offLineorderDetails")
    public String offLineorderDetails(
            Integer orderId,
            Model model){
        List<Member> members = offLineOderService.selectMembersByOrder(orderId);
        model.addAttribute("members",members);
        return "order/orderDetails";
    }

    /*@RequestMapping("onLineorderDetails")
    public String onLineorderDetails(
            Integer orderId,
            Model model){
        OnLineOrder onLineOrder = onLineOderService.selectById(orderId);
        model.addAttribute("order",onLineOrder);
        model.addAttribute("orderType","onLine");
        return "order/orderDetails";
    }*/



}

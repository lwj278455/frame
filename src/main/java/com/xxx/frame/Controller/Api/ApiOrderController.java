package com.xxx.frame.Controller.Api;

import com.alibaba.fastjson.JSONObject;
import com.xxx.frame.Entity.BaseOrderInfo;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Entity.OnLineOrder;
import com.xxx.frame.Interceptor.ApiInterceptor;
import com.xxx.frame.Service.OnLineOderService;
import com.xxx.frame.Service.OrderService;
import com.xxx.frame.Util.Cache;
import com.xxx.frame.Util.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/order")
public class  ApiOrderController{

    @Autowired
    private OrderService orderService;
    @Autowired
    private HttpServletRequest request;



    @RequestMapping("queryAllOrder")
    public ResultModel queryAllOrder(@RequestBody String jsonParam){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        BaseOrderInfo offLineOrder = JSONObject.parseObject(jsonObject.get("OrderInfo").toString(),BaseOrderInfo.class);
        int pageNum = (int)jsonObject.get("pageNum");
        int pageSize = (int)jsonObject.get("pageSize");
        offLineOrder.setUserid((String)request.getAttribute(ApiInterceptor.LOGIN_USER_KEY));
        return new ResultModel(200,"ok",orderService.findPage(pageNum,pageSize,offLineOrder));
    }

    /** 查询出所有已付款线下订单，获取栏目下的课程，查询出没有关联信息的课程
     * 代申请课程
     * @return
     */
    @RequestMapping("notApplyClass")
    private ResultModel  notApplyClass(@RequestBody String jsonParam){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        BaseOrderInfo offLineOrder = JSONObject.parseObject(jsonObject.get("OrderInfo").toString(),BaseOrderInfo.class);
        int pageNum = (int)jsonObject.get("pageNum");
        int pageSize = (int)jsonObject.get("pageSize");
        int queryTag = (int)jsonObject.get("queryTag");
        offLineOrder.setUserid((String)request.getAttribute(ApiInterceptor.LOGIN_USER_KEY));
        offLineOrder.setStatus(1);
        return new ResultModel(200,"ok",orderService.notApplyClass(pageNum,pageSize,offLineOrder,queryTag));
    }


    /** 查询出所有已付款线下订单，获取栏目下的课程，查询出没有关联信息的课程
     * 代申请课程
     * @return
     */
    @RequestMapping("getPayData")
    private ResultModel  getPayData(@RequestBody String jsonParam){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        String orderNo = (String)jsonObject.get("orderNo");
        Cache cacheInfo = CacheManager.getCacheInfo(orderNo);
        if(cacheInfo==null){
            return new ResultModel(201,"改订单缓存已过期");
        }
        return new ResultModel(200,"ok",cacheInfo);
    }



}

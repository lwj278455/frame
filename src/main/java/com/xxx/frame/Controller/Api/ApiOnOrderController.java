package com.xxx.frame.Controller.Api;

import com.alibaba.fastjson.JSONObject;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Entity.OffLineOrder;
import com.xxx.frame.Entity.OnLineOrder;
import com.xxx.frame.Interceptor.ApiInterceptor;
import com.xxx.frame.Service.OnLineOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("api/onlineOrder")
public class ApiOnOrderController {

    @Autowired
    private OnLineOderService onLineOderService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("creatOrder")//订单内容，选择的成员ID
    public ResultModel creatOrder(@RequestBody String jsonParam) throws UnknownHostException {
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        OnLineOrder offLineOrder = JSONObject.parseObject(jsonObject.get("OrderInfo").toString(),OnLineOrder.class);
        String userId = (String)request.getAttribute(ApiInterceptor.LOGIN_USER_KEY);//获取当前登录的用户信息
        offLineOrder.setUserid(userId);
        offLineOrder.setCreattime(new Date());//初始化创建时间
        offLineOrder.setStatus(0);//初始化订单状态为代付款
        offLineOrder.setOrderno(getOrderIdByTime());//生成订单号
        return onLineOderService.creatOrder(offLineOrder);
    }

    @RequestMapping("updateOrderStatus")//订单内容，选择的成员ID
    public ResultModel updateOrderStatus(@RequestBody String jsonParam){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        OnLineOrder offLineOrder = JSONObject.parseObject(jsonObject.get("OrderInfo").toString(),OnLineOrder.class);
        return onLineOderService.updateOrderStatus(offLineOrder);
    }


    @RequestMapping("queryOrder")
    public ResultModel queryOnOrder(@RequestBody String jsonParam){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        OnLineOrder offLineOrder = JSONObject.parseObject(jsonObject.get("OrderInfo").toString(),OnLineOrder.class);
        int pageNum = (int)jsonObject.get("pageNum");
        int pageSize = (int)jsonObject.get("pageSize");
        offLineOrder.setUserid((String)request.getAttribute(ApiInterceptor.LOGIN_USER_KEY));
        return new ResultModel(200,"ok",onLineOderService.findPage(pageNum,pageSize,offLineOrder));
    }


    /**
     * 生成订单号
     * @return
     */
    public static String getOrderIdByTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result= "" ;
        Random random = new Random();
        for(int i=0;i<3;i++){
            result+=random.nextInt(10);
        }
        return newDate+result;
    }


}


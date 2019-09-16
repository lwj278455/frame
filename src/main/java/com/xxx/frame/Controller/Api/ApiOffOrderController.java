package com.xxx.frame.Controller.Api;

import com.alibaba.fastjson.JSONObject;
import com.xxx.frame.Entity.ClassColumn;
import com.xxx.frame.Entity.Member;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Entity.OffLineOrder;
import com.xxx.frame.Entity.OnLineOrder;
import com.xxx.frame.Interceptor.ApiInterceptor;
import com.xxx.frame.Service.OffLineOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("api/offlineOrder")
public class ApiOffOrderController {

    @Autowired
    private OffLineOderService offLineOderService;
    @Autowired
    private HttpServletRequest request;

    /**
     * 创建订单
     * @param jsonParam
     * @return
     */
    @RequestMapping("creatOrder")//订单内容，选择的成员ID
    public ResultModel creatOrder(@RequestBody String jsonParam){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        OffLineOrder offLineOrder = JSONObject.parseObject(jsonObject.get("OrderInfo").toString(),OffLineOrder.class);
        String userId = (String)request.getAttribute(ApiInterceptor.LOGIN_USER_KEY);//获取当前登录的用户信息
        offLineOrder.setUserid(userId);
        List<Integer> idList = JSONObject.parseArray(jsonObject.get("ids").toString(), Integer.class);
        Integer[] ids = idList.toArray(new Integer[idList.size()]);
        offLineOrder.setCreattime(new Date());//初始化创建时间
        offLineOrder.setStatus(0);//初始化订单状态为代付款
        offLineOrder.setOrderno(getOrderIdByTime());//生成订单号
        return offLineOderService.creatOrder(offLineOrder,ids);
    }

    @RequestMapping("updateStutus")//更改订单支付状态
    public ResultModel updateStutus(@RequestBody String jsonParam){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        OffLineOrder offLineOrder = JSONObject.parseObject(jsonObject.get("OrderInfo").toString(),OffLineOrder.class);
        return offLineOderService.updateOrder(offLineOrder);
    }


    @RequestMapping("queryOrder")
    public ResultModel queryOnOrder(@RequestBody String jsonParam){
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        OnLineOrder offLineOrder = JSONObject.parseObject(jsonObject.get("OrderInfo").toString(),OnLineOrder.class);
        int pageNum = (int)jsonObject.get("pageNum");
        int pageSize = (int)jsonObject.get("pageSize");
        offLineOrder.setUserid((String)request.getAttribute(ApiInterceptor.LOGIN_USER_KEY));
        return new ResultModel(200,"ok",offLineOderService.findPage(pageNum,pageSize,offLineOrder));
    }



    /**
     * 判断用户是否可报名课程
     * @param jsonParam
     * @return
     */
    @RequestMapping("canNotApply")
    public ResultModel canNotApply(
            @RequestBody String jsonParam) {
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        OffLineOrder offLineOrder = JSONObject.parseObject(jsonObject.get("OrderInfo").toString(),OffLineOrder.class);
        String userId = (String)request.getAttribute(ApiInterceptor.LOGIN_USER_KEY);//获取当前登录的用户信息
        offLineOrder.setUserid(userId);
        offLineOrder.setStatus(1);
        List<OffLineOrder> re = offLineOderService.findByE(offLineOrder);
        if(re.size()==1){
            return new ResultModel(200, "已报名");
        }
        return new ResultModel(201, "可报名！");
    }

    /**
     * 付款成功回调接口
     * @param jsonParam
     * @return
     */
    @RequestMapping("paidOrder")
    public ResultModel paidOrder(
            @RequestBody String jsonParam) {
        JSONObject jsonObject = JSONObject.parseObject(jsonParam);
        OffLineOrder offLineOrder = JSONObject.parseObject(jsonObject.get("OrderInfo").toString(),OffLineOrder.class);
        return offLineOderService.paidOrder(offLineOrder);
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

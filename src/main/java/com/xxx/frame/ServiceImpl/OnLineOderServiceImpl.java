package com.xxx.frame.ServiceImpl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.thoughtworks.xstream.XStream;
import com.xxx.frame.Dao.*;
import com.xxx.frame.Entity.*;
import com.xxx.frame.Entity.Model.OrderResult;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Entity.Wechat.OrderInfo;
import com.xxx.frame.Entity.Wechat.OrderReturnInfo;
import com.xxx.frame.Entity.Wechat.SignInfo;
import com.xxx.frame.Interceptor.ApiInterceptor;
import com.xxx.frame.Service.OnLineOderService;
import com.xxx.frame.Util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 线上课程订单信息
 */
@Service
public class OnLineOderServiceImpl implements OnLineOderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OnLineOrderMapper onLineOrderMapper;
    @Autowired
    private ClassInfoMapper classInfoMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ClassInfoDescMapper classInfoDescMapper;

    @Override
    public PageResult findPage(int pageNum, int rows, BaseOrderInfo baseOrderInfo) {
        pageNum = --pageNum;
        List<OrderResult> orderResults = orderMapper.selectOnLineOrderByExample(baseOrderInfo);
        if(orderResults.size()==0){
            return new PageResult(orderResults.size(),null);
        }
        if(pageNum*rows+rows>orderResults.size()){
            return new PageResult(orderResults.size(),orderResults.subList(pageNum*rows,orderResults.size()));
        }
        List<OrderResult> orderResults1 = orderResults.subList(pageNum*rows , pageNum*rows+rows);
        return new PageResult(orderResults.size(),orderResults1);
    }

    @Override
    public OnLineOrder selectById(Integer id) {
        return onLineOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultModel creatOrder(OnLineOrder offLineOrder) {
        ClassInfo classColumn = classInfoMapper.selectByPrimaryKey(offLineOrder.getClassid());//查询订单内课程信息，
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(offLineOrder.getUserid());
        offLineOrder.setPayment(classColumn.getPrice());
        onLineOrderMapper.insert(offLineOrder);//将订单信息插入数据库
        //订单信息填充完成，填充统一下单入参信息
        OrderInfo order = new OrderInfo();
        //获取当前ip
        try {
            InetAddress address = InetAddress.getLocalHost();
            String hostAddress = address.getHostAddress();
            //订单号
            String orderCode=offLineOrder.getOrderno();
            //设置请求体
            order.setOpenid(userInfo.getId());
            order.setAppid(WECHATCONSTANT.WECHAT_APPID);
            order.setMch_id(WECHATCONSTANT.WECHAT_MACHID);
            order.setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
            order.setBody("XXX");
            order.setOut_trade_no(orderCode);
            order.setTotal_fee(offLineOrder.getPayment().multiply(new BigDecimal(100)).intValue());//装换价格单位为分
            order.setSpbill_create_ip(hostAddress);
            order.setNotify_url("https://www.rebirth901.com/api/payBack");

            order.setTrade_type("JSAPI");
            order.setSign_type("MD5");
            //生成签名
            String sign = Signature.getSign(order);
            order.setSign(sign);

            //发送请求
            String orderResult = HttpRequest.sendPost(WECHATCONSTANT.UNIFIEDORDER, order);
            //格式化请求返回数据
            XStream xStream = new XStream();
            xStream.alias("xml", OrderReturnInfo.class);
            OrderReturnInfo returnInfo = (OrderReturnInfo)xStream.fromXML(orderResult);
            if(!returnInfo.getReturn_code().equals("SUCCESS")){
                return new ResultModel(403,"统一下单接口调用异常");
            }

            //生成返回数据
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("orderReturnInfo",returnInfo);
            resultMap.put("orderInfo",offLineOrder);
            //生成jsApi入参sign
            Object o = wxSign(returnInfo.getPrepay_id());
            resultMap.put("sign",o);
            //放入缓存
            Cache c = new Cache();
            c.setKey(offLineOrder.getOrderno());//绑定订单编号
            c.setData(o);//放入sign
            c.setTimeOut(System.currentTimeMillis()+7200000);//两小时缓存
            CacheManager.putCache(c.getKey(),c);
            return new ResultModel(200,"线下订单创建成功！",resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel(403,"");
        }
    }

    public static Object wxSign(String repayId){
        try {
            SignInfo signInfo = new SignInfo();
            signInfo.setAppId(WECHATCONSTANT.WECHAT_APPID);
            long time = System.currentTimeMillis()/1000;
            signInfo.setTimeStamp(String.valueOf(time));
            signInfo.setNonceStr(RandomStringGenerator.getRandomStringByLength(32));
            signInfo.setRepay_id("prepay_id="+repayId);
            signInfo.setSignType("MD5");
            //生成签名
            String sign = SignUtil.generateSignature(signInfo);
            JSONObject json = new JSONObject();
            json.put("timeStamp", signInfo.getTimeStamp());
            json.put("nonceStr", signInfo.getNonceStr());
            json.put("package",  signInfo.getRepay_id());
            json.put("signType", signInfo.getSignType());
            json.put("paySign", sign);
            return json;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultModel updateOrderStatus(OnLineOrder offLineOrder) {
        if(offLineOrder.getStatus()==1){
            offLineOrder.setPaytime(new Date());
            OnLineOrder onLineOrder = onLineOrderMapper.selectByPrimaryKey(offLineOrder.getId());
            //绑定用户信息
            ClassInfoDesc classInfoDesc = new ClassInfoDesc();
            classInfoDesc.setId(onLineOrder.getClassid());
            classInfoDesc.setUserid((String) request.getAttribute(ApiInterceptor.LOGIN_USER_KEY));
            classInfoDescMapper.insert(classInfoDesc);
        }
        onLineOrderMapper.updateByPrimaryKeySelective(offLineOrder);//更新订单状态
        return new ResultModel(200,"ok");
    }

   /* @Override
    public ResultModel queryOnOrder(int pageNum, int rows, BaseOrderInfo baseOrderInfo) {
        PageHelper.startPage(pageNum,rows);
        Page<OrderResult> page = (Page<OrderResult>)orderMapper.selectOnLineOrderByExample(baseOrderInfo);
        return new ResultModel(200,"ok",page);
    }*/
}

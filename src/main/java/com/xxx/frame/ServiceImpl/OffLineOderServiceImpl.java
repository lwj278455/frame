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
import com.xxx.frame.Service.OffLineOderService;
import com.xxx.frame.Util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 线下课程订单查询
 */
@Service
public class
OffLineOderServiceImpl implements OffLineOderService {
    @Autowired
    private OffLineOrderMapper offLineOrderMapper;
    @Autowired
    private OffLineOrderDescMapper offLineOrderDescMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private ClassInfoMapper classInfoMapper;
    @Autowired
    private ClassInfoDescMapper classInfoDescMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private ClassColumnMapper classColumnMapper;

    /**
     * 订单信息，成员ID
     * @param offLineOrder
     * @param ids
     * @return
     */
    //线下订单生成，价格无优惠，需绑定客户信息，课程信息以及客户选择的人员信息
    @Override
    public ResultModel creatOrder(OffLineOrder offLineOrder, Integer[] ids) {
        ClassColumn classColumn = classColumnMapper.selectByPrimaryKey(offLineOrder.getClassid());//查询订单内线下课程信息，
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(offLineOrder.getUserid());
        offLineOrder.setPayment(classColumn.getColumnprice().multiply(new BigDecimal(ids.length)));//有几个成员，收几份钱
        offLineOrderMapper.insert(offLineOrder);//将订单信息插入数据库
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

            for (Integer i:ids) {//创建成员，线下课程，订单和当前登录用户的关联信息
                OffLineOrderDesc offLineOrderDesc = new OffLineOrderDesc();
                offLineOrderDesc.setClassinfoid(classColumn.getId());
                offLineOrderDesc.setMemberid(i);
                offLineOrderDesc.setUserid(offLineOrder.getUserid());
                offLineOrderDesc.setOrderid(offLineOrder.getId());
                offLineOrderDescMapper.insert(offLineOrderDesc);
            }
            //生成返回数据
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("orderInfo",offLineOrder);
            resultMap.put("orderReturnInfo",returnInfo);
            //生成jsApi入参sign
            Object o = wxSign(returnInfo.getPrepay_id());
            resultMap.put("sign",o);
            //放入缓存
            Cache c = new Cache();
            c.setKey(offLineOrder.getOrderno());//绑定订单ID
            c.setData(o);//放入sign
            c.setTimeOut(System.currentTimeMillis()+7200000);//两小时缓存
            CacheManager.putCache(c.getKey(),c);
            return new ResultModel(200,"线下订单创建成功！",resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel(403,"");
        }
    }

    @Override
    public PageResult findPage(int pageNum, int rows, BaseOrderInfo offLineOrder) {
        pageNum = --pageNum;
        List<OrderResult> orderResults = orderMapper.selectOffLineOrderByExample(offLineOrder);
        if(orderResults.size()==0){
            return new PageResult(orderResults.size(),null);
        }
        if(pageNum*rows+rows>orderResults.size()){
            return new PageResult(orderResults.size(),orderResults.subList(pageNum*rows,orderResults.size()));
        }
        List<OrderResult> orderResults1 = orderResults.subList(pageNum*rows,pageNum*rows+rows);
        return new PageResult(orderResults.size(),orderResults1);
    }

    @Override
    public List<Member> selectMembersByOrder(Integer orderId) {
        List<Integer> memberIds = offLineOrderDescMapper.selectMemberIdByOrder(orderId);//根据关联表查询关联的人员ID
        MemberExample m = new MemberExample();//创建查询条件
        MemberExample.Criteria criteria = m.createCriteria();
        if(memberIds!=null&&memberIds.size()>0){
            criteria.andIdIn(memberIds);
        }else{
            return null;
        }
        List<Member> members = memberMapper.selectByExample(m);//查询到当前订单内包含的成员信息
        return members;
    }

    @Override
    public List<OffLineOrder> findByE(OffLineOrder offLineOrder) {
        OffLineOrderExample offLineOrderExample = new OffLineOrderExample();
        OffLineOrderExample.Criteria criteria = offLineOrderExample.createCriteria();
        if(offLineOrder!=null){
            if(offLineOrder.getStatus()!=null)criteria.andStatusEqualTo(offLineOrder.getStatus());
            if(offLineOrder.getUserid()!=null)criteria.andUseridEqualTo(offLineOrder.getUserid());
            if(offLineOrder.getClassid()!=null)criteria.andClassidEqualTo(offLineOrder.getClassid());
        }
        return offLineOrderMapper.selectByExample(offLineOrderExample);
    }

    /**
     * 付款成功回调接口
     * @param offLineOrder
     * @return
     */
    @Override
    public ResultModel paidOrder(OffLineOrder offLineOrder) {
        offLineOrder = offLineOrderMapper.selectByPrimaryKey(offLineOrder.getId());
        offLineOrder.setStatus(1);//设置付款成功
        offLineOrderMapper.updateByPrimaryKeySelective(offLineOrder);
        ClassInfoDesc classInfoDesc = new ClassInfoDesc();
        classInfoDesc.setId(offLineOrder.getClassid());
        classInfoDesc.setUserid(offLineOrder.getUserid());
        classInfoDescMapper.insert(classInfoDesc);
        return new ResultModel(200,"ok");
    }

    @Override
    public ResultModel updateOrder(OffLineOrder offLineOrder) {
        try{
            if(offLineOrder.getStatus()==1){
                offLineOrder.setPaytime(new Date());
            }
            offLineOrderMapper.updateByPrimaryKeySelective(offLineOrder);
        }catch (Exception e){
            return new ResultModel(500,"修改失败！");
        }
        return new ResultModel(200,"OK");
    }


    public Object wxSign(String repayId){
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
            json.put("package", signInfo.getRepay_id());
            json.put("signType", signInfo.getSignType());
            json.put("paySign", sign);
            return json;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}

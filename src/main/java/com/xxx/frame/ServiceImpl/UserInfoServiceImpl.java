package com.xxx.frame.ServiceImpl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.thoughtworks.xstream.XStream;
import com.xxx.frame.Controller.Api.ApiOnOrderController;
import com.xxx.frame.Dao.*;
import com.xxx.frame.Entity.*;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Entity.Wechat.OrderInfo;
import com.xxx.frame.Entity.Wechat.OrderReturnInfo;
import com.xxx.frame.Service.UserInfoService;
import com.xxx.frame.Util.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.*;

/**
 * 用户信息
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private AdminDescMapper adminDescMapper;
    @Autowired
    private AdminUserMapper adminMapper;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private TokenMapper tokenMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private CompanyProfileMapper companyProfileMapper;



    @Override
    public Map<String,Object> findPage(UserInfo userInfo) {
        Map<String,Object> result = new HashMap<>();
        AdminUser adminUser = (AdminUser) request.getSession().getAttribute("user");
        List<AdminUser> adminUsers = new ArrayList<>();
        if("2".equals(adminUser.getAdminlevel())){//如果业务员查询只查询与其关联用户
            adminUsers.addAll(adminMapper.selectAdminUserInfo(adminUser.getId()));//查询出所有的分享商和分享商所邀请的用户
        }else{
             adminUsers.addAll(adminMapper.selectAdminUserInfo(null));//查询出所有的分享商和分享商所邀请的用户
        }
        result.put("adminUsers",adminUsers);
        //查询所有没有关联信息的用户信息
        result.put("otherUser",userInfoMapper.selectUserByDesc());
      if(!userInfo.equals(new UserInfo())){
          UserInfoExample userInfoExample = new UserInfoExample();
          UserInfoExample.Criteria criteria1 = userInfoExample.createCriteria();
          if(!StringUtils.isEmpty(userInfo.getPhone())){
                criteria1.andPhoneEqualTo(userInfo.getPhone());
            }
            if(!StringUtils.isEmpty(userInfo.getRealname())){
                criteria1.andRealnameEqualTo(userInfo.getRealname());
            }
            if(!StringUtils.isEmpty(userInfo.getNickname())){
                criteria1.andNicknameEqualTo(userInfo.getNickname());
            }
            if(!StringUtils.isEmpty(userInfo.getUserLevel())){
                criteria1.andUserLevelEqualTo(userInfo.getUserLevel());
            }
          List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
          result.put("seachUser",userInfos);
        }
        return  result;
    }

    @Override
    public ResultModel registerUser(UserInfo userInfo,Integer adminId) {//adminId不为空关联业务员信息
        UserInfoExample userInfoExampl = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExampl.createCriteria();
       criteria.andPhoneEqualTo(userInfo.getPhone());
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExampl);
        if(userInfos.size()>0){
            return new ResultModel(201,"改手机号码以被注册！");
        }
        userInfoMapper.insert(userInfo);
        //初始创建一个成员信息
        Member member = new Member();
        member.setUserId(userInfo.getId());
        member.setIsself(1);
        member.setMemebername(userInfo.getNickname());
        member.setMobile(userInfo.getPhone());
        memberMapper.insert(member);
        //关联业务员ID
        if(adminId!=null&&adminId!=0){
            AdminDesc adminDesc = new AdminDesc();
            adminDesc.setAdminuserid(adminId);
            adminDesc.setUserid(userInfo.getId());
            adminDescMapper.insert(adminDesc);
        }
        return new ResultModel(200,"OK");
    }

    @Override
    public ResultModel userLogin(UserInfo userInfo) throws UnsupportedEncodingException {
        if(userInfo.getNickname()!=null){
            //编码
            final BASE64Encoder encoder = new BASE64Encoder();
            final String encodedText = encoder.encode(userInfo.getNickname().getBytes("UTF-8"));
            userInfo.setNickname(encodedText);
        }
        UserInfo userInfo1 = userInfoMapper.selectByPrimaryKey(userInfo.getId());
        if(userInfo1==null){
            userInfo.setUserLevel("0");
            userInfoMapper.insert(userInfo);
        }else{
            if(userInfo1.getUserLevel()==null){
                userInfo.setUserLevel("0");
            }
            userInfoMapper.updateByPrimaryKeySelective(userInfo);
        }
        //生成Token信息，存入数据库中
        Token token = new Token();
        token.setUserid(userInfo.getId());
        token.setToken(TokenUtil.makeToken());
        token.setExpireTime(new Date(System.currentTimeMillis()+2160000000l));//过期时间为25天
        token.setUpdateTime(new Date());
        //如果用户存在token就执行update
        TokenExample tokenExample = new TokenExample();
        TokenExample.Criteria criteria1 = tokenExample.createCriteria();
       criteria1.andUseridEqualTo(userInfo.getId());
        List<Token> tokens = tokenMapper.selectByExample(tokenExample);
        if(tokens.size()>0){
            token.setId(tokens.get(0).getId());
            tokenMapper.updateByPrimaryKeySelective(token);
        }else{
            tokenMapper.insert(token);
        }
        //放入缓存中
        Cache c = new Cache();
        c.setKey(token.getToken());
        c.setTimeOut(System.currentTimeMillis()+2160000000l);//过期时间为25天
        c.setExpired(false);
        c.setData(token);
        CacheManager.putCache(token.getToken(),c);
        return new ResultModel(200,token.getToken(),userInfo);
    }

    @Override
    public ResultModel updateUser(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
        if(userInfo.getRealname()!=null){
            //初始创建一个成员信息
            Member member = new Member();
            member.setUserId(userInfo.getId());
            member.setIsself(1);
            member.setMemebername(userInfo.getRealname());
            member.setMobile(userInfo.getPhone());
            memberMapper.insert(member);
        }
        return  new ResultModel(200,"ok");
    }

    @Override
    public ResultModel queryUserInfo(String attribute) throws IOException {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(attribute);
        if(userInfo.getNickname()!=null){
            final BASE64Decoder decoder = new BASE64Decoder();
            userInfo.setNickname(new String(decoder.decodeBuffer(userInfo.getNickname()),"utf-8"));
        }
        return new ResultModel(200,"ok",userInfo);
    }

    @Override
    public List<CompanyProfile> selectCompanyProfile() {
        return companyProfileMapper.selectByExample(null);
    }

    /**
     * 关联用户信息
     * @param userInfo
     * @param substring
     */
    @Override
    public void insertUserInfoByAdminId(UserInfo userInfo, String substring) {
        UserInfo userInfo1 = userInfoMapper.selectByPrimaryKey(userInfo.getId());
        if(userInfo1==null){//如果不存在改用户信息
            userInfoMapper.insert(userInfo);
            AdminUser adminUser = adminMapper.selectByPrimaryKey(Integer.parseInt(substring));
            if(adminUser!=null){//如果存在改业务员
                AdminDesc adminDesc = new AdminDesc();
                adminDesc.setAdminuserid(adminUser.getId());
                adminDesc.setUserid(userInfo.getId());
                adminDescMapper.insert(adminDesc);
            }
        }
    }

    @Override
    public ResultModel VIPPay(String attribute) {
        //订单信息填充完成，填充统一下单入参信息
        OrderInfo order = new OrderInfo();
        //获取当前ip
        try {
            InetAddress address = InetAddress.getLocalHost();
            String hostAddress = address.getHostAddress();
            //订单号
            String orderCode= ApiOnOrderController.getOrderIdByTime();
            //设置请求体
            order.setOpenid(attribute);
            order.setAppid(WECHATCONSTANT.WECHAT_APPID);
            order.setMch_id(WECHATCONSTANT.WECHAT_MACHID);
            order.setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
            order.setBody("XXX");
            order.setOut_trade_no(orderCode);
            //order.setTotal_fee(1);//装换价格单位为分
            order.setTotal_fee(16800);//装换价格单位为分
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
            //生成jsApi入参sign
            Object o = OnLineOderServiceImpl.wxSign(returnInfo.getPrepay_id());
            resultMap.put("sign",o);
            return new ResultModel(200,"线下订单创建成功！",resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel(403,"");
        }
    }






}

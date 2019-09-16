package com.xxx.frame.Controller.Api;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.xxx.frame.Annotation.Api;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Entity.UserInfo;
import com.xxx.frame.Entity.Wechat.*;
import com.xxx.frame.Service.UserInfoService;
import com.xxx.frame.Util.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

@RequestMapping("api")
@RestController
public class ApiController {

    private static final Logger logger = new LoggerContext().getLogger(ApiController.class);

    private static final String userid = "10264";//企业id
    private static final String userName = "rbfxueyuan";//账号
    private static final String passWord = "rbfxueyuan";//密码

    @Autowired
    private UserInfoService userInfoService;

    @Api
    @RequestMapping("/wx")
    public void  customerService(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String result = "";
        ServletInputStream in = request.getInputStream();
        //inputStream.
        XStream xs = SerializeXmlUtil.createXstream();
        xs.processAnnotations(InputMessage.class);
        xs.processAnnotations(OutputMessage.class);
        // 将指定节点下的xml节点数据映射为对象
        xs.alias("xml", InputMessage.class);
        // 将流转换为字符串
        StringBuilder xmlMsg = new StringBuilder();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1;) {
            xmlMsg.append(new String(b, 0, n, "UTF-8"));
        }
        // 将xml内容转换为InputMessage对象
        InputMessage inputMsg = (InputMessage) xs.fromXML(xmlMsg.toString());
        String servername = inputMsg.getToUserName();// 服务端
        String custermname = inputMsg.getFromUserName();// 客户端
        long createTime = inputMsg.getCreateTime();// 接收时间
        Long returnTime = Calendar.getInstance().getTimeInMillis() / 1000;// 返回时间
        //事件类型          输出post流中的XML数据
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*XML-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println(xmlMsg.toString());
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*XML-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        // 取得消息类型
        String msgType = inputMsg.getMsgType();
        switch (msgType){
            case "event":
                    // 文本消息 输出消息模板数据
                    System.out.println("开发者微信号：" + inputMsg.getToUserName());
                    System.out.println("发送方帐号：" + inputMsg.getFromUserName());
                    System.out.println("消息创建时间：" + inputMsg.getCreateTime() + new Date(createTime * 1000l));
                    System.out.println("消息内容：" + inputMsg.getContent());
                    System.out.println("消息Id：" + inputMsg.getMsgId());
                if("subscribe".equals(inputMsg.getEvent())){//关注了公众号，关联用户信息和adminID
                    //创建消息模板
                    StringBuffer str = new StringBuffer();
                    str.append("<xml>");
                    str.append("<ToUserName><![CDATA[" + custermname + "]]></ToUserName>");
                    str.append("<FromUserName><![CDATA[" + servername + "]]></FromUserName>");
                    str.append("<CreateTime>" + returnTime + "</CreateTime>");
                    str.append("<MsgType><![CDATA[" + "text" + "]]></MsgType>");
                    String substring = inputMsg.getEventKey().substring(inputMsg.getEventKey().indexOf('_')+1);
                    if(!"".equals(substring)){//存在业务员ID
                        UserInfo userInfo = new UserInfo();
                        userInfo.setId(custermname);//绑定openID
                        userInfoService.insertUserInfoByAdminId(userInfo,substring);
                        str.append("<Content><![CDATA[通过ID为"+substring+"的业务员邀请，关注了睿铂弗商学院！]]></Content>");
                    }else{
                        str.append("<Content><![CDATA[欢迎关注睿铂弗商学院！]]></Content>");
                    }
                    str.append("</xml>");
                    System.out.println(str.toString());
                    result = str.toString();
                }
                break;
            default:
                break;
        }




        PrintWriter out = null;
        try {

            out = response.getWriter();
            if(!"".equals(result)){
                out.print(result);
            }
            out.flush();
            /*// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，否则接入失败
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                System.out.println(echostr);
                out.print(echostr);

                out.flush();   //这个地方必须画重点，消息推送配置Token令牌错误校验失败，搞了我很久，必须要刷新！！！！！！！
                //return echostr;
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            out = null;

        }
    }

    @Api
    @RequestMapping("/payBack")
    public void  payBack(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String result = "";
        ServletInputStream in = request.getInputStream();
        //inputStream.
        XStream xs = SerializeXmlUtil.createXstream();
        xs.processAnnotations(InputMessage.class);
        xs.processAnnotations(OutputMessage.class);
        // 将指定节点下的xml节点数据映射为对象
        xs.alias("xml", InputMessage.class);
        // 将流转换为字符串
        StringBuilder xmlMsg = new StringBuilder();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1;) {
            xmlMsg.append(new String(b, 0, n, "UTF-8"));
        }
        System.out.println(xmlMsg);
        // 将xml内容转换为InputMessage对象
        PayInfo payInfo = (PayInfo) xs.fromXML(xmlMsg.toString());
        result = "<xml>" +
        "  <return_code><![CDATA[SUCCESS]]></return_code>" +
                "  <return_msg><![CDATA[OK]]></return_msg>" +
                "</xml>";
        PrintWriter out = null;
        try {

            out = response.getWriter();
            if(!"".equals(result)){
                out.print(result);
            }
            out.flush();
            /*// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，否则接入失败
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                System.out.println(echostr);
                out.print(echostr);

                out.flush();   //这个地方必须画重点，消息推送配置Token令牌错误校验失败，搞了我很久，必须要刷新！！！！！！！
                //return echostr;
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            out = null;

        }
    }

    @Api
    @RequestMapping("acctoken")
    public ResultModel acctoken(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        AccTokenMode accToken = WeChatUtil.getAccToken();
        ConstantManger.accToken = accToken.getAccess_token();
        return new ResultModel(200,"123",accToken);
    }

    @Api
    @RequestMapping("getTicket")
    public ResultModel getTicket(@RequestBody String jsonParam ) throws Exception {
        String  acc = (String)JSONObject.parseObject(jsonParam).get("acc");
        if(acc==null){
            return new ResultModel(500,"ul不能为null");
        }

        //TicketMode ticket = WeChatUtil.getTicket("123");
        return new ResultModel(200,"123");
    }




    @Api
    @RequestMapping("code")
    public ResultModel code(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String code = request.getParameter("code");
        logger.info(code);
        return new ResultModel(200,"123",code);
    }



    @Api
    @RequestMapping("encodeUrl")
    public ResultModel encodeUrl(@RequestBody String jsonParam ) {
        String  url = (String)JSONObject.parseObject(jsonParam).get("url");
        if(url==null){
            return new ResultModel(500,"url不能为null");
        }
        try {
            url = java.net.URLEncoder.encode(url,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new ResultModel(200,"ok",url);
    }



































    /**
     * 模拟客户端请求API接口
     * @param request
     * @return
     */
    @Api
    @RequestMapping("send")
    public String send(HttpServletRequest request){
        Map<String,String> param = new HashMap<>();
        param.put("userId","9527");
        param.put("amount","9.99");
        param.put("productId","9885544154");
        param.put("secretKey","mysecret123456");
        try {
            String postResult = HttpClientUtils.doPost("http://localhost:8011/api/checkSign", SignUtil.sign(param));
            return postResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    /**
     * 模拟服务的API接口
     * @param request
     * @return
     */
    @Api
    @RequestMapping("checkSign")
    public String checkSign(HttpServletRequest request){
        //从request中获取参数列表，转成map
        Map<String, String> map = SignUtil.toVerifyMap(request.getParameterMap(),false);
        String secretKey =  map.get("secretKey");
        if (StringUtils.isEmpty(secretKey) || !map.get("secretKey").equals(SignUtil.SECRET_KEY)){
            System.out.println("secretKey is err");
            return "fail";
        }
        if (SignUtil.verify(map)){
            return "success";
        }else {
            return "fail";
        }
    }

}

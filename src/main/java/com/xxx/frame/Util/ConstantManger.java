package com.xxx.frame.Util;

import com.xxx.frame.Dao.ClassTypeMapper;
import com.xxx.frame.Entity.ClassType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConstantManger {
    @Autowired
    private static ClassTypeMapper classTypeMapper;

    private ConstantManger(){};
    private static  ConstantManger constantManger;//单例
    public static ConstantManger getConstantManger(){
        if(constantManger==null){//如果为空创建新的对象
            constantManger = new ConstantManger();
        }
        return constantManger;
    }

    public static List<ClassType> classTypeList = null;                         //课程文件类型.
    public static String accToken = "21_0CCWI9oDu3LignaE96B1d6R0gdSLaSLGpnl03a-JpaQoqudNWkZUiDavbKN8_j9CWWNJkl-24o3249nZdw4WtpmjrIl7ZV1s1QMtB1SNFAr3ypjN-R0kY5QWM_QpG0P5gE3JisYaam91ZIKGJSXcAIAENS";
    public static final  String [] LINETYPE = {"线上","线下"};                                   //线上/线下
    public static final  String [] PAYTYPE = {"免费课程","会员免费","收费课程"};                 //收费类型
    public static final String [] ORDERSTATUS = {"代付款","已付款","交易关闭"};                  //订单状态
    public static final String [] NOTROOTURL = {"/Manager/skin-config.html","/Manager/dashboard","/Manager/getQrcode","/Manager/ListUser","/Manager/newQrCode","/Manager/onLineOrderManage","/Manager/offLineOrderManage","/Manager/loginOut"};               //非ROOT用户可访问的路径
    public static final String [] USERKEVEL = {"普通会员","付费会员"};                           //用户等级


}

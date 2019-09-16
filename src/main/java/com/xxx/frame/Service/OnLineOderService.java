package com.xxx.frame.Service;

import com.xxx.frame.Entity.BaseOrderInfo;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Entity.OffLineOrder;
import com.xxx.frame.Entity.OnLineOrder;

import java.net.UnknownHostException;

/**
 * 线上课程订单信息
 */
public interface OnLineOderService {
    PageResult findPage(int pageCurrent, int pageSize, BaseOrderInfo order);

    OnLineOrder selectById(Integer id);

    ResultModel creatOrder(OnLineOrder offLineOrder) throws UnknownHostException;

    ResultModel updateOrderStatus(OnLineOrder offLineOrder);

    //ResultModel queryOnOrder(int pageNum, int rows, BaseOrderInfo baseOrderInfo) ;
}

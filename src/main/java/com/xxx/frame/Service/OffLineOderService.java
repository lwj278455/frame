package com.xxx.frame.Service;

import com.xxx.frame.Entity.BaseOrderInfo;
import com.xxx.frame.Entity.ClassInfo;
import com.xxx.frame.Entity.Member;
import com.xxx.frame.Entity.Model.OrderResult;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Entity.OffLineOrder;

import java.util.List;

/**
 * 线下课程订单查询
 */
public interface OffLineOderService {
    ResultModel creatOrder(OffLineOrder offLineOrder, Integer[] ids);

    PageResult findPage(int pageCurrent, int pageSize, BaseOrderInfo offLineOrder);

    List<Member> selectMembersByOrder(Integer orderId);

    List<OffLineOrder> findByE(OffLineOrder offLineOrder);

    ResultModel paidOrder(OffLineOrder offLineOrder);

    ResultModel updateOrder(OffLineOrder offLineOrder);
}

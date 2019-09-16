package com.xxx.frame.Dao;

import com.xxx.frame.Entity.BaseOrderInfo;
import com.xxx.frame.Entity.Model.OrderResult;
import com.xxx.frame.Entity.OffLineOrder;
import com.xxx.frame.Entity.OnLineOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    List<OrderResult> selectOffLineOrderByExample(@Param("baseOrderInfo") BaseOrderInfo offLineOrder);

    List<OrderResult> selectOnLineOrderByExample(@Param("baseOrderInfo")BaseOrderInfo baseOrderInfo);

}

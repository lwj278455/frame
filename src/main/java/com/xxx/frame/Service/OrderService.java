package com.xxx.frame.Service;

import com.xxx.frame.Entity.BaseOrderInfo;
import com.xxx.frame.Entity.Model.PageResult;

import java.util.List;

public interface OrderService {
    PageResult findPage(int pageNum, int pageSize, BaseOrderInfo offLineOrder);

    PageResult notApplyClass(int pageNum, int pageSize, BaseOrderInfo offLineOrder,int queryTag);
}

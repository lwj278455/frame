package com.xxx.frame.ServiceImpl;

import com.xxx.frame.Dao.*;
import com.xxx.frame.Entity.*;
import com.xxx.frame.Entity.Model.OrderResult;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
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
    @Autowired
    private OffLineOrderMapper offLineOrderMapper;
    @Autowired
    private OffLineOrderDescMapper offLineOrderDescMapper;
    @Autowired
    private ClassColumnMapper classColumnMapper;

    /**
     * 查询所有订单
     * @param pageNum
     * @param pageSize
     * @param offLineOrder
     * @return
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize, BaseOrderInfo offLineOrder) {
        List<OrderResult> orderResults = orderMapper.selectOffLineOrderByExample(offLineOrder);//根据条件查询出所有的线下订单
        List<OrderResult> orderResults1 = orderMapper.selectOnLineOrderByExample(offLineOrder);//根据条件查询出所有的线上订单
        List<OrderResult> resut = new ArrayList<>();//搞到一个集合里面
        resut.addAll(orderResults);
        if(offLineOrder.getStatus()==null||offLineOrder.getStatus()!=1){
            resut.addAll(orderResults1);
        }
        Collections.sort(resut, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                OrderResult order1  = (OrderResult)o1;
                OrderResult order2  = (OrderResult)o2;
                int i = order2.getOrderinfo().getCreattime().compareTo(order1.getOrderinfo().getCreattime());
                if(i == 0){
                    return 0;
                }
                return i;
            }
            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        if(resut.size()==0){//分页
            return new PageResult(resut.size(),null);
        }
        if(pageNum*pageSize+pageSize>resut.size()){
            return new PageResult(resut.size(),resut.subList(pageNum*pageSize,resut.size()));
        }
        List<OrderResult> pageData = resut.subList(pageNum*pageSize,pageNum*pageSize+pageSize);
        return new PageResult(resut.size(),pageData);
    }



    @Override
    public PageResult notApplyClass(int pageNum, int pageSize, BaseOrderInfo offLineOrder,int queryTag) {//queryTag=1 查询所有待上课的订单    2查询所有一上课的订单
        List<OrderResult> orderResults = orderMapper.selectOffLineOrderByExample(offLineOrder);//根据条件查询出所有的线下订单
        for (OrderResult o:orderResults) {//查询出订单中的栏目下的所有课程
            ClassInfoExample classInfoExample = new ClassInfoExample();
            ClassInfoExample.Criteria criteria = classInfoExample.createCriteria();
            criteria.andColumnidEqualTo( o.getOrderinfo().getClassid());
            List<ClassInfo> classInfos1 = classInfoMapper.selectByExample(classInfoExample);
            o.getClassColumn().setClassList(classInfos1);
        }
        List<OrderResult> result = new ArrayList<>();
        for (OrderResult o:orderResults) {
            List<ClassInfo> classList = o.getClassColumn().getClassList();
            List<ClassInfo> tempList = new ArrayList<>();
            for (ClassInfo c:classList) {
                if(queryTag==1){//查询待上课课程是跳过所有已过课程时间
                    if(c.getAttendtime()==null||c.getAttendtime().before(new Date())){
                        continue;
                    }
                }
                if(queryTag==2){
                    if(c.getAttendtime()==null||c.getAttendtime().after(new Date())){
                        continue;
                    }
                }
                //查询所有有关联信息的课程
                ClassInfoDescExample classInfoDescExample = new ClassInfoDescExample();
                ClassInfoDescExample.Criteria criteria = classInfoDescExample.createCriteria();
                criteria.andIdEqualTo(c.getId());
                criteria.andUseridEqualTo(o.getOrderinfo().getUserid());
                List<ClassInfoDesc> classInfoDescs = classInfoDescMapper.selectByExample(classInfoDescExample);
                if(classInfoDescs.size()>0){
                    tempList.add(c);
                }
            }
            if(tempList.size()>0){
                o.getClassColumn().setClassList(tempList);
                result.add(o);
            }
        }

        Collections.sort(result, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                OrderResult order1  = (OrderResult)o1;
                OrderResult order2  = (OrderResult)o2;
                int i = order2.getOrderinfo().getPaytime().compareTo(order1.getOrderinfo().getPaytime());
                if(i == 0){
                    return 0;
                }
                return i;
            }
            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        if(result.size()==0){//分页
            return new PageResult(result.size(),null);
        }
        if(pageNum*pageSize+pageSize>result.size()){
            return new PageResult(result.size(),result.subList(pageNum*pageSize,result.size()));
        }
        List<OrderResult> pageData = result.subList(pageNum*pageSize,pageNum*pageSize+pageSize);
        return new PageResult(result.size(),pageData);
    }















}

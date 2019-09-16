package com.xxx.frame.Dao;

import com.xxx.frame.Entity.OnLineOrder;
import com.xxx.frame.Entity.OnLineOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OnLineOrderMapper {
    long countByExample(OnLineOrderExample example);

    int deleteByExample(OnLineOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OnLineOrder record);

    int insertSelective(OnLineOrder record);

    List<OnLineOrder> selectByExample(OnLineOrderExample example);

    OnLineOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OnLineOrder record, @Param("example") OnLineOrderExample example);

    int updateByExample(@Param("record") OnLineOrder record, @Param("example") OnLineOrderExample example);

    int updateByPrimaryKeySelective(OnLineOrder record);

    int updateByPrimaryKey(OnLineOrder record);
}
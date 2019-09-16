package com.xxx.frame.Dao;

import com.xxx.frame.Entity.OffLineOrder;
import com.xxx.frame.Entity.OffLineOrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

public interface OffLineOrderMapper {
    long countByExample(OffLineOrderExample example);

    int deleteByExample(OffLineOrderExample example);

    int deleteByPrimaryKey(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(OffLineOrder record);

    int insertSelective(OffLineOrder record);

    List<OffLineOrder> selectByExample(OffLineOrderExample example);

    OffLineOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OffLineOrder record, @Param("example") OffLineOrderExample example);

    int updateByExample(@Param("record") OffLineOrder record, @Param("example") OffLineOrderExample example);

    int updateByPrimaryKeySelective(OffLineOrder record);

    int updateByPrimaryKey(OffLineOrder record);
}
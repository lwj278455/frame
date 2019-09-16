package com.xxx.frame.Dao;

import com.xxx.frame.Entity.OffLineOrderDesc;
import com.xxx.frame.Entity.OffLineOrderDescExample;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

public interface OffLineOrderDescMapper {
    long countByExample(OffLineOrderDescExample example);

    int deleteByExample(OffLineOrderDescExample example);

    int deleteByPrimaryKey(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(OffLineOrderDesc record);

    int insertSelective(OffLineOrderDesc record);

    List<OffLineOrderDesc> selectByExample(OffLineOrderDescExample example);

    OffLineOrderDesc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OffLineOrderDesc record, @Param("example") OffLineOrderDescExample example);

    int updateByExample(@Param("record") OffLineOrderDesc record, @Param("example") OffLineOrderDescExample example);

    int updateByPrimaryKeySelective(OffLineOrderDesc record);

    int updateByPrimaryKey(OffLineOrderDesc record);

    List<Integer> selectMemberIdByOrder(Integer orderId);
}
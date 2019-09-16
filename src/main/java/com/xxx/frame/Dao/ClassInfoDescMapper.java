package com.xxx.frame.Dao;

import com.xxx.frame.Entity.ClassInfoDesc;
import com.xxx.frame.Entity.ClassInfoDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassInfoDescMapper {
    long countByExample(ClassInfoDescExample example);

    int deleteByExample(ClassInfoDescExample example);

    int insert(ClassInfoDesc record);

    int insertSelective(ClassInfoDesc record);

    List<ClassInfoDesc> selectByExample(ClassInfoDescExample example);

    int updateByExampleSelective(@Param("record") ClassInfoDesc record, @Param("example") ClassInfoDescExample example);

    int updateByExample(@Param("record") ClassInfoDesc record, @Param("example") ClassInfoDescExample example);
}
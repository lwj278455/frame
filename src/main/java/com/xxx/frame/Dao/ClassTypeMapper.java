package com.xxx.frame.Dao;

import com.xxx.frame.Entity.ClassType;
import com.xxx.frame.Entity.ClassTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassTypeMapper {
    long countByExample(ClassTypeExample example);

    int deleteByExample(ClassTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassType record);

    int insertSelective(ClassType record);

    List<ClassType> selectByExample(ClassTypeExample example);

    ClassType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassType record, @Param("example") ClassTypeExample example);

    int updateByExample(@Param("record") ClassType record, @Param("example") ClassTypeExample example);

    int updateByPrimaryKeySelective(ClassType record);

    int updateByPrimaryKey(ClassType record);

    List<ClassType> selectAllType();
}
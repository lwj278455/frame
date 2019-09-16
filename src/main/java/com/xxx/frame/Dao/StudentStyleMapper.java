package com.xxx.frame.Dao;

import com.xxx.frame.Entity.StudentStyle;
import com.xxx.frame.Entity.StudentStyleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentStyleMapper {
    long countByExample(StudentStyleExample example);

    int deleteByExample(StudentStyleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentStyle record);

    int insertSelective(StudentStyle record);

    List<StudentStyle> selectByExample(StudentStyleExample example);

    StudentStyle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentStyle record, @Param("example") StudentStyleExample example);

    int updateByExample(@Param("record") StudentStyle record, @Param("example") StudentStyleExample example);

    int updateByPrimaryKeySelective(StudentStyle record);

    int updateByPrimaryKey(StudentStyle record);
}
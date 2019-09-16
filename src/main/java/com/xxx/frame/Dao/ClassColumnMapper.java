package com.xxx.frame.Dao;

import com.xxx.frame.Entity.ClassColumn;
import com.xxx.frame.Entity.ClassColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassColumnMapper {
    long countByExample(ClassColumnExample example);

    int deleteByExample(ClassColumnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassColumn record);

    int insertSelective(ClassColumn record);

    List<ClassColumn> selectByExample(ClassColumnExample example);

    ClassColumn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassColumn record, @Param("example") ClassColumnExample example);

    int updateByExample(@Param("record") ClassColumn record, @Param("example") ClassColumnExample example);

    int updateByPrimaryKeySelective(ClassColumn record);

    int updateByPrimaryKey(ClassColumn record);

    List<ClassColumn> selectByE(ClassColumn classColumn);
}
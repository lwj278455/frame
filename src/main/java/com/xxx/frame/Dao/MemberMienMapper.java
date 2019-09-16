package com.xxx.frame.Dao;

import com.xxx.frame.Entity.MemberMien;
import com.xxx.frame.Entity.MemberMienExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberMienMapper {
    long countByExample(MemberMienExample example);

    int deleteByExample(MemberMienExample example);

    int deleteByPrimaryKey(Integer mienid);

    int insert(MemberMien record);

    int insertSelective(MemberMien record);

    List<MemberMien> selectByExample(MemberMienExample example);

    MemberMien selectByPrimaryKey(Integer mienid);

    int updateByExampleSelective(@Param("record") MemberMien record, @Param("example") MemberMienExample example);

    int updateByExample(@Param("record") MemberMien record, @Param("example") MemberMienExample example);

    int updateByPrimaryKeySelective(MemberMien record);

    int updateByPrimaryKey(MemberMien record);
}
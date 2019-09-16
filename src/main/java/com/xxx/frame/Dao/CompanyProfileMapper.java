package com.xxx.frame.Dao;

import com.xxx.frame.Entity.CompanyProfile;
import com.xxx.frame.Entity.CompanyProfileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyProfileMapper {
    long countByExample(CompanyProfileExample example);

    int deleteByExample(CompanyProfileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CompanyProfile record);

    int insertSelective(CompanyProfile record);

    List<CompanyProfile> selectByExample(CompanyProfileExample example);

    CompanyProfile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyProfile record, @Param("example") CompanyProfileExample example);

    int updateByExample(@Param("record") CompanyProfile record, @Param("example") CompanyProfileExample example);

    int updateByPrimaryKeySelective(CompanyProfile record);

    int updateByPrimaryKey(CompanyProfile record);
}
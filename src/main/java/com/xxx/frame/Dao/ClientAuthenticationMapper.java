package com.xxx.frame.Dao;

import com.xxx.frame.Entity.ClientAuthentication;
import com.xxx.frame.Entity.ClientAuthenticationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClientAuthenticationMapper {
    long countByExample(ClientAuthenticationExample example);

    int deleteByExample(ClientAuthenticationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClientAuthentication record);

    int insertSelective(ClientAuthentication record);

    List<ClientAuthentication> selectByExample(ClientAuthenticationExample example);

    ClientAuthentication selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClientAuthentication record, @Param("example") ClientAuthenticationExample example);

    int updateByExample(@Param("record") ClientAuthentication record, @Param("example") ClientAuthenticationExample example);

    int updateByPrimaryKeySelective(ClientAuthentication record);

    int updateByPrimaryKey(ClientAuthentication record);
}
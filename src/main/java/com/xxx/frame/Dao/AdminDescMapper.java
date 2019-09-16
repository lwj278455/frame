package com.xxx.frame.Dao;

import com.xxx.frame.Entity.AdminDesc;
import com.xxx.frame.Entity.AdminDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminDescMapper {
    long countByExample(AdminDescExample example);

    int deleteByExample(AdminDescExample example);

    int insert(AdminDesc record);

    int insertSelective(AdminDesc record);

    List<AdminDesc> selectByExample(AdminDescExample example);

    int updateByExampleSelective(@Param("record") AdminDesc record, @Param("example") AdminDescExample example);

    int updateByExample(@Param("record") AdminDesc record, @Param("example") AdminDescExample example);

    List<String>  selectUserIdsByExample(AdminDescExample adminDescExample);
}
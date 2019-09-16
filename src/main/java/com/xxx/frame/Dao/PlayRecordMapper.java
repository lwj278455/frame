package com.xxx.frame.Dao;

import com.xxx.frame.Entity.Model.PlayRecordResult;
import com.xxx.frame.Entity.PlayRecord;
import com.xxx.frame.Entity.PlayRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlayRecordMapper {
    long countByExample(PlayRecordExample example);

    int deleteByExample(PlayRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PlayRecord record);

    int insertSelective(PlayRecord record);

    List<PlayRecord> selectByExample(PlayRecordExample example);

    PlayRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PlayRecord record, @Param("example") PlayRecordExample example);

    int updateByExample(@Param("record") PlayRecord record, @Param("example") PlayRecordExample example);

    int updateByPrimaryKeySelective(PlayRecord record);

    int updateByPrimaryKey(PlayRecord record);

    List<PlayRecordResult> selectResultByRecord(PlayRecord playRecord);


    List<PlayRecordResult> selectByUserId(@Param("userId") String userId);

}
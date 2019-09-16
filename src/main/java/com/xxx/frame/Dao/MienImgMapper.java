package com.xxx.frame.Dao;

import com.xxx.frame.Entity.MienImg;
import com.xxx.frame.Entity.MienImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MienImgMapper {
    long countByExample(MienImgExample example);

    int deleteByExample(MienImgExample example);

    int deleteByPrimaryKey(Integer mienid);

    int insert(MienImg record);

    int insertSelective(MienImg record);

    List<MienImg> selectByExample(MienImgExample example);

    MienImg selectByPrimaryKey(Integer mienid);

    int updateByExampleSelective(@Param("record") MienImg record, @Param("example") MienImgExample example);

    int updateByExample(@Param("record") MienImg record, @Param("example") MienImgExample example);

    int updateByPrimaryKeySelective(MienImg record);

    int updateByPrimaryKey(MienImg record);
}
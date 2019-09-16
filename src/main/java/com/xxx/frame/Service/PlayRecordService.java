package com.xxx.frame.Service;

import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.Model.PlayRecordResult;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Entity.PlayRecord;

import java.util.List;

public interface PlayRecordService {

    PageResult selectByE(PlayRecord playRecord, int pageNum, int pageSize);

    ResultModel addRecord(PlayRecord playRecord);

    List<PlayRecordResult> selectByUserId(String id);
}

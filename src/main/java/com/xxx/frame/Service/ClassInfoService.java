package com.xxx.frame.Service;

import com.xxx.frame.Entity.ClassInfo;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.Model.ResultModel;

import java.util.List;

/**
 * 课程信息查询
 */
public interface ClassInfoService {
    PageResult findPage(int pageNum, int rows,ClassInfo classInfo);

    ClassInfo selectById(Integer id);

    void insertClass(ClassInfo classInfo);

    void updateClassByPrimaryKey(ClassInfo classInfo);

    void delClass(Integer id);

    ResultModel checkUserClass(String userId, Integer id);

    ResultModel findClassList(int id, int pageNum, int pageSize);

    ResultModel applyClass(String userId, Integer id);
}

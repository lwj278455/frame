package com.xxx.frame.Service;

import com.xxx.frame.Entity.ClassColumn;
import com.xxx.frame.Entity.ClassInfo;
import com.xxx.frame.Entity.Model.PageResult;

import java.util.List;

public interface ColumnService {
    PageResult findPage(int pageCurrent, int pageSize, ClassColumn classColumn);

    ClassColumn selectById(Integer id);

    void insertClassColumn(ClassColumn classColumn);

    void updateClassColumn(ClassColumn classColumn);

    void delClassColumn(Integer id);

    List<ClassColumn> selectAll();

    ClassColumn findByID(ClassColumn classColumn);
}

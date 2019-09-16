package com.xxx.frame.ServiceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xxx.frame.Dao.ClassColumnMapper;
import com.xxx.frame.Entity.ClassColumn;
import com.xxx.frame.Entity.ClassColumnExample;
import com.xxx.frame.Entity.ClassInfo;
import com.xxx.frame.Entity.Model.OrderResult;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnServiceImpl implements ColumnService {
    @Autowired
    private ClassColumnMapper classColumnMapper;

    @Override
    public PageResult findPage(int pageCurrent, int pageSize, ClassColumn classColumn) {
        List<ClassColumn> classColumns = classColumnMapper.selectByE(classColumn);
        if(pageSize==-1){
            List<ClassColumn> classColumns1 = classColumnMapper.selectByE(classColumn);
            return new PageResult(classColumns1.size(),classColumns1);
        }
        if(classColumns.size()==0){//分页
            return new PageResult(classColumns.size(),null);
        }
        if(pageCurrent*pageSize+pageSize>classColumns.size()){
            return new PageResult(classColumns.size(),classColumns.subList(pageCurrent*pageSize,classColumns.size()));
        }
        List<ClassColumn> pageData = classColumns.subList(pageCurrent*pageSize,pageCurrent*pageSize+pageSize);
        return new PageResult(classColumns.size(),pageData);
    }

    @Override
    public ClassColumn selectById(Integer id) {
        return classColumnMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insertClassColumn(ClassColumn classColumn) {
        classColumnMapper.insert(classColumn);
    }

    @Override
    public void updateClassColumn(ClassColumn classColumn) {
        classColumnMapper.updateByPrimaryKeySelective(classColumn);
    }

    @Override
    public void delClassColumn(Integer id) {
        classColumnMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ClassColumn> selectAll() {
        return classColumnMapper.selectByExample(null);
    }

    @Override
    public ClassColumn findByID(ClassColumn classColumn) {
        List<ClassColumn> classColumns = classColumnMapper.selectByE(classColumn);
        if(classColumns.size()==0){
            return null;
        }
        return classColumns.get(0);
    }

}

package com.xxx.frame.ServiceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xxx.frame.Dao.ClassInfoDescMapper;
import com.xxx.frame.Dao.ClassInfoMapper;
import com.xxx.frame.Dao.UserInfoMapper;
import com.xxx.frame.Entity.*;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 课程信息查询
 */
@Service
public class ClassInfoServiceImpl implements ClassInfoService {
    @Autowired
    private ClassInfoMapper classInfoMapper;
    @Autowired
    private ClassInfoDescMapper classInfoDescMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 分页查询，不包含条件
     * @param pageNum
     * @param rows
     * @return
     */
    @Override
    public PageResult findPage(int pageNum, int rows,ClassInfo classInfo) {

        ClassInfoExample classInfoExample = new ClassInfoExample();
        ClassInfoExample.Criteria criteria = classInfoExample.createCriteria();
        if(classInfo!=null){
            if(classInfo.getClassname()!=null&&!"".equals(classInfo.getClassname())){
                criteria.andClassnameLike("%"+classInfo.getClassname()+"%");
            }
            if(classInfo.getPricetype()!=null&&!"".equals(classInfo.getPricetype())){
                criteria.andPricetypeEqualTo(classInfo.getPricetype());
            }
            if(classInfo.getClasstype()!=null&&!"".equals(classInfo.getClasstype())){
                criteria.andClasstypeEqualTo(classInfo.getClasstype());
            }
            if(classInfo.getLinetype()!=null&&!"".equals(classInfo.getLinetype())){
                criteria.andLinetypeEqualTo(classInfo.getLinetype());
            }
            if(classInfo.getColumnid()!=null){
                criteria.andColumnidEqualTo(classInfo.getColumnid());
            }
            if(classInfo.getMaxPrice()!=null){
                criteria.andPriceLessThanOrEqualTo(classInfo.getMaxPrice());
            }
            if(classInfo.getMinPrice()!=null){
                criteria.andPriceGreaterThanOrEqualTo(classInfo.getMinPrice());
            }
        }
        PageHelper.startPage(pageNum,rows);
        Page<ClassInfo> page = (Page<ClassInfo>)classInfoMapper.selectByExample(classInfoExample);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public ClassInfo selectById(Integer id) {
        return classInfoMapper.selectByPrimaryKey(id);
    }


    @Override
    public void insertClass(ClassInfo classInfo) {
        classInfoMapper.insert(classInfo);
    }

    @Override
    public void updateClassByPrimaryKey(ClassInfo classInfo) {
        classInfoMapper.updateByPrimaryKeySelective(classInfo);
    }

    @Override
    public void delClass(Integer id) {
        classInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ResultModel checkUserClass(String userId, Integer id) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        ClassInfo classInfo = classInfoMapper.selectByPrimaryKey(id);
        if(classInfo.getLinetype()==1&&(classInfo.getMembercount()<=0||new Date().after(classInfo.getApplydate()))){//如果是线下课程判断是否报名人数超标和是否过期
            return new ResultModel(202, "当前课程已过报名时间！");
        }
        if(classInfo.getLinetype()==0&&userInfo.getUserLevel().equals("1")&&classInfo.getPricetype()!=2){//如果用户是会员并且该课程不是会员收费课程返回true;
            return new ResultModel(200, "线下课程且当前用户是会员");
        }
        ClassInfoDescExample classInfoDescExample = new ClassInfoDescExample();
        ClassInfoDescExample.Criteria criteria = classInfoDescExample.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andUseridEqualTo(userId);
        List<ClassInfoDesc> classInfoDescs = classInfoDescMapper.selectByExample(classInfoDescExample);
        if(classInfoDescs!=null&&classInfoDescs.size()!=0){
            return new ResultModel(200, "已存在关联信息！");
        }
        return new ResultModel(201, "没有关联信息");
    }

    @Override
    public ResultModel findClassList(int id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ClassInfoExample classInfoExample = new ClassInfoExample();
        ClassInfoExample.Criteria criteria = classInfoExample.createCriteria();
        criteria.andColumnidEqualTo(id);
        Page<ClassInfo> page = (Page<ClassInfo>)classInfoMapper.selectByExample(classInfoExample);
        return new ResultModel(200,"ok",new PageResult(page.getTotal(),page.getResult()));
    }

    @Override
    public ResultModel applyClass(String userId, Integer id) {
        ClassInfoDesc classInfoDesc = new ClassInfoDesc();
        classInfoDesc.setId(id);
        classInfoDesc.setUserid(userId);
        classInfoDescMapper.insert(classInfoDesc);
        return new ResultModel(200,"ok");
    }


}

package com.xxx.frame.ServiceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xxx.frame.Dao.ClassInfoMapper;
import com.xxx.frame.Dao.PlayRecordMapper;
import com.xxx.frame.Entity.ClassInfo;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.Model.PlayRecordResult;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Entity.PlayRecord;
import com.xxx.frame.Entity.PlayRecordExample;
import com.xxx.frame.Service.PlayRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayRecordServiceImpl implements PlayRecordService {

    @Autowired
    private PlayRecordMapper playRecordMapper;
    @Autowired
    private ClassInfoMapper classInfoMapper;


    @Override
    public PageResult selectByE(PlayRecord playRecord, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<PlayRecordResult> page = (Page<PlayRecordResult>)playRecordMapper.selectResultByRecord(playRecord);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public ResultModel addRecord(PlayRecord playRecord) {
        PlayRecordExample playRecordExample = new PlayRecordExample();
        PlayRecordExample.Criteria criteria = playRecordExample.createCriteria();
        criteria.andClassidEqualTo(playRecord.getClassid());
        criteria.andUseridEqualTo(playRecord.getUserid());
        List<PlayRecord> playRecords = playRecordMapper.selectByExample(playRecordExample);
        if(playRecords.size()==1){//如果用户存在此课程的观看记录，修改观看时间
            PlayRecord playRecord1 = playRecords.get(0);
            playRecord1.setPlaydate(playRecord.getPlaydate());
            playRecordMapper.updateByPrimaryKeySelective(playRecord1);
        }else{//没有看过插入新的数据
            playRecordMapper.insert(playRecord);
        }
        //添加观看记录后观看次数加一
        ClassInfo classInfo = classInfoMapper.selectByPrimaryKey(playRecord.getClassid());
        classInfo.setPlaycount(classInfo.getPlaycount()+1);
        classInfoMapper.updateByPrimaryKeySelective(classInfo);
        return new ResultModel(200,"ok");
    }

    @Override
    public List<PlayRecordResult> selectByUserId(String id) {
       return playRecordMapper.selectByUserId(id);
    }


}

package com.xxx.frame.ServiceImpl;

import com.xxx.frame.Dao.StudentStyleMapper;
import com.xxx.frame.Service.StudentStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 学员风采
 */
@Service
public class StudentStyleServiceImpl implements StudentStyleService {
    @Autowired
    private StudentStyleMapper studentStyleMapper;

}

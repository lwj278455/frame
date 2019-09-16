package com.xxx.frame.ServiceImpl;

import com.xxx.frame.Dao.ClassTypeMapper;
import com.xxx.frame.Entity.ClassType;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Service.ClassTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassTypeServiceImpl implements ClassTypeService {
    @Autowired
    private ClassTypeMapper classTypeMapper;


}

package com.xxx.frame.Service;

import com.xxx.frame.Entity.AdminUser;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.Model.ResultModel;

import javax.xml.transform.Result;

public interface AdminUserService {
    PageResult selectByExample(AdminUser user);

    AdminUser login(AdminUser user);

    PageResult findPage(int pageCurrent, int pageSize, AdminUser adminUser);

    AdminUser findById(Integer id);

    ResultModel adminUserAddOrUpdate(AdminUser adminUser) throws Exception;

    void delAdminUser(Integer id);
}

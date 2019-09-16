package com.xxx.frame.ServiceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xxx.frame.Dao.AdminUserMapper;
import com.xxx.frame.Entity.AdminUser;
import com.xxx.frame.Entity.AdminUserExample;
import com.xxx.frame.Entity.ClassInfo;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Service.AdminUserService;
import com.xxx.frame.Util.UpLoadFileUtil;
import com.xxx.frame.Util.WeChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;


    @Override
    public PageResult selectByExample(AdminUser user) {
        return null;
    }

    @Override
    public AdminUser login(AdminUser user) {
        AdminUserExample adminUserExample = new AdminUserExample();
        AdminUserExample.Criteria criteria = adminUserExample.createCriteria();
        if(user!=null){
            if(user.getUsername()!=null&&!"".equals(user.getUsername())){
                criteria.andUsernameEqualTo(user.getUsername());
            }
            if(user.getPassword()!=null){
                criteria.andPasswordEqualTo(user.getPassword());
            }
        }
        List<AdminUser> adminUsers = adminUserMapper.selectByExample(adminUserExample);
        if(adminUsers.size()==0){
            return null;
        }
        return adminUsers.get(0);
    }

    @Override
    public PageResult findPage(int pageCurrent, int pageSize, AdminUser adminUser) {
        PageHelper.startPage(pageCurrent,pageSize);
        AdminUserExample adminUserExample = new AdminUserExample();
        AdminUserExample.Criteria criteria = adminUserExample.createCriteria();
        criteria.andAdminlevelEqualTo("2");//查询所有的业务员
        if(adminUser!=null){
            if(adminUser.getName()!=null&&!"".equals(adminUser.getName())){
                criteria.andNameEqualTo(adminUser.getName());
            }
            if(adminUser.getUsername()!=null&&!"".equals(adminUser.getUsername())){
                criteria.andUsernameEqualTo(adminUser.getUsername());
            }
        }
        Page<AdminUser> page = (Page<AdminUser>) adminUserMapper.selectByExample(adminUserExample);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public AdminUser findById(Integer id) {
        return adminUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultModel adminUserAddOrUpdate(AdminUser adminUser) throws Exception {
        if(adminUser.getId()!=null){
            adminUserMapper.updateByPrimaryKeySelective(adminUser);
        }else{
            AdminUserExample adminUserExample = new AdminUserExample();
            AdminUserExample.Criteria criteria = adminUserExample.createCriteria();
            criteria.andUsernameEqualTo(adminUser.getUsername());
            List<AdminUser> adminUsers = adminUserMapper.selectByExample(adminUserExample);
            if(adminUsers.size()>0){
                return new ResultModel(500,"该账号已被注册！");
            }
            adminUser.setAdminlevel("2");
            adminUser.setQrcodeurl("/serverdata/qrCode/"+adminUser.getUsername()+".jpg");
            adminUserMapper.insert(adminUser);
            WeChatUtil.getqrCode(adminUser.getId().toString(),adminUser.getUsername());
        }
        return new ResultModel(200,"OK！");
    }

    @Override
    public void delAdminUser(Integer id) {
        adminUserMapper.deleteByPrimaryKey(id);
    }
}

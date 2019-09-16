package com.xxx.frame.ServiceImpl;

import com.xxx.frame.Dao.MemberMapper;
import com.xxx.frame.Dao.UserInfoMapper;
import com.xxx.frame.Entity.Member;
import com.xxx.frame.Entity.MemberExample;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Entity.UserInfo;
import com.xxx.frame.Interceptor.ApiInterceptor;
import com.xxx.frame.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 成员信息查询
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public ResultModel findMembers(){
       String userId = (String)request.getAttribute(ApiInterceptor.LOGIN_USER_KEY);
        MemberExample memberExample = new MemberExample();
        MemberExample.Criteria criteria = memberExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return new ResultModel(200,"ok",memberMapper.selectByExample(memberExample));//查询登录用户的人员信息
    }
    @Override
    public ResultModel addMember(Member member){
        String userId= (String)request.getAttribute(ApiInterceptor.LOGIN_USER_KEY);
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        if(member.getMobile().equals(userInfo.getPhone())){
            member.setIsself(1);
        }
        member.setUserId(userId);
        memberMapper.insert(member);
        return new ResultModel(200,"ok");
    }

    @Override
    public ResultModel updateMember(Member member){
        memberMapper.updateByPrimaryKeySelective(member);
        return new ResultModel(200,"ok");
    }
    @Override
    public ResultModel delMember(Integer id){
        memberMapper.deleteByPrimaryKey(id);
        return new ResultModel(200,"ok");
    }

    @Override
    public ResultModel findById(Integer id) {
        return new ResultModel(200,"ok",memberMapper.selectByPrimaryKey(id));
    }

}

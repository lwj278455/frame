package com.xxx.frame.Service;

import com.xxx.frame.Dao.MemberMapper;
import com.xxx.frame.Entity.Member;
import com.xxx.frame.Entity.Model.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 成员信息查询
 */
public interface MemberService {

   ResultModel  findMembers();
   ResultModel  addMember(Member member);

   ResultModel updateMember(Member member);

   ResultModel delMember(Integer id);

    ResultModel findById(Integer id);
}

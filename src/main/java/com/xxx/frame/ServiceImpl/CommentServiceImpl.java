package com.xxx.frame.ServiceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xxx.frame.Dao.CommentMapper;
import com.xxx.frame.Entity.Comment;
import com.xxx.frame.Entity.Model.PageResult;
import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 评论信息查询
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public ResultModel addContent(Comment comment) {
        commentMapper.insert(comment);
        return new ResultModel(200,"ok");
    }


    @Override
    public ResultModel findPage(int pageNum, int pageSize, Comment comment) {//根据classID查询评论
        PageHelper.startPage(pageNum,pageSize);
        Page<Comment> page = (Page<Comment>)commentMapper.selectByE(comment);
        return new ResultModel(200,"ok",new PageResult(page.getTotal(),page.getResult()));
    }
}

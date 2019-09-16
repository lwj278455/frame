package com.xxx.frame.Service;

import com.xxx.frame.Entity.Comment;
import com.xxx.frame.Entity.Model.ResultModel;

/**
 * 评论信息查询
 */
public interface CommentService {
    ResultModel addContent(Comment comment);

    ResultModel findPage(int pageNum, int pageSize, Comment comment);
}

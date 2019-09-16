package com.xxx.frame.Service;

import com.xxx.frame.Entity.Content;

import java.util.List;

/**
 * 广告，轮播图信息
 */
public interface ContentService {
    List<Content> selectByE(Content content);
}

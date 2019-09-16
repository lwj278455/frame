package com.xxx.frame.ServiceImpl;

import com.xxx.frame.Dao.ContentMapper;
import com.xxx.frame.Entity.Content;
import com.xxx.frame.Entity.ContentExample;
import com.xxx.frame.Service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 广告，轮播图信息
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentMapper contentMapper;

    @Override
    public List<Content> selectByE(Content content) {
        ContentExample contentExample = new ContentExample();
        ContentExample.Criteria criteria = contentExample.createCriteria();
        if(content!=null){
            if(content.getCtype()!=null){
                criteria.andCtypeEqualTo(content.getCtype());
            }
        }
        return contentMapper.selectByExample(contentExample);
    }
}

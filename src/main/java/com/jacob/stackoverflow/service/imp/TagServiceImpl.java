package com.jacob.stackoverflow.service.imp;

import com.jacob.stackoverflow.domain.TagInfo;
import com.jacob.stackoverflow.domain.TagVisitInfo;
import com.jacob.stackoverflow.mapper.TagInfoMapper;
import com.jacob.stackoverflow.mapper.TagVisitInfoMapper;
import com.jacob.stackoverflow.service.ITagService;
import com.jacob.stackoverflow.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class TagServiceImpl implements ITagService {

    @Autowired
    private TagInfoMapper tagInfoMapper;
    @Autowired
    private TagVisitInfoMapper tagVisitInfoMapper;

    @Override
    public int insertToTagInfo() {
        TagInfo tagInfo = new TagInfo();
        tagInfo.setTagName("java2");                    // 测试数据
        tagInfo.setTagExcerpt("llllllllllllllllll");

        return  tagInfoMapper.insert(tagInfo);
    }

    @Override
    public int insertToTagInfoFromN2M(int n, int m) {

        List<List<TagVisitInfo>> list = HttpUtils.getInfo(n, m);
        for(List<TagVisitInfo> listTag : list){
            for (TagVisitInfo tag : listTag){
                if(tagInfoMapper.findByTagName(tag.getTagName()) == null){    // 当tagName不存在tag_info表中时才插入将tagInfo实体插入表中
                    tagInfoMapper.insert(new TagInfo(tag.getTagName(), tag.getTagExcerpt()));
                }
                tag.setInputTime(new Date());
                tag.setUpdateTime(new Date());
                tagVisitInfoMapper.insert(tag);
            }
        }
        return 0;
    }

    @Override
    public TagInfo findByNameFromTagInfo(String tagName) {
        return tagInfoMapper.findByTagName(tagName);
    }

    @Override
    public List<TagVisitInfo> getAllTags() {
        List<TagVisitInfo> tagVisitInfoList = tagVisitInfoMapper.getAll();
        List<TagInfo> tagInfoList = tagInfoMapper.getAll();

        for(TagVisitInfo tagVisitInfo : tagVisitInfoList){
            for(TagInfo tagInfo : tagInfoList){
                if(tagVisitInfo.getTagName().equals(tagInfo.getTagName())){
                    tagVisitInfo.setTagExcerpt(tagInfo.getTagExcerpt());
                }
            }
        }
        return tagVisitInfoList;
    }

    @Override
    public List<TagInfo> getTagInfos() {

        return tagInfoMapper.getAll();
    }

    @Override
    public List<TagVisitInfo> getTagVisitInfos() {
        return tagVisitInfoMapper.getAll();
    }
}

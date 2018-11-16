package com.jacob.stackoverflow.service;

import com.jacob.stackoverflow.domain.TagInfo;
import com.jacob.stackoverflow.domain.TagVisitInfo;

import java.util.List;

public interface ITagService {

    public int insertToTagInfo();
    public int insertToTagInfoFromN2M(int n, int m);
    public List<TagVisitInfo> getAllTags();
    public List<TagInfo> getTagInfos();
    public List<TagVisitInfo> getTagVisitInfos();
    public TagInfo findByNameFromTagInfo(String tagName);
}

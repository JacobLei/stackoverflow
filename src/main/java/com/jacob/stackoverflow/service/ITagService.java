package com.jacob.stackoverflow.service;

import com.jacob.stackoverflow.domain.TagInfo;

public interface ITagService {

    public int insertToTagInfo();
    public int insertToTagInfoFromN2M(int n, int m);
    public TagInfo selectTagInfoByTagName(String tagname);

    public TagInfo findByNameFromTagInfo(String tagName);
}

package com.jacob.stackoverflow.dao;


import com.jacob.stackoverflow.bean.TagInfo;
import com.jacob.stackoverflow.bean.TagVisitInfo;
import org.springframework.data.repository.CrudRepository;

public interface TagVisitInfoRepository
        extends CrudRepository<TagVisitInfo, Integer> {

    TagVisitInfo findByTagInfo(TagInfo  tagInfo);
}

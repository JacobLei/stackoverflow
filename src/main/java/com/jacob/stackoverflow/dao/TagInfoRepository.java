package com.jacob.stackoverflow.dao;

import com.jacob.stackoverflow.bean.TagInfo;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;


public interface TagInfoRepository extends CrudRepository<TagInfo, String> {
    boolean existsByTagName(String tagName);
}

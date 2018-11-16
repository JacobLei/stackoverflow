package com.jacob.stackoverflow.mapper;

import org.apache.ibatis.annotations.*;
import com.jacob.stackoverflow.domain.TagInfo;

import java.util.List;

/**
 * 访问tag_info表格接口
 */
public interface TagInfoMapper {


    /**
     * 将tagName和exceprt插入表tag_info中
     * @param tagInfo
     * @return
     */
    @Insert("INSERT INTO tag_info(tag_name, tag_excerpt) VALUES(#{tagName}, #{tagExcerpt})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(TagInfo tagInfo);


    /**
     * 在tag_info表中是查找tagName
     * * @param tagName　标签名
     * @return TagInfo实体
     */
    @Select("SELECT * FROM tag_info WHERE tag_name = #{name}")
    TagInfo findByTagName(String tagName);

    @Select(("SELECT * from tag_info"))
    @Results({
            @Result(column = "tag_name", property = "tagName"),
            @Result(column = "tag_excerpt", property = "tagExcerpt")
    })
    List<TagInfo> getAll();


}

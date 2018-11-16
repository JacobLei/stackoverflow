package com.jacob.stackoverflow.mapper;

import org.apache.ibatis.annotations.Insert;
import com.jacob.stackoverflow.domain.TagInfo;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * 访问数据库接口
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


}

package com.jacob.stackoverflow.mapper;

import com.jacob.stackoverflow.domain.TagInfo;
import com.jacob.stackoverflow.domain.TagVisitInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 访问tag_visit_info表格接口
 */
public interface TagVisitInfoMapper {
    @Insert("INSERT INTO " +
            "tag_visit_info(" +
            "tag_name, " +
            "asked_today, " +
            "asked_week, " +
            "input_time, " +
            "multiplier_counts, " +
            "spider_time, " +
            "update_time) " +
            "VALUES(" +
            "#{tagName}, " +
            "#{askedToday}," +
            "#{askedWeek}, " +
            "#{inputTime}," +
            "#{multiplierCounts}," +
            "#{spiderTime}," +
            "#{updateTime})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(TagVisitInfo tagVisitInfo);

    @Select(("SELECT * from tag_visit_info"))
    @Results({
            @Result(column = "tag_name", property = "tagName"),
            @Result(column = "asked_today", property = "askedToday"),
            @Result(column = "asked_week", property = "askedWeek"),
            @Result(column = "input_time", property = "inputTime"),
            @Result(column = "multiplier_counts", property = "multiplierCounts"),
            @Result(column = "spider_time", property = "spiderTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<TagVisitInfo> getAll();

}

package com.jacob.stackoverflow.mapper;

import com.jacob.stackoverflow.domain.TagInfo;
import com.jacob.stackoverflow.domain.TagVisitInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

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

}

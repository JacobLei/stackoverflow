package com.jacob.stackoverflow.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class TagVisitInfo {

    private Integer id;
    private String tagName;
//    private TagInfo tagInfo;
    private String tagExcerpt;

    private String multiplierCounts;
    private String askedToday;
    private String askedWeek;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputTime;     // 入库时间
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;    // 修改时间
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date spiderTime;    // 抓取时间

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagExcerpt() {
        return tagExcerpt;
    }

    public void setTagExcerpt(String tagExcerpt) {
        this.tagExcerpt = tagExcerpt;
    }

    public String getMultiplierCounts() {
        return multiplierCounts;
    }

    public void setMultiplierCounts(String multiplierCounts) {
        this.multiplierCounts = multiplierCounts;
    }

    public String getAskedToday() {
        return askedToday;
    }

    public void setAskedToday(String askedToday) {
        this.askedToday = askedToday;
    }

    public String getAskedWeek() {
        return askedWeek;
    }

    public void setAskedWeek(String askedWeek) {
        this.askedWeek = askedWeek;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getSpiderTime() {
        return spiderTime;
    }

    public void setSpiderTime(Date spiderTime) {
        this.spiderTime = spiderTime;
    }
}

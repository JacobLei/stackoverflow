package com.jacob.stackoverflow.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TagVisitInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_visit_id")
    private Integer Id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "tag_name")
    @JsonBackReference
    private TagInfo tagInfo;

    private String multiplierCounts;
    private String askedToday;
    private String askedWeek;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputTime;     // 入库时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;    // 修改时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date spiderTime;    // 抓取时间


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public TagInfo getTagInfo() {
        return tagInfo;
    }

    public void setTagInfo(TagInfo tagInfo) {
        this.tagInfo = tagInfo;
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

package com.jacob.stackoverflow.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Tag {
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String questionName;
    private String multiplierCounts;
    private String excerpt;
    private String askedToday;
    private String askedWeek;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputTime;     // 入库时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;    // 修改时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date spiderTime;    // 抓取时间



    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getMultiplierCounts() {
        return multiplierCounts;
    }

    public void setMultiplierCounts(String multiplierCounts) {
        this.multiplierCounts = multiplierCounts;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
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

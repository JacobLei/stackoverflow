package com.jacob.stackoverflow.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    @Override
    public String toString(){
        return "Tag{" +
                "name = '" + questionName + '\'' +
                ", multiplierCounts = '" + multiplierCounts + '\'' +
                ", excerpt = '" + excerpt + '\'' +
                ", askedToday = '" + askedToday + '\'' +
                ", askedWeek = '" + askedWeek + '\'' +
                "}";
    }
}

package com.jacob.stackoverflow.domain;


public class TagInfo {

    private int id;

    private String tagName;
    private String tagExcerpt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagExcerpt() {
        return tagExcerpt;
    }

    public void setTagExcerpt(String tagExcerpt) {
        this.tagExcerpt = tagExcerpt;
    }

}

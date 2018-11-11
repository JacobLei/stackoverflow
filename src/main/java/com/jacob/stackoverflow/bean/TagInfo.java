package com.jacob.stackoverflow.bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TagInfo {

    @Id
    @Column(name = "tag_name")
    private String tagName;
    private String excerpt;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "tagInfo")
    private Set<TagVisitInfo> visitInfos = new HashSet<TagVisitInfo>();

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public Set<TagVisitInfo> getVisitInfos() {
        return visitInfos;
    }

    public void setVisitInfos(Set<TagVisitInfo> visitInfos) {
        this.visitInfos = visitInfos;
    }
}

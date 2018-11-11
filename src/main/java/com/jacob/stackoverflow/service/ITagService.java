package com.jacob.stackoverflow.service;

import com.jacob.stackoverflow.bean.TagVisitInfo;

import java.util.List;

public interface ITagService {

    /**
     * 从网页上获取Tag的信息，按页查询,讲数据存入mysql中.
     * @param begin 访问开始页，最小值为1.
     * @param end 访问结束页，最大值为1572.
     * @return List<Tag>.
     */
    List<List<TagVisitInfo>> addData(int begin, int end);
}

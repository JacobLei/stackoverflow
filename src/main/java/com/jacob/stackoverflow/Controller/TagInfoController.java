package com.jacob.stackoverflow.Controller;

import com.jacob.stackoverflow.domain.TagInfo;
import com.jacob.stackoverflow.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 页面展示
 * 1. save页面传入（以后这里应该是每天一次自动来存储）
 * 2. 按日期来查询当日的所有访问tags
 * 3. 按照tag名称查询近10日的访问情况
 *
 */
@RestController
@RequestMapping("/api/v1/tag_info")
public class TagInfoController {

    @Autowired
    private ITagService tagService;

    /**
     * 测试存储是否成功
     * @return
     */
    @GetMapping(path="add")
    public String addTagToTagInfo() {


        tagService.insertToTagInfo();
        return "saved";
    }

    /**
     * 测试存储从第n页到第m页的tags.
     * @param n 开始页
     * @param m　结束页
     * @return 存储结果
     */
    @GetMapping(path="addn2m")
    public String addTagToTagInfoPagN2M(@RequestParam int n, @RequestParam int m){
        int ret = tagService.insertToTagInfoFromN2M(n, m);

        return "saved";
    }

    /**
     *  测试按tagName查找数据库时，当查找的元素不存在时，返回值为null.
     * @return
     */
    @GetMapping(path = "find")
    public String findByNameFromTagInfo(){
        if(tagService.findByNameFromTagInfo("java2") == null){
            return "not found";
        }

        return "found it";
    }


}

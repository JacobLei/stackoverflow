package com.jacob.stackoverflow.Controller;

import com.jacob.stackoverflow.bean.Tag;
import com.jacob.stackoverflow.dao.TagRepository;
import com.jacob.stackoverflow.service.imp.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 页面展示
 * 1. save页面传入（以后这里应该是每天一次自动来存储）
 * 2. 按日期来查询当日的所有访问tags
 * 3. 按照tag名称查询近10日的访问情况
 *
 */
@Controller
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewTags(@RequestParam Integer begin, @RequestParam Integer end){
        TagServiceImpl tagService = new TagServiceImpl();
        List<Tag> list = tagService.search(begin, end);
        for(Tag t : list){
            tagRepository.save(t);
        }

        return "Saved";
    }
}

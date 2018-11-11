package com.jacob.stackoverflow.Controller;

import com.jacob.stackoverflow.bean.TagVisitInfo;
import com.jacob.stackoverflow.dao.TagInfoRepository;
import com.jacob.stackoverflow.dao.TagVisitInfoRepository;
import com.jacob.stackoverflow.service.imp.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 页面展示
 * 1. save页面传入（以后这里应该是每天一次自动来存储）
 * 2. 按日期来查询当日的所有访问tags
 * 3. 按照tag名称查询近10日的访问情况
 *
 */
@Controller
public class TagInfoController {


    @Autowired
    private TagInfoRepository tagInfoRepository;
    @Autowired
    private TagVisitInfoRepository tagVisitInfoRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewTags(@RequestParam Integer begin, @RequestParam Integer end) {
        TagServiceImpl tagService = new TagServiceImpl();
        List<List<TagVisitInfo>> list = tagService.addData(begin, end);
        for (List<TagVisitInfo> tagVisitInfos : list) {
            for(TagVisitInfo t : tagVisitInfos){
                t.setInputTime(new Date());
                t.setUpdateTime(new Date());
                if(!tagInfoRepository.existsByTagName(t.getTagInfo().getTagName())){
                    tagInfoRepository.save(t.getTagInfo());
                }
                tagVisitInfoRepository.save(t);
            }
        }
        return "Saved";
    }
}

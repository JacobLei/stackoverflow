package com.jacob.stackoverflow.Controller;

import com.jacob.stackoverflow.domain.TagInfo;
import com.jacob.stackoverflow.domain.TagVisitInfo;
import com.jacob.stackoverflow.mapper.TagInfoMapper;
import com.jacob.stackoverflow.mapper.TagVisitInfoMapper;
import com.jacob.stackoverflow.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/result")
public class ResultShowController {

    @Autowired
    private ITagService tagService;


    @GetMapping("hello")
    public String hello(){

        return "show_tag_info";
    }

    @GetMapping("show_tag_info")
    public String showTageInfo(ModelMap modelMap){
        List<TagInfo> tagInfoList = tagService.getTagInfos();

        modelMap.addAttribute("tagInfoList", tagInfoList);
        return "show_tag_info";
    }

    @GetMapping("show_tag_visit_info")
    public String showTagVisitInfo(ModelMap modelMap){
        List<TagVisitInfo> tagVisitInfoList = tagService.getTagVisitInfos();

        modelMap.addAttribute("tagVisitInfoList", tagVisitInfoList);
        return "show_tag_visit_info";
    }

    @GetMapping("show_all_info")
    public String showAllInfo(ModelMap modelMap){
        List<TagVisitInfo> tagVisitInfoList = tagService.getAllTags();
        modelMap.addAttribute("tagVisitInfoList", tagVisitInfoList);
        return "show_all_info";
    }
}

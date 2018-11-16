package com.jacob.stackoverflow.Controller;

import com.jacob.stackoverflow.domain.TagInfo;
import com.jacob.stackoverflow.mapper.TagInfoMapper;
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
    private TagInfoMapper tagInfoMapper;


    @GetMapping("hello")
    public String hello(){

        return "show";
    }

    @GetMapping("show")
    public String show(ModelMap modelMap){
        List<TagInfo> tagInfoList = tagInfoMapper.getAll();
        modelMap.addAttribute("tagInfoList", tagInfoList);
        return "show";
    }
}

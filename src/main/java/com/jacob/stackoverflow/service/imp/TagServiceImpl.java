package com.jacob.stackoverflow.service.imp;

import com.jacob.stackoverflow.bean.Tag;
import com.jacob.stackoverflow.service.ITagService;
import com.jacob.stackoverflow.utils.HttpUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class TagServiceImpl implements ITagService {

    @Override
    public List<Tag> search(int begin, int end) {
        List<Tag> list = HttpUtils.getInfo(begin, end);
//        if(list != null && list.size() > 0){
//
//        }
        return list;
    }
}

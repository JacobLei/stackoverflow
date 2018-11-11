package com.jacob.stackoverflow.service.imp;

import com.jacob.stackoverflow.bean.TagVisitInfo;
import com.jacob.stackoverflow.dao.TagInfoRepository;
import com.jacob.stackoverflow.dao.TagVisitInfoRepository;
import com.jacob.stackoverflow.service.ITagService;
import com.jacob.stackoverflow.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class TagServiceImpl implements ITagService {

//    @Autowired
//    private TagInfoRepository tagInfoRepository;
//    @Autowired
//    private TagVisitInfoRepository tagVisitInfoRepository;

    @Override
    public List<List<TagVisitInfo>> addData(int begin, int end) {
        List<List<TagVisitInfo>> list = HttpUtils.getInfo(begin, end);

//        if(list != null && list.size() > 0){
//            for(TagVisitInfo item : list){
////                if(tagInfoRepository.findByTagNameIsNull(item.getTagInfo().getTagName())){
////                    tagInfoRepository.save(item.getTagInfo());
////                }
//                tagInfoRepository.save(item.getTagInfo());
//                tagVisitInfoRepository.save(item);
//            }
//        }
        return list;
    }
}

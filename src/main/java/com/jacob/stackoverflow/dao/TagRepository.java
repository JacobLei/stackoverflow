package com.jacob.stackoverflow.dao;

import com.jacob.stackoverflow.bean.Tag;
import org.springframework.data.repository.CrudRepository;


public interface TagRepository extends CrudRepository<Tag, Integer> {

}

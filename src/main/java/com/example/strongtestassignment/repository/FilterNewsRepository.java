package com.example.strongtestassignment.repository;

import com.example.strongtestassignment.dto.NewsFilter;
import com.example.strongtestassignment.entity.News;

import java.util.List;

public interface FilterNewsRepository {

    List<News> findAllByFilter(NewsFilter filter);


    List<News> findAllBySourceId(Integer id);

    List<News> findAllByTopicId(Integer id);
}

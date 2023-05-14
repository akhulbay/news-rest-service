package com.example.strongtestassignment.mapper;

import com.example.strongtestassignment.dto.NewsSourceReadDto;
import com.example.strongtestassignment.entity.NewsSource;
import org.springframework.stereotype.Component;

@Component
public class NewsSourceReadMapper implements Mapper<NewsSource, NewsSourceReadDto>{
    @Override
    public NewsSourceReadDto map(NewsSource object) {
        return new NewsSourceReadDto(
                object.getId(),
                object.getName()
        );
    }
}

package com.example.strongtestassignment.mapper;

import com.example.strongtestassignment.dto.NewsSourceCreateEditDto;
import com.example.strongtestassignment.entity.NewsSource;
import org.springframework.stereotype.Component;

@Component
public class NewsSourceCreateEditMapper implements Mapper<NewsSourceCreateEditDto, NewsSource>{

    @Override
    public NewsSource map(NewsSourceCreateEditDto object) {
        NewsSource newsSource = new NewsSource();
        newsSource.setName(object.name());

        return newsSource;
    }

    @Override
    public NewsSource map(NewsSourceCreateEditDto fromObject, NewsSource toObject) {
        toObject.setName(fromObject.name());

        return toObject;
    }
}

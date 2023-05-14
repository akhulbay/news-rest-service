package com.example.strongtestassignment.mapper;

import com.example.strongtestassignment.dto.NewsReadDto;
import com.example.strongtestassignment.dto.NewsSourceReadDto;
import com.example.strongtestassignment.dto.NewsTopicReadDto;
import com.example.strongtestassignment.entity.News;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NewsReadMapper implements Mapper<News, NewsReadDto> {

    private final NewsSourceReadMapper newsSourceReadMapper;
    private final NewsTopicReadMapper newsTopicReadMapper;
    @Override
    public NewsReadDto map(News object) {
        NewsSourceReadDto newsSource = Optional.ofNullable(object.getNewsSource())
                .map(newsSourceReadMapper::map)
                .orElse(null);
        NewsTopicReadDto newsTopic = Optional.ofNullable(object.getNewsTopic())
                .map(newsTopicReadMapper::map)
                .orElse(null);
        return new NewsReadDto(
                object.getId(),
                object.getTitle(),
                object.getContent(),
                object.getPublishDate(),
                newsSource,
                newsTopic
        );
    }
}

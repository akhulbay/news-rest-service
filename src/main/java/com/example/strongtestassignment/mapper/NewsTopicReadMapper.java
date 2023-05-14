package com.example.strongtestassignment.mapper;

import com.example.strongtestassignment.dto.NewsTopicReadDto;
import com.example.strongtestassignment.entity.NewsTopic;
import org.springframework.stereotype.Component;

@Component
public class NewsTopicReadMapper implements Mapper<NewsTopic, NewsTopicReadDto>{
    @Override
    public NewsTopicReadDto map(NewsTopic object) {
        return new NewsTopicReadDto(
                object.getId(),
                object.getName()
        );
    }
}

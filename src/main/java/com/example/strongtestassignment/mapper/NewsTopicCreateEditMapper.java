package com.example.strongtestassignment.mapper;

import com.example.strongtestassignment.dto.NewsTopicCreateEditDto;
import com.example.strongtestassignment.entity.NewsTopic;
import org.springframework.stereotype.Component;

@Component
public class NewsTopicCreateEditMapper implements Mapper<NewsTopicCreateEditDto, NewsTopic> {


    @Override
    public NewsTopic map(NewsTopicCreateEditDto object) {
        NewsTopic newsTopic = new NewsTopic();
        newsTopic.setName(object.name());

        return newsTopic;
    }

    @Override
    public NewsTopic map(NewsTopicCreateEditDto fromObject, NewsTopic toObject) {
        toObject.setName(fromObject.name());

        return toObject;
    }
}

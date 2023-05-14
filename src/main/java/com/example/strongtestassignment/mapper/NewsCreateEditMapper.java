package com.example.strongtestassignment.mapper;

import com.example.strongtestassignment.dto.NewsCreateEditDto;
import com.example.strongtestassignment.entity.News;
import com.example.strongtestassignment.entity.NewsSource;
import com.example.strongtestassignment.entity.NewsTopic;
import com.example.strongtestassignment.repository.NewsSourceRepository;
import com.example.strongtestassignment.repository.NewsTopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NewsCreateEditMapper implements Mapper<NewsCreateEditDto, News> {

    private final NewsSourceRepository newsSourceRepository;
    private final NewsTopicRepository newsTopicRepository;

    @Override
    public News map(NewsCreateEditDto fromObject, News toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    @Override
    public News map(NewsCreateEditDto object) {
        News news = new News();
        copy(object, news);

        return news;
    }

    private void copy(NewsCreateEditDto object, News news) {
        news.setTitle(object.getTitle());
        news.setContent(object.getContent());
        news.setPublishDate(object.getPublishDate());
        news.setNewsSource(getNewsSource(object.getSourceId()));
        news.setNewsTopic(getNewsTopic(object.getTopicId()));
    }

    private NewsSource getNewsSource(Integer newsSourceId) {
        return Optional.ofNullable(newsSourceId)
                .flatMap(newsSourceRepository::findById)
                .orElse(null);
    }
    private NewsTopic getNewsTopic(Integer newsTopicId) {
        return Optional.ofNullable(newsTopicId)
                .flatMap(newsTopicRepository::findById)
                .orElse(null);
    }
}

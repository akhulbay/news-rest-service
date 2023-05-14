package com.example.strongtestassignment.dto;

import lombok.Value;

import java.time.LocalDate;

@Value
public class NewsReadDto {
    Long id;
    String title;
    String content;
    LocalDate publishDate;
    NewsSourceReadDto newsSource;
    NewsTopicReadDto newsTopic;
}

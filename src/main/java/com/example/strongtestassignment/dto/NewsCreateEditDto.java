package com.example.strongtestassignment.dto;

import lombok.Value;

import java.time.LocalDate;

@Value
public class NewsCreateEditDto {
    String title;
    String content;
    LocalDate publishDate;
    Integer sourceId;
    Integer topicId;
}

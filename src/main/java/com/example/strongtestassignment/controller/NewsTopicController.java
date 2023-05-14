package com.example.strongtestassignment.controller;

import com.example.strongtestassignment.dto.NewsSourceCreateEditDto;
import com.example.strongtestassignment.dto.NewsSourceReadDto;
import com.example.strongtestassignment.dto.NewsTopicCreateEditDto;
import com.example.strongtestassignment.dto.NewsTopicReadDto;
import com.example.strongtestassignment.service.NewsSourceService;
import com.example.strongtestassignment.service.NewsTopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/news-topic")
@RequiredArgsConstructor
public class NewsTopicController {

    private final NewsTopicService newsTopicService;

    @GetMapping
    public List<NewsTopicReadDto> findAll() {
        return newsTopicService.findAll();
    }

    @GetMapping("/{id}")
    public NewsTopicReadDto findById(@PathVariable("id") Integer id) {
        return newsTopicService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewsTopicReadDto create(NewsTopicCreateEditDto news) {
        return newsTopicService.create(news);
    }


    @PutMapping("/{id}")
    public NewsTopicReadDto update(@PathVariable("id") Integer id, NewsTopicCreateEditDto news) {
        return newsTopicService.update(id, news)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        if (!newsTopicService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

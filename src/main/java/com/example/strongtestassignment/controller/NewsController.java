package com.example.strongtestassignment.controller;

import com.example.strongtestassignment.dto.NewsCreateEditDto;
import com.example.strongtestassignment.dto.NewsFilter;
import com.example.strongtestassignment.dto.NewsReadDto;
import com.example.strongtestassignment.dto.PageResponse;
import com.example.strongtestassignment.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    public PageResponse<NewsReadDto> findAll(NewsFilter filter, Pageable pageable) {
        Page<NewsReadDto> page = newsService.findAll(filter, pageable);
        return PageResponse.of(page);
    }

    @GetMapping("/{id}")
    public NewsReadDto findById(@PathVariable("id") Long id) {
        return newsService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewsReadDto create(NewsCreateEditDto news) {
        return newsService.create(news);
    }


    @PutMapping("/{id}")
    public NewsReadDto update(@PathVariable("id") Long id, NewsCreateEditDto news) {
        return newsService.update(id, news)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        if (!newsService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

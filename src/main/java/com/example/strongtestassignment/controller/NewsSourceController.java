package com.example.strongtestassignment.controller;

import com.example.strongtestassignment.dto.NewsSourceCreateEditDto;
import com.example.strongtestassignment.dto.NewsSourceReadDto;
import com.example.strongtestassignment.service.NewsSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/news-source")
@RequiredArgsConstructor
public class NewsSourceController {

    private final NewsSourceService newsSourceService;

    @GetMapping
    public List<NewsSourceReadDto> findAll() {
        return newsSourceService.findAll();
    }

    @GetMapping("/{id}")
    public NewsSourceReadDto findById(@PathVariable("id") Integer id) {
        return newsSourceService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewsSourceReadDto create(NewsSourceCreateEditDto news) {
        return newsSourceService.create(news);
    }


    @PutMapping("/{id}")
    public NewsSourceReadDto update(@PathVariable("id") Integer id, NewsSourceCreateEditDto news) {
        return newsSourceService.update(id, news)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        if (!newsSourceService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

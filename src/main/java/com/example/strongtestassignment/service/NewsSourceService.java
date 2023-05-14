package com.example.strongtestassignment.service;

import com.example.strongtestassignment.dto.NewsSourceCreateEditDto;
import com.example.strongtestassignment.dto.NewsSourceReadDto;
import com.example.strongtestassignment.mapper.NewsSourceCreateEditMapper;
import com.example.strongtestassignment.mapper.NewsSourceReadMapper;
import com.example.strongtestassignment.repository.NewsSourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NewsSourceService {

    private final NewsSourceRepository newsSourceRepository;
    private final NewsSourceReadMapper newsSourceReadMapper;
    private final NewsSourceCreateEditMapper newsSourceCreateEditMapper;

    public List<NewsSourceReadDto> findAll() {
        return newsSourceRepository.findAll().stream()
                .map(newsSourceReadMapper::map)
                .toList();
    }

    public Optional<NewsSourceReadDto> findById(Integer id) {
        return newsSourceRepository.findById(id)
                .map(newsSourceReadMapper::map);
    }

    @Transactional
    public NewsSourceReadDto create(NewsSourceCreateEditDto newsDto) {
        return Optional.of(newsDto)
                .map(newsSourceCreateEditMapper::map)
                .map(newsSourceRepository::save)
                .map(newsSourceReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<NewsSourceReadDto> update(Integer id, NewsSourceCreateEditDto newsDto) {
        return newsSourceRepository.findById(id)
                .map(entity -> newsSourceCreateEditMapper.map(newsDto, entity))
                .map(newsSourceRepository::saveAndFlush)
                .map(newsSourceReadMapper::map);
    }

    @Transactional
    public boolean delete(Integer id) {
        return newsSourceRepository.findById(id)
                .map(entity -> {
                    newsSourceRepository.delete(entity);
                    return true;
                })
                .orElse(false);
    }
}

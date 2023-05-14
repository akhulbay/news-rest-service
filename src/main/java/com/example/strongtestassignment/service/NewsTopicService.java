package com.example.strongtestassignment.service;

import com.example.strongtestassignment.dto.NewsTopicCreateEditDto;
import com.example.strongtestassignment.dto.NewsTopicReadDto;
import com.example.strongtestassignment.mapper.NewsTopicCreateEditMapper;
import com.example.strongtestassignment.mapper.NewsTopicReadMapper;
import com.example.strongtestassignment.repository.NewsTopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NewsTopicService {

    private final NewsTopicRepository newsTopicRepository;
    private final NewsTopicReadMapper newsTopicReadMapper;
    private final NewsTopicCreateEditMapper newsTopicCreateEditMapper;

    public List<NewsTopicReadDto> findAll() {
        return newsTopicRepository.findAll().stream()
                .map(newsTopicReadMapper::map)
                .toList();
    }

    public Optional<NewsTopicReadDto> findById(Integer id) {
        return newsTopicRepository.findById(id)
                .map(newsTopicReadMapper::map);
    }

    @Transactional
    public NewsTopicReadDto create(NewsTopicCreateEditDto newsDto) {
        return Optional.of(newsDto)
                .map(newsTopicCreateEditMapper::map)
                .map(newsTopicRepository::save)
                .map(newsTopicReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<NewsTopicReadDto> update(Integer id, NewsTopicCreateEditDto newsDto) {
        return newsTopicRepository.findById(id)
                .map(entity -> newsTopicCreateEditMapper.map(newsDto, entity))
                .map(newsTopicRepository::saveAndFlush)
                .map(newsTopicReadMapper::map);
    }

    @Transactional
    public boolean delete(Integer id) {
        return newsTopicRepository.findById(id)
                .map(entity -> {
                    newsTopicRepository.delete(entity);
                    return true;
                })
                .orElse(false);
    }
}

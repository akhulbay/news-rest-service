package com.example.strongtestassignment.service;

import com.example.strongtestassignment.dto.NewsCreateEditDto;
import com.example.strongtestassignment.dto.NewsFilter;
import com.example.strongtestassignment.dto.NewsReadDto;
import com.example.strongtestassignment.entity.News;
import com.example.strongtestassignment.mapper.NewsCreateEditMapper;
import com.example.strongtestassignment.mapper.NewsReadMapper;
import com.example.strongtestassignment.repository.NewsRepository;
import com.example.strongtestassignment.specification.NewsSpecification;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NewsService {

    private final NewsRepository newsRepository;
    private final NewsReadMapper newsReadMapper;
    private final NewsCreateEditMapper newsCreateEditMapper;
    private final EntityManager entityManager;

    public List<NewsReadDto> findAll() {
        return newsRepository.findAll().stream()
                .map(newsReadMapper::map)
                .toList();
    }

    public Page<NewsReadDto> findAll(NewsFilter filter, Pageable pageable) {
        Specification<News> spec = NewsSpecification.withFilter(filter);
        return newsRepository.findAll(spec, pageable)
                .map(newsReadMapper::map);
    }

    public Optional<NewsReadDto> findById(Long id) {
        return newsRepository.findById(id)
                .map(newsReadMapper::map);
    }

    @Transactional
    public NewsReadDto create(NewsCreateEditDto newsDto) {
        return Optional.of(newsDto)
                .map(newsCreateEditMapper::map)
                .map(newsRepository::save)
                .map(newsReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<NewsReadDto> update(Long id, NewsCreateEditDto newsDto) {
        return newsRepository.findById(id)
                .map(entity -> newsCreateEditMapper.map(newsDto, entity))
                .map(newsRepository::saveAndFlush)
                .map(newsReadMapper::map);
    }

    @Transactional
    public boolean delete(Long id) {
        return newsRepository.findById(id)
                .map(entity -> {
                    newsRepository.delete(entity);
                    return true;
                })
                .orElse(false);
    }
}


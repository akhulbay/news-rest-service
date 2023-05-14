package com.example.strongtestassignment.repository.impl;

import com.example.strongtestassignment.dto.NewsFilter;
import com.example.strongtestassignment.entity.News;
import com.example.strongtestassignment.repository.FilterNewsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public class FilterNewsRepositoryImpl implements FilterNewsRepository {

    private final EntityManager entityManager;

    @Override
    public List<News> findAllByFilter(NewsFilter filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<News> criteria = cb.createQuery(News.class);

        Root<News> news = criteria.from(News.class);
        criteria.select(news);

        List<jakarta.persistence.criteria.Predicate> predicates = new ArrayList<>();
        if (filter.sourceId() != null) {
            predicates.add(cb.equal(news.get("newsSource").get("id"), filter.sourceId()));
        }
        if (filter.topicId() != null) {
            predicates.add(cb.equal(news.get("newsTopic").get("id"), filter.topicId()));
        }

        criteria.where(predicates.toArray(Predicate[]::new));

        return entityManager.createQuery(criteria).getResultList();
    }



    @Override
    public List<News> findAllBySourceId(Integer id) {
        return null;
    }

    @Override
    public List<News> findAllByTopicId(Integer id) {
        return null;
    }
}

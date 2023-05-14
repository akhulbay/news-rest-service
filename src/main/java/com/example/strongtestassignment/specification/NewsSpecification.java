package com.example.strongtestassignment.specification;

import com.example.strongtestassignment.dto.NewsFilter;
import com.example.strongtestassignment.entity.News;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class NewsSpecification {

    public static Specification<News> withFilter(NewsFilter filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.sourceId() != null) {
                predicates.add(cb.equal(root.get("newsSource").get("id"), filter.sourceId()));
            }
            if (filter.topicId() != null) {
                predicates.add(cb.equal(root.get("newsTopic").get("id"), filter.topicId()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };

    }
}

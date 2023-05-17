package com.example.strongtestassignment.repository;

import com.example.strongtestassignment.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long>,
        FilterNewsRepository,
        JpaSpecificationExecutor<News> {
    Integer countNewsByNewsSource_Id(Integer sourceId);
}

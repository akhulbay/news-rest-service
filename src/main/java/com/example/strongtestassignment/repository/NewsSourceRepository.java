package com.example.strongtestassignment.repository;

import com.example.strongtestassignment.entity.NewsSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsSourceRepository extends JpaRepository<NewsSource, Integer> {

}

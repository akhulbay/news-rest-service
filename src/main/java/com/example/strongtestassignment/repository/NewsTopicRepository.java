package com.example.strongtestassignment.repository;

import com.example.strongtestassignment.entity.NewsTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsTopicRepository extends JpaRepository<NewsTopic, Integer> {
}

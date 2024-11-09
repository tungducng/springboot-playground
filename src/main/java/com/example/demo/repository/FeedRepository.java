package com.example.demo.repository;

import com.example.demo.entity.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<FeedEntity, Long> {
}

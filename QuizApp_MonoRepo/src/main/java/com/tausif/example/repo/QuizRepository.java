package com.tausif.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tausif.example.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}

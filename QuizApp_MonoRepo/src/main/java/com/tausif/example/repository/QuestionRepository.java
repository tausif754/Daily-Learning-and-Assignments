package com.tausif.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tausif.example.entity.Question;
import com.tausif.example.enums.Category;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    // Native query to fetch 3 random questions by category and difficulty
    @Query(value = "SELECT * FROM question q WHERE q.category = :category AND q.difficulty_level = :difficulty ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Question> findRandomQuestionsByCategoryAndLevel(String category, String difficulty);

    // JPA method to get all questions by category
    List<Question> findByCategory(Category category);
}

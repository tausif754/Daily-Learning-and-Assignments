package com.tausif.example.service;

import java.util.List;

import com.tausif.example.entity.Quiz;

public interface QuizService {

    Quiz createQuiz(Quiz quiz);

    List<Quiz> getAllQuizzes();

    Quiz getQuizById(Integer id);
}

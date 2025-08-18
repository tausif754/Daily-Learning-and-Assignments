package com.tausif.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tausif.example.entity.Question;
import com.tausif.example.enums.Category;
import com.tausif.example.repo.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    // Get all questions
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    // Get questions by category
    public List<Question> getQuestionsByCategory(Category category) {
        return questionRepository.findByCategory(category);
    }

    // Get a single question by ID
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Question not found with id: " + id));
    }

    // Add a new question
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    // Update existing question
    public Question updateQuestion(Long id, Question updatedQuestion) {
        Question existingQuestion = getQuestionById(id);
        existingQuestion.setTitle(updatedQuestion.getTitle());
        existingQuestion.setOptions(updatedQuestion.getOptions());
        existingQuestion.setCorrectAnswer(updatedQuestion.getCorrectAnswer());
        existingQuestion.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
        existingQuestion.setCategory(updatedQuestion.getCategory());
        return questionRepository.save(existingQuestion);
    }

    // Delete a question
    public void deleteQuestion(Long id) {
        Question question = getQuestionById(id);
        questionRepository.delete(question);
    }
}

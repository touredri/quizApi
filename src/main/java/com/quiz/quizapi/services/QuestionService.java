package com.quiz.quizapi.services;


import com.quiz.quizapi.models.Question;
import com.quiz.quizapi.models.Quiz;
import com.quiz.quizapi.repositories.QuestionRepository;
import com.quiz.quizapi.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question creerQuiz(Question question) {
        return questionRepository.save(question);
    }

    public Question creerQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }
}
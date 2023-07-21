package com.quiz.quizapi.services;

import com.quiz.quizapi.models.Quiz;
import com.quiz.quizapi.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

   // @Autowired
    private static QuizRepository quizRepository;
    public Quiz creerQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public static Object getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public static Object getAllQuiz() {
        return quizRepository.findAll();
    }

    public static Object deleteQuizById(Long id) {
        quizRepository.deleteById(id);
        return null;
    }
}

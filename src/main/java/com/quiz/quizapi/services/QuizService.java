package com.quiz.quizapi.services;

import com.quiz.quizapi.models.Quiz;
import com.quiz.quizapi.models.Utilisateur;
import com.quiz.quizapi.repositories.QuizRepository;
import com.quiz.quizapi.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class QuizService {

   @Autowired
    private  QuizRepository quizRepository;
    public QuizService (QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }
    public Quiz creerQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public  Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public List<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }

    public Quiz deleteQuizById(Long id) {
        quizRepository.deleteById(id);
        return null;
    }
}

package com.quiz.quizapi.controllers;

import com.quiz.quizapi.models.Question;
import com.quiz.quizapi.models.Quiz;
import com.quiz.quizapi.services.QuestionService;
import com.quiz.quizapi.services.QuizService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@RestController
@Tag(name = "Questions, description=API pour gérer les questions")
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizService quizService;
    @Operation(summary = "Créer une question")
    @PostMapping("/creer/{quiz_id}")
    public Question creer(@RequestBody Question question, @PathVariable("quiz_id") Long id) {
        Quiz quiz = quizService.getQuizById(id);
        if (quiz != null) {
            question.setQuiz(quiz);
            return questionService.creerQuestion(question);
        }
        return null;
    }
    @Operation(summary = "Récupérer une question par son identifiant!")
    @GetMapping("{id}")
    public Question getQuestion(@PathVariable("id") Long id) {
        return questionService.getQuestionById(id);
    }
    @Operation(summary = "Récupérer toutes les questions")
    @GetMapping("all")
    public List<Question> listQuestion() {
        return questionService.getAllQuestion();
    }
}

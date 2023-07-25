package com.quiz.quizapi.controllers;

import com.quiz.quizapi.models.Question;
import com.quiz.quizapi.models.Quiz;
import com.quiz.quizapi.services.QuestionService;
import com.quiz.quizapi.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizService quizService;

    @PostMapping("/creer/{quiz_id}")
    public Question creer(@RequestBody Question question, @PathVariable("quiz_id") Long id) {
        Quiz quiz = quizService.getQuizById(id);
        if (quiz != null) {
            question.setQuiz(quiz);
            return questionService.creerQuestion(question);
        }
        return null;
    }

    @GetMapping("{id}")
    public Question getQuestion(@PathVariable("id") Long id) {
        return questionService.getQuestionById(id);
    }

    @GetMapping("all")
    public List<Question> listQuestion() {
        return questionService.getAllQuestion();
    }
}

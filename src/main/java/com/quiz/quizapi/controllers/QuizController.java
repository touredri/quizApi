package com.quiz.quizapi.controllers;

import com.quiz.quizapi.models.Quiz;
import com.quiz.quizapi.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @PostMapping("/creer")
    public ResponseEntity<Quiz> creerQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(quizService.creerQuiz(quiz));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable("id") Long id){
        Quiz quiz = (Quiz) QuizService.getQuizById(id);
        if(quiz != null){
            return ResponseEntity.ok(quiz);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<Quiz> getAllQuiz(){
        return ResponseEntity.ok((Quiz) QuizService.getAllQuiz());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Quiz> deleteQuizById(@PathVariable("id") Long id){
        QuizService.deleteQuizById(id);
        return ResponseEntity.ok().build();
    }
}

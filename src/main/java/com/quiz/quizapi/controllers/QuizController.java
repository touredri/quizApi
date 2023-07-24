package com.quiz.quizapi.controllers;

import com.quiz.quizapi.models.Quiz;
import com.quiz.quizapi.models.Utilisateur;
import com.quiz.quizapi.services.QuizService;
import com.quiz.quizapi.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @Autowired
    private UtilisateurService userService;

    @PostMapping("/creer/{user_id}")
    public ResponseEntity<Quiz> creerQuiz(@PathVariable("user_id") Long user_id,@RequestBody Quiz quiz){
        Utilisateur user = userService.getUtilisateurById(user_id);
        if(user != null) {

            quiz.setUtilisateur(user);
            Quiz quizs = quizService.creerQuiz(quiz);
            return ResponseEntity.ok(quizs);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @GetMapping("/hello")
    public String  getQuizById(){
            return "Bonjour";
        }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable("id") Long id){
        Quiz quiz = (Quiz) quizService.getQuizById(id);
        if(quiz != null){
            return ResponseEntity.ok(quiz);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public List<Quiz> getAllQuiz(){
        return quizService.getAllQuiz();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Quiz> deleteQuizById(@PathVariable("id") Long id){
        quizService.deleteQuizById(id);
        return ResponseEntity.ok().build();
    }
}

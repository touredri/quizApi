package com.quiz.quizapi.controllers;

import com.quiz.quizapi.models.Quiz;
import com.quiz.quizapi.models.Utilisateur;
import com.quiz.quizapi.services.QuizService;
import com.quiz.quizapi.services.UtilisateurService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Quiz, description=API pour gérer les quiz")
@RequestMapping("/api/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @Autowired
    private UtilisateurService userService;
    @Operation(summary = "Créer un compte d'utilisateur")
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
    @Operation(summary = "Récupérer les information d'un compte d'utilisateur")
    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable("id") Long id){
        Quiz quiz = (Quiz) quizService.getQuizById(id);
        if(quiz != null){
            return ResponseEntity.ok(quiz);
        }
        return ResponseEntity.notFound().build();
    }
    @Operation(summary = "Récupérer toutes les quiz")
    @GetMapping("/all")
    public List<Quiz> getAllQuiz(){
        return quizService.getAllQuiz();
    }
    @Operation(summary = "Supprimer un quiz")
    @DeleteMapping("/{id}")
    public ResponseEntity<Quiz> deleteQuizById(@PathVariable("id") Long id){
        quizService.deleteQuizById(id);
        return ResponseEntity.ok().build();
    }


}

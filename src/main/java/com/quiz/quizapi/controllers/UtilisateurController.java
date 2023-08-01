package com.quiz.quizapi.controllers;

import com.quiz.quizapi.models.Utilisateur;
import com.quiz.quizapi.repositories.QuestionRepository;
import com.quiz.quizapi.repositories.QuizRepository;
import com.quiz.quizapi.repositories.UtilisateurRepository;
import com.quiz.quizapi.services.UtilisateurService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Utilisateurs, description=API pour gérer les utilisateurs")
@RequestMapping("/api/user")
public class UtilisateurController {
    @Autowired
    private final UtilisateurService utilisateurService;
    @Autowired
    private UtilisateurRepository userRepo;
    @Autowired
    private QuizRepository QuizRepo;
    @Autowired
    private QuestionRepository QuestionRepo;
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
    @Operation(summary = "Créer un compte d'utilisateur")
    @PostMapping("/creerCompte")
    public ResponseEntity<Utilisateur> creerUser(@RequestBody Utilisateur user) {
        return ResponseEntity.ok((Utilisateur) utilisateurService.createUser(user));
    }
    @Operation(summary = "Récupérer les information d'un compte d'utilisateur")
    @GetMapping("/show")
    public List<Utilisateur> showAll() {
        return utilisateurService.findA();
    }
    @Operation(summary = "Supprimer un compte d'utilisateur")
    @DeleteMapping("/{id}")
    public ResponseEntity<Utilisateur> deleteUtilisateurById(@PathVariable("id") Long id){
        utilisateurService.deleteUtilisateurById(id);
        return ResponseEntity.ok().build();
    }

}
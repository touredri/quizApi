package com.quiz.quizapi.controllers;

import com.quiz.quizapi.models.Quiz;
import com.quiz.quizapi.models.Utilisateur;
import com.quiz.quizapi.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/creerCompte")
    public ResponseEntity<Utilisateur> creerUser(@RequestBody Utilisateur user) {
        return ResponseEntity.ok((Utilisateur) utilisateurService.createUser(user));
    }

    @GetMapping("/show")
    public List<Utilisateur> showAll() {
        return utilisateurService.findA();
    }
    @GetMapping("show/{id}")
    public Utilisateur mt(@PathVariable("id") Long id){
        return utilisateurService.findById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Utilisateur> deleteUtilisateurById(@PathVariable("id") Long id){
        utilisateurService.deleteUtilisateurById(id);
        return ResponseEntity.ok().build();
    }
}

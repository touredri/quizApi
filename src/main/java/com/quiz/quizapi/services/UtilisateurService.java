package com.quiz.quizapi.services;

import com.quiz.quizapi.models.Utilisateur;
import com.quiz.quizapi.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository userRepo;

    public UtilisateurService(UtilisateurRepository userRepo) {
        this.userRepo = userRepo;
    }

    public  Utilisateur findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public  Utilisateur getUtilisateurById(Long userId) {
        return userRepo.findById(userId).orElse(null);
    }

    public Object createUser(Utilisateur user) {
        return userRepo.save(user);
    }

    public List<Utilisateur> findA() {
        return userRepo.findAll();
    }
    public  Utilisateur deleteUtilisateurById(Long id) {
        userRepo.deleteById(id);
        return null;
    }
}

package com.quiz.quizapi.controllers;

import java.util.ArrayList;
import java.util.List;

import com.quiz.quizapi.models.Quiz;
import com.quiz.quizapi.models.Utilisateur;
import com.quiz.quizapi.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.quiz.quizapi.models.Resultat;
import com.quiz.quizapi.services.ResultatService;

@RestController
@RequestMapping("api/resultat")
public class ResultatController {
		@Autowired
	    private ResultatService resultatService;
		@Autowired
		private UtilisateurService utilisateurService;
		@Autowired
		private QuizController quizService;

		@PostMapping("/new/{user_id}/{quiz_id}")
		public Resultat createResultat(@RequestBody Resultat resultat, @PathVariable Long user_id, @PathVariable Long quiz_id) {
			Utilisateur user = utilisateurService.findById(user_id);
			resultat.setUtilisateur(user);
			Quiz quiz = quizService.getQuizById(quiz_id).getBody();
			resultat.setQuiz(quiz);
			return resultatService.save(resultat);
		}
		@GetMapping("/all")
		public List<Resultat> getAll(){
			return resultatService.findAll();
		}

		@GetMapping("/{id}")
		public Resultat getById(@PathVariable Long id) {
			return resultatService.findById(id);
		}

		@GetMapping("/quiz/{quiz_id}")
		public List<Resultat> getByQuizId(@PathVariable("quiz_id") Long quiz_id) {
			return resultatService.findAllByQuizId(quiz_id);
		}


}

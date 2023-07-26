package com.quiz.quizapi.controllers;

import java.util.ArrayList;
import java.util.List;

import com.quiz.quizapi.models.*;
import com.quiz.quizapi.services.ReponseService;
import com.quiz.quizapi.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

		@Autowired
		private ReponseService reponseService;


	@PostMapping("/fairequiz/{user_id}/{quiz_id}/{question_id}")
	public String fairequiz(@PathVariable("user_id") Long user_id, @PathVariable("quiz_id") Long quiz_id,
											  @PathVariable("question_id") Long question_id, @RequestParam Long checkedReponse){
		Utilisateur user = utilisateurService.findById(user_id);
		Quiz quiz = quizService.getQuizById(quiz_id).getBody();
		Resultat resultatData = resultatService.findByUserAndQuiz(user, quiz);
		if(resultatData == null){
			Resultat resultat = new Resultat();
			resultat.setUtilisateur(user);
			resultat.setQuiz(quiz);
			resultatService.save(resultat);
		}
		Reponse reponse = reponseService.getReponseById(checkedReponse);
		if(reponse.getReponse()){
			resultatData.setScore(resultatData.getScore() + 50);
			resultatService.save(resultatData);
			return "Mr "+user.getPseudo()+" Vous avez choisi la bonne reponse!";
		}else{
			return "Vous avez choisi la mauvaise reponse!";
		}

	}
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

package com.quiz.quizapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.quizapi.models.Resultat;
import com.quiz.quizapi.services.ResultatService;

@Controller
@RequestMapping("api/resultats")
public class ResultatController {
	 @Autowired
	    private ResultatService resultatService;

	    @GetMapping("/resultatsQuiz")
	    public String getResultats(Model model) {
	        List<Resultat> resultats = resultatService.findAll();
	        model.addAttribute("resultats", resultats);
	        return "resultats";
	    }

	    @GetMapping("/resultatsQuiz/{id}")
	    public String getResultat(@PathVariable int id, Model model) {
	        Resultat resultat = resultatService.findById(id);

	        model.addAttribute("resultat", resultat);

	        return "resultat";
	    }

	    @GetMapping("/resultatsQuiz/new")
	    public String newResultat(Model model) {
	        Resultat resultat = new Resultat();

	        model.addAttribute("resultat", resultat);

	        return "new_resultat";
	    }

	    @PostMapping("/resultatsQuiz")
	    public String createResultat(Resultat resultat) {
	        resultatService.save(resultat);
	        return "redirect:/resultats";
	    }
}

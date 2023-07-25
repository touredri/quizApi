package com.quiz.quizapi.controllers;

import com.quiz.quizapi.models.Question;
import com.quiz.quizapi.models.Reponse;
import com.quiz.quizapi.repositories.ReponseRepository;
import com.quiz.quizapi.services.QuestionService;
import com.quiz.quizapi.services.ReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reponse")
public class ReponseController {
    @Autowired
    private ReponseService reponseService;

    @Autowired
    private QuestionService questionService;

    @PostMapping("creer/{id}")
    public Reponse addReponse(@RequestBody Reponse reponse, @PathVariable("id") Long id) {
        Question question = questionService.getQuestionById(id);
        if(question != null) {
            reponse.setQuestion(question);
            return reponseService.addReponse(reponse);
        }
        return null;
    }

    @GetMapping("all/{id}")
    public List<Reponse> reponseList(@PathVariable("id") Long id) {
        return reponseService.getAllReponseForQuestion(id);
    }

    @DeleteMapping("supprimer/{id}")
    public void deleteReponse(@PathVariable("id") Long id) {
        reponseService.deleteReponse(id);
    }
}

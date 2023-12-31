package com.quiz.quizapi.services;

import com.quiz.quizapi.models.Question;
import com.quiz.quizapi.models.Reponse;
import com.quiz.quizapi.repositories.ReponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class ReponseService {
    @Autowired
    private ReponseRepository reponseRepository;

    public List<Reponse> getAllReponseForQuestion(Long id) {
        return reponseRepository.findAllByQuestionId(id);
    }

    public Reponse addReponse(Reponse reponse) {
        return reponseRepository.save(reponse);
    }
}

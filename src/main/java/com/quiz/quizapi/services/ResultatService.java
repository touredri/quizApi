package com.quiz.quizapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.quizapi.models.Resultat;
import com.quiz.quizapi.repositories.ResultatRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class ResultatService {
	
	@Autowired
    private  ResultatRepository resultatRepository;

	public Resultat findById(Long id) {
        return resultatRepository.findById(id).orElse(null);
    }

    public Resultat save(Resultat resultat) {
         resultatRepository.save(resultat);
         return null;
    }

    public void delete(Resultat resultat) {
    	resultatRepository.delete(resultat);
    }


	public List<Resultat> findAll() {
		return resultatRepository.findAll();
	}

    public List<Resultat> findAllByQuizId(Long quizId) {
        return resultatRepository.findAllByQuizId(quizId);
    }
}

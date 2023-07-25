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
	
	private final ResultatRepository resultatRepository;
	@Autowired
	public ResultatService(ResultatRepository resultatRepository) {
		this.resultatRepository = resultatRepository;
	}
	public Resultat findById(int id) {
        return resultatRepository.findById(id).orElse(null);
    }

    public Resultat save(Resultat resultat) {
        return resultatRepository.save(resultat);
    }

    public void delete(Resultat resultat) {
    	resultatRepository.delete(resultat);
    }

    public List<Resultat> findByQuizId(int quizId) {
        return resultatRepository.findByQuizId(quizId);
    }

    public List<Resultat> findByUserUsername(String Pseudo) {
        return resultatRepository.findByUserUsername(Pseudo);
    }

	public List<Resultat> findAll() {
		return resultatRepository.findAll();
	}
}

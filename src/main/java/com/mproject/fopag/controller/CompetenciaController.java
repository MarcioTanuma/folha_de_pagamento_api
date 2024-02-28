package com.mproject.fopag.controller;

import com.mproject.fopag.models.Competencia;
import com.mproject.fopag.repository.CompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("competencias")
public class CompetenciaController {

    @Autowired
    private CompetenciaRepository competenciaRepository;

    @PostMapping
    public Competencia salvarCompetencia(@RequestBody Competencia competencia) {
        return competenciaRepository.save(competencia);
    }
}


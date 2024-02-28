package com.mproject.fopag.repository;

import com.mproject.fopag.models.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetenciaRepository extends JpaRepository<Competencia, Long> {
    Competencia findByAnoAndMes(int ano, int mes);
}

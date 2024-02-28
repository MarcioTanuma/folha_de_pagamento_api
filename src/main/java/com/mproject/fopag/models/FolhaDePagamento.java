package com.mproject.fopag.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FolhaDePagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private float descInss;
    private float descIrrf;
    private float fgtsFuncionário;
    private float fgtsGoverno;
    private float valorHoraExtra;
    private float salarioLiquido;
    @OneToOne
    @JoinColumn(name = "competencia_id")
    private Competencia competencia;
    @OneToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
}

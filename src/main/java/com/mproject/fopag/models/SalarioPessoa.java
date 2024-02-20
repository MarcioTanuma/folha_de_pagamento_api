package com.mproject.fopag.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "SALARIO_PESSOA")
public class SalarioPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;
    private String cpf;
    private float salarioBase;
    private float salarioLiquido;
    private int qtdDependente;
    private int horasMes;
    private float percentual;
    private float qtdeHoraExtra;

}

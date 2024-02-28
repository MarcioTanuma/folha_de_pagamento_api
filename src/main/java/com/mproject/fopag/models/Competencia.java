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
public class Competencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int ano;
    private int mes;

}

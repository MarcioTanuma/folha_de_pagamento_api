package com.mproject.fopag.repository;

import com.mproject.fopag.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
    Funcionario findByCpf(String cpf);

}

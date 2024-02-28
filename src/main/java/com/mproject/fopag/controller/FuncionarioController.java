package com.mproject.fopag.controller;

import com.mproject.fopag.models.Competencia;
import com.mproject.fopag.models.FolhaDePagamento;
import com.mproject.fopag.models.Funcionario;
import com.mproject.fopag.repository.CompetenciaRepository;
import com.mproject.fopag.repository.FolhaDePagamentoRepository;
import com.mproject.fopag.repository.FuncionarioRepository;
import com.mproject.fopag.service.CalculoSalarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private FolhaDePagamentoRepository folhaDePagamentoRepository;
    @Autowired
    private CompetenciaRepository competenciaRepository;

    private CalculoSalarioService calculoSalarioService=new CalculoSalarioService();

    @PostMapping
    public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @GetMapping
    public List<Funcionario> listarTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @GetMapping("/{cpf}")
    public Funcionario listarFuncionarioPorCpf(@PathVariable String cpf) {
        return funcionarioRepository.findByCpf(cpf);
    }

    @GetMapping("/{cpf}/competencia/{ano}/{mes}")
    public FolhaDePagamento listarFolhaDePagamento(@PathVariable String cpf, @PathVariable int ano, @PathVariable int mes) {
        FolhaDePagamento folhaDePagamento=new FolhaDePagamento();
        Funcionario funcionario=funcionarioRepository.findByCpf(cpf);
        Competencia competencia=competenciaRepository.findByAnoAndMes(ano, mes);
        folhaDePagamento.setFuncionario(funcionario);
        folhaDePagamento.setCompetencia(competencia);
        folhaDePagamento.setDescInss(calculoSalarioService.retornaDescontoInss(funcionario.getSalarioBase()));
        folhaDePagamento.setDescIrrf(calculoSalarioService.retornaDescontoIrrf(funcionario.getSalarioBase(),funcionario.getQtdDependentes() ));
        folhaDePagamento.setFgtsFuncionário(calculoSalarioService.retornaFgtsEmpregado(funcionario.getSalarioBase()));
        folhaDePagamento.setFgtsGoverno(calculoSalarioService.retornaFgtsGoverno(funcionario.getSalarioBase()));
        folhaDePagamento.setSalarioLiquido(calculoSalarioService.retornaSalarioLiquido(funcionario.getSalarioBase(),funcionario.getQtdDependentes()));
        folhaDePagamento.setValorHoraExtra(calculoSalarioService.valorTotalHoraExtra);
        return folhaDePagamentoRepository.save(folhaDePagamento);
    }
}


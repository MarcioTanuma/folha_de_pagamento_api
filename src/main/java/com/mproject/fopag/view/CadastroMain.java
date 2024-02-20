package com.mproject.fopag.view;

import com.mproject.fopag.models.SalarioPessoa;
import com.mproject.fopag.service.CalculoSalarioService;

import java.util.Scanner;

public class CadastroMain {
    public static void main(String[] args) {

        CalculoSalarioService calculoSalarioService = new CalculoSalarioService();
        SalarioPessoa salarioPessoa = new SalarioPessoa();

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== INFORMAÇÕES CADASTRAIS PARA CÁLCULO =====");

        System.out.println("Digite o Nome: ");
        salarioPessoa.setNome(scanner.nextLine());

        System.out.println("CPF: ");
        salarioPessoa.setCpf(scanner.nextLine());

        System.out.println("Salario: ");
        salarioPessoa.setSalarioBase(scanner.nextFloat());

        System.out.println("Quantidade de Dependentes: ");
        salarioPessoa.setQtdDependente(scanner.nextInt());

        // System.out.println("Quantidade de horas mês: ");
        // salarioPessoa.setHorasMes(scanner.nextInt());

        System.out.println("Quantidade de horas extras 1: ");
        salarioPessoa.setQtdeHoraExtra(scanner.nextFloat());

        System.out.println("Percentual Hora Extra 1: ");
        salarioPessoa.setPercentual(scanner.nextFloat());

        System.out.println("============== P R O V E N T O S ================");

        System.out.println("Salário Mês  : " + salarioPessoa.getSalarioBase());
        System.out.println("Valor Extra 1: " + (calculoSalarioService.retornaHoraExtra(salarioPessoa.getSalarioBase(), salarioPessoa.getHorasMes(), salarioPessoa.getPercentual(), salarioPessoa.getQtdeHoraExtra())));

        System.out.println("============== D E S C O N T O S ================");

        System.out.println("Desconto INSS: " + (calculoSalarioService.retornaDescontoInss(salarioPessoa.getSalarioBase())));
        System.out.println("Desconto IRRF: " + (calculoSalarioService.retornaDescontoIrrf(salarioPessoa.getSalarioBase(), salarioPessoa.getQtdDependente())));

        System.out.println("========== SALÁRIO LÍQUIDO A RECEBER ============");

        System.out.println("Liquido a Receber: " + (calculoSalarioService.retornaSalarioLiquido(salarioPessoa.getSalarioBase(), salarioPessoa.getQtdDependente())));

        System.out.println("============= DEPÓSITOS DE FGTS =================");
        System.out.println("FGTS 8%  : " + (calculoSalarioService.retornaFgtsEmpregado(salarioPessoa.getSalarioBase())));
        System.out.println("FGTS 0,5%: " + (calculoSalarioService.retornaFgtsGoverno(salarioPessoa.getSalarioBase())));

    }
}

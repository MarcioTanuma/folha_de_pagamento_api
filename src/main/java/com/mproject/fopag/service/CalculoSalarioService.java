package com.mproject.fopag.service;

public class CalculoSalarioService {

    public float valorTotalHoraExtra;

    public float retornaDescontoInss(float salarioBase) {
        float descontoInss;
        salarioBase = salarioBase + valorTotalHoraExtra;
        if (salarioBase <= 1302.00){
            descontoInss = salarioBase*0.075f;
        } else if (salarioBase > 1302.00 && salarioBase <= 2571.29){
            descontoInss = salarioBase*0.09f;
        } else if (salarioBase > 2571.29 && salarioBase <=  3856.94){
            descontoInss = salarioBase*0.12f;
        } else if (salarioBase > 3856.94 && salarioBase <=  7507.49) {
            descontoInss = salarioBase * 0.14f;
        } else {
            descontoInss = salarioBase - (salarioBase - 1051.05f);
        }

        return descontoInss;
    }

    public float retornaDescontoIrrf(float salarioBase, int qtdDependentes) {
        float descontoIrrfTotal = 0;
        float descontoDependente = 189.59f;
        salarioBase = salarioBase + valorTotalHoraExtra;
        float descontoBaseIrrf = salarioBase - (descontoDependente*qtdDependentes) - retornaDescontoInss(salarioBase);

        if(descontoBaseIrrf < 212.00){
            descontoIrrfTotal = descontoBaseIrrf;
        } else if (descontoBaseIrrf > 212.00 && descontoBaseIrrf <= 2826.65) {
            descontoIrrfTotal = (descontoBaseIrrf * 0.075f) - 158.40f;
        } else if (descontoBaseIrrf > 2826.65 && descontoBaseIrrf <= 3751.05) {
            descontoIrrfTotal = (descontoBaseIrrf * 0.15f) - 370.40f;
        } else if (descontoBaseIrrf > 3751.05 && descontoBaseIrrf <= 4664.68) {
            descontoIrrfTotal = (descontoBaseIrrf * 0.225f) - 651.73f;
        } else {
            descontoIrrfTotal = (descontoBaseIrrf * 0.275f) - 884.96f;
        }

        return descontoIrrfTotal;
    }

    public float retornaFgtsEmpregado(float salarioBase) {
        salarioBase = salarioBase + valorTotalHoraExtra;
        return salarioBase*0.08f;
    }

    public float retornaFgtsGoverno(float salarioBase) {
        salarioBase = salarioBase + valorTotalHoraExtra;
        return salarioBase*0.005f;
    }

    public float retornaSalarioLiquido(float salarioBase, int qtdDependente){
        salarioBase = salarioBase + valorTotalHoraExtra;
        return salarioBase - (retornaDescontoInss(salarioBase) + retornaDescontoIrrf(salarioBase, qtdDependente));
    }
    public float retornaHoraExtra(float salarioBase, int horasMes, float percentual, float qtdeHoraExtra){
        valorTotalHoraExtra = ((salarioBase / 210) * (percentual + 1)) * qtdeHoraExtra;
        return valorTotalHoraExtra;
    }


}

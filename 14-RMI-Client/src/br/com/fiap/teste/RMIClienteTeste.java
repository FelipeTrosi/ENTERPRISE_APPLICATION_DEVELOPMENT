package br.com.fiap.teste;

import java.rmi.Naming;

import br.com.fiap.bo.CalculadoraBO;

public class RMIClienteTeste {
	
	public static void main(String[] args) throws Exception {
		CalculadoraBO bo = (CalculadoraBO) Naming.lookup("rmi://localhost:1234/churros");
	
	int soma = bo.somar(10, 10, 10);
	
	System.out.println(soma);
	}

}

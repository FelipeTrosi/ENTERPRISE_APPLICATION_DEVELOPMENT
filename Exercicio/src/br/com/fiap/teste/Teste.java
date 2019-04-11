package br.com.fiap.teste;

import org.junit.jupiter.api.Test;

import br.com.fiap.entity.CasoTeste;
import br.com.fiap.entity.Sistema;

public class Teste {

	@Test
	void teste() {
		 
		Sistema sistema = new Sistema();
		sistema.setNome("Sisteminha camarada");
		
		CasoTeste casoTeste = new CasoTeste();
		casoTeste.setDescricao("Um caso de teste");
		
		
		
	}
}

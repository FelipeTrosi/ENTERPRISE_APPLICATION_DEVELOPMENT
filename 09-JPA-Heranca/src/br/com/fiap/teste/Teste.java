package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.dao.impl.VeiculoDAOImpl;
import br.com.fiap.entity.Barco;
import br.com.fiap.entity.Carro;
import br.com.fiap.entity.TipoBarco;
import br.com.fiap.entity.Veiculo;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class Teste {
	private static VeiculoDAO dao;

	@BeforeAll
	public static void init() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new VeiculoDAOImpl(em);
	}

	@Test
	void cadastro() {
		Veiculo veiculo = new Veiculo(200, "AUDI");
		Carro carro = new Carro(200, "CORSA", 13, 2);
		Barco barco = new Barco(150, "ZECA", 750, TipoBarco.IATE);

		try {
			dao.cadastrar(barco);
			dao.cadastrar(veiculo);
			dao.cadastrar(carro);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Erro");
		}

	}

}

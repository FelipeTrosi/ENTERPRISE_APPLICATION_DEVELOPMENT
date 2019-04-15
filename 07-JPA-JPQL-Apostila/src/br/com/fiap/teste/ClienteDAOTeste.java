package br.com.fiap.teste;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;

class ClienteDAOTeste {

	private static ClienteDAO dao;
	
	@BeforeAll
	public static void instanciar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ClienteDAOImpl(em);
	}
	
	@Test
	void pesquisarPorDiasReserva() {
		List<Cliente> lista = dao.pesquisarPorDiaReserva(10);
		assertEquals(4, lista.size());
	}
	/*
	@Test
	void pesquisarTeste() {
		List<Cliente> lista = dao.pesquisar();
		assertEquals(5, lista.size());
	}
	 */
	/*@Test
	void pesquisarPorNome() {
		List<Cliente> lista = dao.pesquisar("Mar");
		//valida se a lista de cliente está correta
		for(Cliente cliente : lista) {
			assertTrue(cliente.getNome().contains("Mar"));
		}
	}*/
	
	@Test
	void pesquisarPorEstado() {
		List<Cliente> lista = dao.pesquisarPorEstado("BA");
		for (Cliente cliente : lista) {
			assertEquals("BA", cliente.getEndereco().getCidade().getUf());
		}
	}
	
}

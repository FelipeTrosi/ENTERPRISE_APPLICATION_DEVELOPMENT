package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.DepartamentoDAO;
import br.com.fiap.dao.GerenteDAO;
import br.com.fiap.dao.impl.DepartamentoDAOImpl;
import br.com.fiap.dao.impl.GerenteDAOImpl;
import br.com.fiap.entity.Departamento;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.entity.Gerente;
import br.com.fiap.entity.Nivel;
import br.com.fiap.entity.Status;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class DepartamentoDAOTest {

	private static DepartamentoDAO depDao;
	private static GerenteDAO gerenteDao;

	// M�todo que executa antes de todos os testes
	@BeforeAll
	public static void inicializar() {
		EntityManager em = EntityManagerFactorySingleton
							.getInstance().createEntityManager();
		depDao = new DepartamentoDAOImpl(em);
		gerenteDao = new GerenteDAOImpl(em);
	}

	private Departamento departamento;
	private Gerente gerente;
	
	// M�todo que executa antes de cada teste
	@BeforeEach
	public void cadastrarAntesDosTestes() {
		try {
			gerente = new Gerente("Humberto", Nivel.SENIOR);
			departamento = new Departamento(gerente, "Dev", Status.ATIVO);
			
			Funcionario f1 = new Funcionario("Henrique", 
									Calendar.getInstance(), 1000);
			Funcionario f2 = new Funcionario("Maria",
									Calendar.getInstance(), 500);
			
			departamento.addFuncionario(f1);
			departamento.addFuncionario(f2);
			
			//gerenteDao.cadastrar(gerente);
			depDao.cadastrar(departamento);
			depDao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Errou...");
		}
	}

	@Test
	void busca() {
		try {
			Departamento busca = depDao.pesquisar(departamento.getCodigo());
			
			assertNotNull(busca);
			assertNotNull(busca.getGerente());
			
		} catch (CodigoInexistenteException e) {
			e.printStackTrace();
			fail("Errou...");
		}
	}
	
	@Test
	void cadastro() {
		assertNotEquals(0, gerente.getCodigo());
		assertNotEquals(0, departamento.getCodigo());
	}

}

package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ProfessorDAO;
import br.com.fiap.dao.impl.ProfessorDAOImpl;
import br.com.fiap.entity.Professor;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

class ProfessorDAOTest {

	private static ProfessorDAO dao;
	
	private Professor prof;

	// método que será executado antes de cada teste
	@BeforeEach
	public void arrange() {
		// cadastrar
		prof = new Professor("Parducci", null, "12365545555");

		try {
			dao.cadastrar(prof);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste...");
		}
	}

	// método que será executado antes de todos os testes
	@BeforeAll
	public static void inicializar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();
		dao = new ProfessorDAOImpl(em);
	}

	@Test
	@DisplayName("Teste de cadastro de professor com sucesso")
	void cadastroTest() {
		// Assert - validar o resultado
		// valida se foi gerado um código pela sequence
		assertNotEquals(0, prof.getCodigo());
	}

	@Test
	@DisplayName("Teste de atualização de professor com sucesso")
	public void atualizaTest() {
		// Atualizar o professor
		Professor prof2 = new Professor(prof.getCodigo(), "Rafael", null, "54646");
		try {
			dao.atualizar(prof2);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
		// Assert
		// Pesquisa e valida se o valor foi alterado no banco
		try {
			Professor prof3 = dao.pesquisar(prof2.getCodigo());
			assertEquals("Rafael", prof3.getNome());
			assertEquals(prof2.getCpf(), prof3.getCpf());
		} catch (CodigoInexistenteException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
	}
	
	@Test
	@DisplayName("Teste de pesquisa de professor com sucesso")
	void pesquisaTest() {
		try {
			//Pesquisar o professor
			Professor busca = dao.pesquisar(prof.getCodigo());
			//Assert - validar
			assertNotNull(busca); //encontrou alguem
			assertEquals(busca.getNome(), prof.getNome()); //encontrou o prof correto
		} catch (CodigoInexistenteException e) {
			e.printStackTrace();
			fail("Erro na pesquisa");
		}
	}
	
	@Test
	@DisplayName("Teste de remoção de professor com sucesso")
	void removeTest() {
		//Remove
		try {
			dao.excluir(prof.getCodigo());
			dao.commit();
		} catch (CodigoInexistenteException | CommitException e) {
			e.printStackTrace();
			fail("Falha no teste");
		}
		//Pesquisa e valida se foi excluido
		assertThrows(CodigoInexistenteException.class, 
			()-> dao.pesquisar(prof.getCodigo()));
//		try {
//			Professor pesquisa = dao.pesquisar(prof.getCodigo());
//			fail("Erro no teste");
//		} catch (CodigoInexistenteException e) {
//			//Sucesso			
//		}
		
	}

}








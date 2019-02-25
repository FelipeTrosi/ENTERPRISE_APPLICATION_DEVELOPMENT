package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.dao.impl.EmpresaDAOImpl;
import br.com.fiap.entity.Empresa;

public class TestePesquisar {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		EmpresaDAO dao = new EmpresaDAOImpl(em);
		
		Empresa empresa = dao.pesquisar(3);
		
		System.out.println(empresa.getCodigo());
		System.out.println(empresa.getNomeFantasia());
		System.out.println(empresa.getStatus());
		
		em.close();
		fabrica.close();
	}

}

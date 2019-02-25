package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.dao.impl.EmpresaDAOImpl;
import br.com.fiap.entity.Empresa;
import br.com.fiap.entity.Status;
import br.com.fiap.exception.CommitExeption;

public class TesteCadastro {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em =  fabrica.createEntityManager();
		
		EmpresaDAO dao = new EmpresaDAOImpl(em);
		
		//Cadastrar uma empresa

		Empresa empresa =  new Empresa("PEPE", new GregorianCalendar(1995,Calendar.FEBRUARY,22)
				,Status.INATIVO,"210.348.912/194-00");
		
		try {
			dao.cadastrar(empresa);
			dao.commit();
			System.out.println("Cadastrado com sucesso");
		} catch (CommitExeption e) {
			e.printStackTrace();
			System.err.println("Erro ao cadastrar");
		}
		
		em.close();
		fabrica.close();
	}

}

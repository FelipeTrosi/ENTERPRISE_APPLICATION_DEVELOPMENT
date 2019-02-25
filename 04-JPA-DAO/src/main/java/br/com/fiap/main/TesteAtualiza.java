package br.com.fiap.main;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.dao.impl.EmpresaDAOImpl;
import br.com.fiap.entity.Empresa;
import br.com.fiap.entity.Status;

public class TesteAtualiza {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();

		EmpresaDAO dao = new EmpresaDAOImpl(em);
		
		Empresa empresa = new Empresa (4, "AMERICANAS", Calendar.getInstance(),Status.ATIVO,"210.348.912/194-00");
		
		try {
			dao.atualizar(empresa);
			dao.commit();
			System.out.println("Atualizado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao atualizar");
		}
		
		em.close();
		fabrica.close();
	}

}

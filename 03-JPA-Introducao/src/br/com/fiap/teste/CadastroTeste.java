package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Genero;

public class CadastroTeste {

	public static void main(String[] args) {
		//Criar um gerenciador de entidades
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
	
		//Depois a fabrica cria um entityManager
		EntityManager em = fabrica.createEntityManager();
		
		Cliente cliente = new Cliente("Jubileu", new GregorianCalendar(1990,Calendar.FEBRUARY,4)
				,"141-236-659.99", Genero.MASCULINO, true);
		
		//Cadastrar o cliente
		em.persist(cliente);
		
		//Abre uma transação e finaliza com commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
}

package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Estado;
import br.com.fiap.entity.Produto;

public class Exercicio {
	
	public static void main(String[] args) {
		 
		//Realizar o CRUD para produto
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//Cadastrar
		Produto produto = new Produto("Pente", 12, Estado.NOVO, 
				new GregorianCalendar(2050,Calendar.FEBRUARY,11),
				new GregorianCalendar(2018,Calendar.AUGUST,11), 20, null);
		
		em.persist(produto);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		/*//Pesquisar
		em.find(Produto.class, 1);		
		System.out.println(produto.getNome());		
		
		//Atualizar
		
		Produto produto2 = new Produto(1,"Sabão", 21, Estado.NOVO, 
				new GregorianCalendar(2019,Calendar.AUGUST,20),
				new GregorianCalendar(2018,Calendar.AUGUST,20), 19, null);
		
		em.merge(produto2);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Remover
		
		Produto produto3 = em.find(Produto.class, 1);
		em.remove(produto3);
		
		em.getTransaction().begin();
		em.getTransaction().commit();*/
		
	
		em.close();
		fabrica.close();
	}

}

package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> pesquisar() {
		TypedQuery<Cliente> query = em.createQuery("from Cliente",Cliente.class);
		return query.getResultList();
	}

	@Override
	public List<Cliente> pesquisar(String nome) {
		return em.createQuery("from Cliente c where c.nome like ;n",Cliente.class)
				.setParameter("n", "%" + nome + "%")
				.getResultList();
	}

	@Override
	public List<Cliente> pesquisarPorEstado(String estado) {
		return em.createQuery("from Cliente c where c.endereco.cidade.uf = :P",Cliente.class)
				.setParameter("P", estado)
				.getResultList();
	}

	@Override
	public List<Cliente> pesquisarPorDiaReserva(int dias) {
		return em.createQuery("select r.cliente from Reserva r where r.numeroDias = :d",Cliente.class)
				.setParameter("d", dias)
				.getResultList();
	}

}

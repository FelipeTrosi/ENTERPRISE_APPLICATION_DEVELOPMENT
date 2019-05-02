package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.BarcoDAO;
import br.com.fiap.entity.Barco;

public class BarcoDAOImpl extends GenericDAOImpl<Barco, Integer> implements BarcoDAO {

	public BarcoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}

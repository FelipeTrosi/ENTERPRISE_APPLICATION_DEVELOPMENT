package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.entity.Consulta;
import br.com.fiap.entity.ConsultaPk;

public class ConsultaDAOImpl extends GenericDAOImpl<Consulta, ConsultaPk> implements ConsultaDAO {

	public ConsultaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}

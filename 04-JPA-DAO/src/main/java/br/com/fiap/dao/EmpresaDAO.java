package br.com.fiap.dao;

import br.com.fiap.entity.Empresa;
import br.com.fiap.exception.CommitExeption;

public interface EmpresaDAO {
	
	void cadastrar(Empresa empresa);
	
	void atualizar(Empresa empresa);
	
	void excluir(int codigo);
	
	Empresa pesquisar(int codigo);
	
	void commit() throws CommitExeption;
}

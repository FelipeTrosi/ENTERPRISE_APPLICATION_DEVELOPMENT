package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="T_MEDICO")
@Entity
@SecondaryTable(name="T_MEDICO_FINANCEIRO")
public class Medico {
	
	@Id
	@Column(name="nr_crm")	
	private int crm;
	
	@Column(name="nm_medico")
	private String nome;
	
	@Column(table="T_MEDICO_FINANCEIRO", nullable=false, name="vl_salario")
	private float salario;
	
	@Column(table="T_MEDICO_FINANCEIRO", nullable=false,name="nr_conta")
	private int conta;
	
	
	public Medico(int crm, String nome, float salario, int conta) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.salario = salario;
		this.conta = conta;
	}
	
	public int getCrm() {
		return crm;
	}
	public void setCrm(int crm) {
		this.crm = crm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Medico(int crm, String nome) {
		super();
		this.crm = crm;
		this.nome = nome;
	}
	
	public Medico() {
		super();
	}
	public Medico(String nome) {
		this.nome = nome;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}

}

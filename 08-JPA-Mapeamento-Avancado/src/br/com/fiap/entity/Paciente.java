package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="T_PACIENTE")
@Entity
@SequenceGenerator(name="paciente", sequenceName="SEQ_PACIENTE", allocationSize= 1)
public class Paciente {
	
	@Id
	@Column(name="cd_paciente")
	@GeneratedValue(generator="paciente", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_paciente")
	private String nome;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Paciente(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public Paciente() {
		super();
	}
	public Paciente(String nome) {
		this.nome = nome;
	}	
	
}

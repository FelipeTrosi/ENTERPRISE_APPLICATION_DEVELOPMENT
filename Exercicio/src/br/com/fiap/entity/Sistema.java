package br.com.fiap.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_SISTEMA")
@SequenceGenerator(name="sistema",sequenceName="SQ_TAB_SISTEMA",allocationSize=1)
public class Sistema {
	
	@Id
	@Column(name="cod_sistema")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sistema")
	private int codigo;

	@Column(name="nom_sistema")
	private String nome;

	@OneToMany(mappedBy="sistema")
	private List<CasoTeste> casosTestes;
	
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

	public List<CasoTeste> getCasosTestes() {
		return casosTestes;
	}

	public void setCasosTestes(List<CasoTeste> casosTestes) {
		this.casosTestes = casosTestes;
	}

	public Sistema(int codigo, String nome, List<CasoTeste> casosTestes) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.casosTestes = casosTestes;
	}

	public Sistema() {
		super();
	}

	
	
}

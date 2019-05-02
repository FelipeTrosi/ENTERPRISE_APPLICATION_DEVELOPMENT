package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CARRO")
public class Carro extends Veiculo{
	
	@Column(name="nr_roda")
	private int aroRoda;
	
	@Column(name="nr_portas")
	private int numeroPortas;

	public int getAroRoda() {
		return aroRoda;
	}

	public void setAroRoda(int aroRoda) {
		this.aroRoda = aroRoda;
	}

	public int getNumeroPortas() {
		return numeroPortas;
	}

	public void setNumeroPortas(int numeroPortas) {
		this.numeroPortas = numeroPortas;
	}

	public Carro(int velocidade, String nome, int aroRoda, int numeroPortas) {
		super(velocidade, nome);
		this.aroRoda = aroRoda;
		this.numeroPortas = numeroPortas;
	}

	public Carro() {
		super();
	}
				
}

package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="T_BARCO")
public class Barco extends Veiculo{

	@Column(name="vl_pes")
	private int pes;
	
	@Column(name="de_tipo_barco")
	private TipoBarco tipoBarco;

	public int getPes() {
		return pes;
	}

	public void setPes(int pes) {
		this.pes = pes;
	}

	public TipoBarco getTipoBarco() {
		return tipoBarco;
	}

	public void setTipoBarco(TipoBarco tipoBarco) {
		this.tipoBarco = tipoBarco;
	}

	public Barco(int velocidade, String nome, int pes, TipoBarco tipoBarco) {
		super(velocidade, nome);
		this.pes = pes;
		this.tipoBarco = tipoBarco;
	}

	public Barco() {
		super();
	}
	
	
}

package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CONSULTA")
@IdClass(ConsultaPk.class)
public class Consulta {
	
	@Id
	@Column(name="cd_consulta")
	@GeneratedValue(generator="consulta", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="consulta" ,sequenceName="SEQ_CIDADE", allocationSize=1)
	private int codigo;
	
	@Column(name="dt_consulta")
	private Calendar dataConsulta;
	
	@Column(name="ds_tipo")
	private String tipo;
	
	@Id
	@ManyToOne
	@JoinColumn(name="nr_crm")
	private Medico medico;
	
	@Id
	@ManyToOne
	@JoinColumn(name="cd_paciente")
	private Paciente paciente;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Consulta(int codigo, Calendar dataConsulta, String tipo, Medico medico, Paciente paciente) {
		super();
		this.codigo = codigo;
		this.dataConsulta = dataConsulta;
		this.tipo = tipo;
		this.medico = medico;
		this.paciente = paciente;
	}
	
	public Consulta(Calendar dataConsulta, String tipo, Medico medico, Paciente paciente) {
		super();
		this.dataConsulta = dataConsulta;
		this.tipo = tipo;
		this.medico = medico;
		this.paciente = paciente;
	}
	
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Calendar getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(Calendar dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Consulta(Calendar dataConsulta, String tipo) {
		super();
		this.dataConsulta = dataConsulta;
		this.tipo = tipo;
	}
	
	public Consulta() {
		super();
	}
		
}

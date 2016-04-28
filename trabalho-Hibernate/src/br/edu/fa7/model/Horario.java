package br.edu.fa7.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "horario")
public class Horario extends BaseModel {

	private static final long serialVersionUID = -5366628231248555232L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_horario")
	private int seqHorario;

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Column(name = "tipoHorario")
	@Basic(optional = false)
	private String horario;

	public int getSeqCargo() {
		return seqHorario;
	}

}

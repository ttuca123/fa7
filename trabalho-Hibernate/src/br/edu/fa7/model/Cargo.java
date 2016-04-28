package br.edu.fa7.model;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo extends BaseModel {

	private static final long serialVersionUID = -5366628231248555232L;

	private Cargo() {

	}

	public Cargo(String nome, Double salario) {
		this.nome = nome;
		this.salario = salario;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_cargo")
	private int seqCargo;

	@Column(name = "nome", unique = true)
	private String nome;

	@Column(name = "salario")
	@Basic(optional = false)
	private Double salario;

	public int getSeqCargo() {
		return seqCargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

}

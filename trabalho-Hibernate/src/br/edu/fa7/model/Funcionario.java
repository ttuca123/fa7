/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.fa7.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "funcionario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Funcionario extends BaseModel {

	/**
	 * 
	 */
	
	
	
	private static final long serialVersionUID = -6563846797910943364L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "matricula")
	private int matricula;

	@Column(name = "nome", nullable = false)
	protected String nome;

	@Column(name = "cpf", unique = true, nullable = false)
	@Basic(optional = false)
	protected Long cpf;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_registro", nullable = false)
	@Basic(optional = true)
	protected Date dataRegistro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_alteracao")
	@Basic(optional = true)
	protected Date dataAlteracao;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, optional = false, targetEntity = Cargo.class)
	@JoinColumn(name = "func_cargo")
	protected Cargo cargo;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, optional = true)
	@JoinColumn(name = "func_horario")
	protected Horario horario;

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public int getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

}
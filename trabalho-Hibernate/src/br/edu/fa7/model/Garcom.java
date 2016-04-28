/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.fa7.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Garcom extends Funcionario {

	public Garcom() {

	}

	public Garcom(String nome, Long cpf, Cargo cargo) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataRegistro = new Date();
		this.cargo = cargo;
	}

	private static final long serialVersionUID = -5366628231248555232L;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY, targetEntity = Mesa.class)
	@JoinTable(name = "garcom_mesa", joinColumns = @JoinColumn(name = "matricula", referencedColumnName = "matricula", nullable = false, table = "garcom"), inverseJoinColumns = @JoinColumn(name = "seq_mesa", referencedColumnName = "seq_mesa", nullable = false, table = "mesa"))
	private Collection<Mesa> mesas;

	public Collection<Mesa> getMesas() {

		if (mesas == null) {
			mesas = new ArrayList<Mesa>();
		}
		return mesas;
	}

	public void setMesas(Collection<Mesa> mesas) {
		this.mesas = mesas;
	}

}
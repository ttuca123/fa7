package br.edu.fa7.loja.vo;

import java.io.Serializable;

public class ClienteVO implements Serializable {

	private static final long serialVersionUID = 6311392315811950275L;

	private Long id;

	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

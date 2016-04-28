package br.com.web.vo;

import br.com.cursoweb.util.Cep;

/**
 * 
 * @author Artur
 *
 */
public class Usuario {

	private Long id;

	private String nomeReal;
	private Cep cep;

	public Cep getCep() {
		return cep;
	}

	public void setCep(Cep cep) {
		this.cep = cep;
	}

	public Usuario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeReal() {
		return nomeReal;
	}

	public void setNomeReal(String nomeReal) {
		this.nomeReal = nomeReal;
	}

	private int status = 0;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}

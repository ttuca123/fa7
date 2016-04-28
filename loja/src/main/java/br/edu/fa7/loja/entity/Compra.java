package br.edu.fa7.loja.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compras")
public class Compra implements Serializable {

	private static final long serialVersionUID = 6187403988814259517L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "seq_cliente", nullable = false)
	private Long seqCliente;

	@ManyToMany(fetch = FetchType.LAZY)
	private Collection<Produto> produtos;

	public Long getSeqCliente() {
		return seqCliente;
	}

	public void setSeqCliente(Long seqCliente) {
		this.seqCliente = seqCliente;
	}

	public Collection<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}

	public Long getId() {

		return id;
	}

}

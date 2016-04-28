package br.edu.fa7.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_cardapio")
public class ItemCardapio extends BaseModel {

	private static final long serialVersionUID = -5366628231248555232L;

	private ItemCardapio() {

	}

	public ItemCardapio(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_item")
	private int seqItem;

	@Column(name = "nome", unique = true, nullable = false)
	private String nome;

	@Column(name = "preco", nullable = false)
	private Double preco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getSeqItem() {
		return seqItem;
	}

}
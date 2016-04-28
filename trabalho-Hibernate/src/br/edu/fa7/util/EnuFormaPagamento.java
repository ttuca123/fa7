package br.edu.fa7.util;

public enum EnuFormaPagamento {

	A_VISTA(1, "Pagamento á vista"), CARTAO(2, "Pagamento á cartão");

	private String descricao;
	private int id;

	EnuFormaPagamento(int id, String descricao) {

		this.id = id;
		this.descricao = descricao;
	}

	public String getTipo() {
		return descricao;
	}

	public int getId() {
		return id;
	}
}

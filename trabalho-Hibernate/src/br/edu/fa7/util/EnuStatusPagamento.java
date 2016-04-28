package br.edu.fa7.util;

public enum EnuStatusPagamento {

	DEBITO(0, "Conta em débito"), PAGO(1, "Conta paga");

	private String tipo;
	private int id;

	EnuStatusPagamento(int id, String descricao) {

		this.id = id;
		this.tipo = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public int getId() {
		return id;
	}
}

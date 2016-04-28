package br.edu.fa7.util;

public enum EnuHorario {

	TURNO1(1, "10:00 - 18:30"), TURNO2(2, "16:00 - 00:00");

	private String descricao;
	private int id;

	EnuHorario(int id, String descricao) {

		this.id = id;
		this.descricao = descricao;
	}

	public String getPeriodo() {
		return descricao;
	}

	public int getId() {
		return id;
	}
}

package br.edu.fa7.loja.exception;

public class RegistroNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7009389568993559191L;

	public RegistroNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

	public RegistroNotFoundException(String mensagem) {
		super(mensagem);
	}

}

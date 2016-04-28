package br.fa7.spring.tf.exception;

public class ClienteNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7009389568993559191L;

	public ClienteNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

	public ClienteNotFoundException(String mensagem) {
		super(mensagem);
	}

}

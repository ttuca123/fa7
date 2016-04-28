package br.edu.fa7.exe1;

import javax.ejb.Remote;

@Remote
public interface HelloWorld {

	public String getConcatenacao(String texto);
}

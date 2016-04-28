package br.edu.fa7.exe1;

import javax.ejb.Stateless;

@Stateless(name = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getConcatenacao(String texto) {

		return "texto concatenado com " + texto;
	}

}

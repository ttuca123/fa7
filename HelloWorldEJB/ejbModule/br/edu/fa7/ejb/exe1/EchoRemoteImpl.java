package br.edu.fa7.ejb.exe1;

import javax.ejb.Stateless;

@Stateless(name = "EchoRemote")
public class EchoRemoteImpl implements EchoRemote {

	@Override
	public String echo(String texto) {

		return texto;

	}

}

package br.edu.fa7.ejb.exe1;

import javax.ejb.Remote;


@Remote
public interface EchoRemote {

	public String echo(String texto);
}

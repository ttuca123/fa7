package br.edu.fa7.test;

import javax.naming.NamingException;

import org.junit.Assert;
import org.junit.Test;

import br.edu.fa7.ejb.exe1.EchoRemote;
import br.edu.fa7.ejb.exe2.Calculadora;

public class TestUnit {

	@Test
	public void testExe1() throws NamingException {

		EchoRemote retorno = JNDIUtils
				.lookup("ejb:HelloWorld/HelloWorldEJB/EchoRemote!br.edu.fa7.ejb.exe1.EchoRemote");

		String teste = retorno.echo("teste");
		Assert.assertEquals("teste", teste);

	}

	@Test
	public void testSomarExe2() throws NamingException {

		Calculadora calculadora = (Calculadora) JNDIUtils
				.lookup("ejb:HelloWorld/HelloWorldEJB/Calculadora!br.edu.fa7.ejb.exe2.Calculadora");

		int resultado = calculadora.somar(2, 2);

		Assert.assertEquals(4, resultado);

	}

}

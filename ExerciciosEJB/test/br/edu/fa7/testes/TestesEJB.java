package br.edu.fa7.testes;

import javax.jms.JMSException;
import javax.naming.NamingException;

import org.junit.Test;

import br.edu.fa7.ejb.utils.JNDIUtils;
import br.edu.fa7.exe1.HelloWorld;
import br.edu.fa7.exe2.EmployeService;

public class TestesEJB {

	@Test
	public void test1() throws NamingException {

		HelloWorld hello = JNDIUtils
				.lookup("ejb:/ExerciciosEJB/HelloWorld!br.edu.fa7.exe1.HelloWorld");

		System.out.println(hello.getConcatenacao("artur"));
	}

	@Test
	public void test2() throws NamingException, JMSException {

		for (int i = 0; i < 10; i++) {
			EmployeService employe = (EmployeService) JNDIUtils
					.lookup("ejb:/ExerciciosEJB/EmployeService!br.edu.fa7.exe2.EmployeService");

			employe.queueImportItems(null);
		}
	}

}

package br.edu.fa7.ejb;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;
import javax.jms.JMSException;
import javax.naming.NamingException;

import br.edu.fa7.spring.exercicio1.Employe;

@Remote
public interface EmployeService {

	public void queueImportItems(List<Map<String, Object>> items)
			throws JMSException, NamingException;

	public Employe find(Long id);
}

package br.edu.fa7.exe2;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;
import javax.jms.JMSException;
import javax.naming.NamingException;

@Remote
public interface EmployeService {

	public void queueImportItems(List<Map<String, Object>> items) throws JMSException, NamingException;
}

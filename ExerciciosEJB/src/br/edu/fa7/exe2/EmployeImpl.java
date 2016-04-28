package br.edu.fa7.exe2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

@Stateless(name = "EmployeService")
public class EmployeImpl implements EmployeService {

	@Resource(name = "java:/jms/EmployeeQueue")
	private Queue queue;

	@Resource(name = "java:/ConnectionFactory")
	private ConnectionFactory connection;

	public void postList(List<EmployeService> list) throws JMSException {

		Connection con = connection.createConnection();

		Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);

		MessageProducer producer = session.createProducer(queue);

		ObjectMessage objMessage = session.createObjectMessage();

		objMessage.setObject((Serializable) list);
		Random gerar = new Random();
		Integer numero = gerar.nextInt();
		objMessage.setIntProperty("valor", numero);
		
		producer.send(objMessage);

		con.close();
	}

	@Override
	public void queueImportItems(List<Map<String, Object>> items)
			throws JMSException {

		List<EmployeService> list = new ArrayList<EmployeService>();

		// for (Map<String, Object> item : items) {
		//
		//
		//
		// }

		postList(list);
	}

}

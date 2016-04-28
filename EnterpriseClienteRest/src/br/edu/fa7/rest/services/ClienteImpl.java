package br.edu.fa7.rest.services;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.persistence.EntityManager;

import br.edu.fa7.rest.entities.Cliente;

@Stateless(name = "ClienteService")
public class ClienteImpl implements ClienteService {

	@Resource(name = "java:/ConnectionFactory")
	private ConnectionFactory connection;

	@Resource(name = "unidadePersistencia")
	EntityManager em;

	@Override
	public void save(Cliente cliente) {

		em.getTransaction().begin();

		Cliente cli = em.find(Cliente.class, new Integer(1));

		em.getTransaction().commit();

	}

	@Override
	public void delete(Long cpf) {
		// TODO Auto-generated method stub

	}

	@Override
	public void change(Long cpf) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cliente getCliente(Long cpf) {
		// TODO Auto-generated method stub
		return null;
	}

}

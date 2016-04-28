package br.edu.fa7.spring.tf.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fa7.spring.tf.entity.Cliente;
import br.edu.fa7.spring.tf.entity.Endereco;
import br.fa7.spring.tf.exception.ClienteNotFoundException;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private EntityManager em;

	@Override
	public List<Cliente> getClientes() {

		List<Cliente> clientes = (List<Cliente>) em.createQuery(
				"From Cliente c").getResultList();

		for (Cliente cliente : clientes) {

			cliente.setEnderecos(getEnderecos(cliente.getId()));

		}

		return clientes;
	}

	@Override
	public Cliente getCliente(Long id) {
		Cliente cliente = em.find(Cliente.class, id);

		if (cliente != null) {
			cliente.setEnderecos(getEnderecos(cliente.getId()));
		}
		return cliente;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> getEnderecos(Long idUser) {

		String consulta = "Select c.enderecos from Cliente c where c.id=:idUser";

		return ((List<Endereco>) em.createQuery(consulta)
				.setParameter("idUser", idUser).getResultList());
	}

	@Override
	@SuppressWarnings("unchecked")
	public Endereco getEndereco(Long idUser, Long idEndereco) {
		String consulta = "Select c.enderecos from Cliente c where c.id =:idUser";

		List<Endereco> enderecos = (List<Endereco>) em.createQuery(consulta)
				.setParameter("idUser", idUser).getResultList();
		Endereco endereco = null;

		for (Endereco address : enderecos) {
			if (address.getId() == idEndereco) {
				endereco = address;
				break;
			}

		}

		return endereco;
	}

	@Override
	@Transactional
	public void inserir(Cliente cliente) {

		em.persist(cliente);

	}

	@Override
	@Transactional
	public Cliente atualizar(Cliente cliente) {
		Cliente cBD = getCliente(cliente.getId());
		if (cBD != null) {
			cBD.setNome(cliente.getNome());
			cBD.setEmail(cliente.getEmail());
			cBD.setLogin(cliente.getLogin());
			cBD.setEnderecos(cliente.getEnderecos());
			return em.merge(cBD);
		}
		throw new ClienteNotFoundException(String.format(
				"Cliente de id '%d' não encontrado", cliente.getId()));
	}

	@Override
	@Transactional
	public void removerCliente(Long id) {
		Cliente cBD = getCliente(id);
		if (cBD != null) {

			em.remove(cBD);

		} else {
			throw new ClienteNotFoundException(String.format(
					"Cliente de id '%d' não encontrado", id));
		}

	}

}

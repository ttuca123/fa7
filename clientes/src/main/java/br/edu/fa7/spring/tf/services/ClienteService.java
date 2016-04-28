package br.edu.fa7.spring.tf.services;

import java.util.List;

import br.edu.fa7.spring.tf.entity.Cliente;
import br.edu.fa7.spring.tf.entity.Endereco;

public interface ClienteService {

	/* Busca */
	public List<Cliente> getClientes();

	public Cliente getCliente(Long id);

	public List<Endereco> getEnderecos(Long idUser);

	public Endereco getEndereco(Long idUser, Long idEndereco);

	/* Inserir */
	public void inserir(Cliente cliente);

	/* Atualizar */
	public Cliente atualizar(Cliente cliente);

	/* Deletar */
	public void removerCliente(Long id);

}

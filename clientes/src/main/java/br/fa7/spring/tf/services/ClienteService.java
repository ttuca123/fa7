package br.fa7.spring.tf.services;

import java.util.List;

import br.fa7.spring.tf.entity.Cliente;
import br.fa7.spring.tf.entity.Endereco;

public interface ClienteService {
	
	/* Busca */
	public List<Cliente> buscarTodos();
	
	public Cliente bucarPorId(Long id);
	
	public List<Endereco> getEnderecos(Long idUser);
	
	public Endereco buscarPorId(Long idUser, Long idEndereco);
	
	/* Inserir */
	public void inserir(Cliente cliente);
	
	public void inserir(Endereco endereco, Cliente cliente);
	
	/*Atualizar*/
	public Cliente atualizar(Cliente cliente);
	
	/*Deletar*/
	public void removerCliente(Long id);

	
	
}

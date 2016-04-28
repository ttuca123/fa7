package br.edu.fa7.rest.services;

import javax.ejb.Remote;

import br.edu.fa7.rest.entities.Cliente;

@Remote
public interface ClienteService {

	public void save(Cliente cliente);

	public void delete(Long id);
	
	public void change(Long id);
	
	public Cliente getCliente(Long id);
}

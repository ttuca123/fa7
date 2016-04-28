package br.edu.fa7.spring.tf.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.fa7.spring.tf.entity.Cliente;
import br.edu.fa7.spring.tf.entity.Endereco;
import br.edu.fa7.spring.tf.services.ClienteService;
import br.fa7.spring.tf.exception.ClienteNotFoundException;

@Component
@Path("/clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {

	@Autowired
	private ClienteService cService;

	@GET
	public List<Cliente> buscarTodosClientes() {

		return cService.getClientes();
	}

	@GET
	@Path("/{id}")
	public Response buscarCliente(@PathParam("id") Long id) {
		Cliente cliente = cService.getCliente(id);
		if (cliente == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(cliente).build();
	}

	@GET
	@Path("/{id}/enderecos")
	public List<Endereco> buscarEnderecos(@PathParam("id") Long id) {
		return cService.getEnderecos(id);
	}

	@GET
	@Path("/{id}/enderecos/{eid}")
	public Response buscarEndereco(@PathParam("id") Long id,
			@PathParam("eid") Long eid) {
		Endereco e = cService.getEndereco(id, eid);
		if (e == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(e).build();
	}

	@POST
	public void inserirCliente(List<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			cService.inserir(cliente);
		}
	}

	@PUT
	@Path("{id}")
	public Response atualizar(@PathParam("id") Long id, Cliente cliente) {
		cliente.setId(id);
		try {
			Cliente cliBD = cService.atualizar(cliente);
			return Response.ok(cliBD).build();
		} catch (ClienteNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@DELETE
	@Path("/{id}")
	public Response remover(@PathParam("id") Long id) {
		try {
			cService.removerCliente(id);
			return Response.status(Status.OK).build();
		} catch (ClienteNotFoundException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

}

package br.fa7.spring.tf.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
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

import br.fa7.spring.tf.entity.Cliente;
import br.fa7.spring.tf.entity.Endereco;
import br.fa7.spring.tf.exception.ClienteNotFoundException;
import br.fa7.spring.tf.services.ClienteService;

@Component
@Path("/clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {

	@Autowired
	private ClienteService cService;

	@GET
	public List<Cliente> buscarTodos() {

		return cService.buscarTodos();
	}

	@GET
	@Path("{id}")
	public Response get(@PathParam("id") Long id) {
		Cliente cliente = cService.bucarPorId(id);
		if (cliente == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(cliente).build();
	}

	@GET
	@Path("{id}/enderecos")
	public List<Endereco> buscarTodosEnd(@PathParam("id") Long id) {
		return cService.getEnderecos(id);
	}

	@GET
	@Path("{id}/enderecos/{eid}")
	public Response get(@PathParam("id") Long id, @PathParam("eid") Long eid) {
		Endereco e = cService.buscarPorId(id, eid);
		if (e == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(e).build();
	}

	@POST
	public Cliente inserirCliente(Cliente cliente) {

		System.out.println(cliente.getNome());
		cService.inserir(cliente);
		return cliente;
	}

	// @POST
	// @Path("{id}")
	// public Endereco inserirEndereco(@PathParam("id") Long id, Endereco end,
	// Cliente cli) {
	// cli.setId(id);
	// cService.inserir(end, cli);
	// return end;
	// }
	//
	// @PUT
	// @Path("{id}")
	// public Response atualizar(@PathParam("id") Long id, Cliente cliente) {
	// cliente.setId(id);
	// try {
	// Cliente cliBD = cService.atualizar(cliente);
	// return Response.ok(cliBD).build();
	// } catch (ClienteNotFoundException e) {
	// return Response.status(Status.NOT_FOUND).build();
	// }
	// }
	//
	// @DELETE
	// @Path("{id}")
	// public Response remover(@PathParam("id") Long id) {
	// try {
	// cService.removerCliente(id);
	// return Response.status(Status.OK).build();
	// } catch (ClienteNotFoundException e) {
	// return Response.status(Status.NOT_FOUND).build();
	// }
	// }

}

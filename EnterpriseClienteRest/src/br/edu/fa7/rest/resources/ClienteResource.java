package br.edu.fa7.rest.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.edu.fa7.rest.entities.Cliente;
import br.edu.fa7.rest.services.ClienteService;

@Path("/clientes")
public class ClienteResource {

	@Inject
	ClienteService clienteService;

	@GET
	@Path("{id}")
	public Response get(@PathParam("id") Long id) {

		Cliente cliente = clienteService.getCliente(id);

		if (cliente != null) {
			return Response.accepted(cliente).build();
		} else {

			return Response.status(Status.NOT_FOUND).build();
		}
	}
}

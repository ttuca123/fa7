package br.edu.fa7.loja.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.mashape.unirest.http.exceptions.UnirestException;

import br.edu.fa7.loja.entity.Compra;
import br.edu.fa7.loja.services.CompraService;
import br.edu.fa7.loja.services.ProdutoService;
import br.edu.fa7.loja.vo.ClienteVO;
import br.edu.fa7.loja.vo.CompraVO;

@Path("/compras")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompraResource {

	@EJB
	private CompraService compraService;

	@EJB
	private ProdutoService produtoService;

	@GET
	@Path("/{id}")
	public Response getCompra(@PathParam("id") Long id) {

		Compra compra = compraService.getCompra(id);

		if (compra == null) {

			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok(compra).build();

	}

	@GET
	public Response getCompras() throws Exception {

		List<Compra> compras = compraService.getCompras();

		List<CompraVO> comprasVO = new ArrayList<CompraVO>();

		for (Compra compra : compras) {

			CompraVO compraVO = new CompraVO();

			ClienteVO clienteVO = compraService.getCliente(compra
					.getSeqCliente());

			compraVO.setClienteVO(clienteVO);

			compraVO.setCompra(compra);

			comprasVO.add(compraVO);
			
		}

		if (compras == null || compras.isEmpty()) {

			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok(comprasVO).build();

	}

	@POST
	public void insertCompra(List<Compra> compras) {

		for (Compra compra : compras) {
			compraService.comprar(compra);
		}
	}

}

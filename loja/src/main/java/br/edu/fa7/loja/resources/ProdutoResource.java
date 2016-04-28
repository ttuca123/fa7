package br.edu.fa7.loja.resources;

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

import br.edu.fa7.loja.entity.Produto;
import br.edu.fa7.loja.services.ProdutoService;

@Path("/produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {

	@EJB
	private ProdutoService produtoService;

	@GET
	@Path("/{id}")
	public Response getProduto(@PathParam("id") Long id) {

		Produto produto = produtoService.getProduto(id);

		if (produto == null) {

			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok(produto).build();
	}

	@GET
	public Response getProdutos() {

		List<Produto> produtos = produtoService.getProdutos();

		if (produtos == null) {

			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok(produtos).build();
	}

	@POST
	public void insertProdutos(List<Produto> produtos) {

		for (Produto produto : produtos) {

			produtoService.inserir(produto);
		}

	}

}

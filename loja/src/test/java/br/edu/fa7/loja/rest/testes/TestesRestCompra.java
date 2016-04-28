package br.edu.fa7.loja.rest.testes;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import junit.framework.Assert;

import org.junit.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TestesRestCompra {

	@Test
	public void testInserirCompras() throws UnirestException {

		StringBuilder jsonBuilder = new StringBuilder();
		jsonBuilder.append("[{seqCliente: 1, produtos: [{id: 1	}, {id: 2}]");
		jsonBuilder.append("}, {seqCliente: 2, produtos: [{id: 1}, {id: 2	}]");
		jsonBuilder
				.append("}, {seqCliente: 3, produtos: [{id: 2 }, {id: 2	}] }]");

		JsonNode json = new JsonNode(jsonBuilder.toString());

		HttpResponse<JsonNode> request = Unirest
				.post("http://localhost:8080/loja/rs/compras/")
				.header("accept", "application/json")
				.header("Content-Type", "application/json").body(json).asJson();

		Assert.assertEquals(request.getStatus(), 204);
	}

	@Test
	public void testGetComprasById() throws UnirestException {

		HttpResponse<JsonNode> request = Unirest
				.get("http://localhost:8080/loja/rs/compras/7")
				.header("accept", "application/json")
				.header("Content-Type", "application/json").asJson();

		System.out.println(request.getBody());

		Assert.assertEquals(request.getStatus(), 200);
	}

	/*
	 * Para o testGetCompras, é necessário que a aplicação cliente também esteja
	 * iniciada, pois a requisição será feita para a aplicação cliente a fim de
	 * trazer os dados do cliente,
	 */

	@Test
	public void testGetCompras() throws UnirestException, InterruptedException,
			ExecutionException {

		Future<HttpResponse<JsonNode>> request = Unirest
				.get("http://localhost:8080/loja/rs/compras/")
				.header("accept", "application/json")
				.header("Content-Type", "application/json").asJsonAsync();

		System.out.println(request.get().getBody());

		Assert.assertEquals(request.isDone(), true);

	}

}

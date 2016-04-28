package br.edu.fa7.loja.rest.testes;

import junit.framework.Assert;

import org.junit.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TestesRestProduto {

	@Test
	public void testInserirProdutos() throws UnirestException {

		JsonNode json = new JsonNode(
				"[{nome:produto1, preco: 10.30}, {nome:produto2, preco: 20.00}"
						+ ", {nome:produto3, preco: 30.00}, {nome:produto4, preco: 40.00}, "
						+ "{nome:produto5, preco: 50.00}, {nome:produto6, preco: 60.00}]");

		HttpResponse<JsonNode> request = Unirest
				.post("http://localhost:8080/loja/rs/produtos/")
				.header("accept", "application/json")
				.header("Content-Type", "application/json").body(json).asJson();
		Assert.assertEquals(request.getStatus(), 204);
	}

	@Test
	public void testGetProdutosById() throws UnirestException {

		HttpResponse<JsonNode> request = Unirest
				.get("http://localhost:8080/loja/rs/produtos/1")
				.header("accept", "application/json")
				.header("Content-Type", "application/json").asJson();

		System.out.println(request.getBody());

		Assert.assertEquals(request.getStatus(), 200);
	}

	@Test
	public void testGetProdutos() throws UnirestException {

		HttpResponse<JsonNode> request = Unirest
				.get("http://localhost:8080/loja/rs/produtos/")
				.header("accept", "application/json")
				.header("Content-Type", "application/json").asJson();

		System.out.println(request.getBody());

		Assert.assertEquals(request.getStatus(), 200);
	}

}

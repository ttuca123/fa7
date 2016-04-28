package br.edu.fa7.testes;

import javax.naming.NamingException;

import org.json.JSONArray;
import org.junit.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TestesIntegracao {

	@Test
	public void testGet() throws NamingException, UnirestException {

		HttpResponse<JsonNode> jsonResponse = Unirest
				.get("http://localhost:8080/loja/rs/produtos")

				.header("Content-Type", "application/json").asJson();

		System.out.println(jsonResponse.getBody().toString());

	}

	@Test
	public void testPost() throws NamingException, UnirestException {

		String produto = "produto1";
		Double preco = 10.00;

		HttpResponse<JsonNode> jsonResponse = Unirest
				.post("http://localhost:8080/loja/rs/produtos/{nome}/{preco}")
				.header("accept", "application/json")
				.header("Content-Type", "application/json")
				.queryString("nome", produto).queryString("preco", preco)
				.field("nome", produto).field("preco", preco).asJson();

	}
}

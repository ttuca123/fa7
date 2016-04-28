package br.edu.fa7.cliente.rest.testes;

import org.junit.Assert;
import org.junit.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TestesRestCliente {

	@Test
	public void testInserirClientes() throws UnirestException {

		StringBuilder jsonBuilder = new StringBuilder();
		jsonBuilder.append("[{nome: teste1, email: teste1@terra.com.br,"
				+ "login: teste1.log, enderecos: [{"
				+ "logradouro: Rua Napoleao," + "complemento: 1090,"
				+ "cep: 60070080 }, " + "{logradouro: Rua Das Flores,"
				+ "complemento: 90," + "cep: 60009000}]},");
		jsonBuilder.append("{nome: teste2, email: teste2@gmail.com.br,"
				+ "login: teste2.log, enderecos: [{"
				+ "logradouro: Rua Napoleao," + "complemento: 2090,"
				+ "cep: 60070080}, " + "{logradouro: Rua Do Carmo,"
				+ "complemento: 100," + "cep: 6008090	}]} ,");

		jsonBuilder.append("{nome: teste3, email: teste3@fa7.edu.br,"
				+ "login: teste3.log, enderecos: [{"
				+ "logradouro: Rua Dos Tabajaras," + "complemento: 5878,"
				+ "cep: 60070080}, " + "{logradouro: Rua Das Flores,"
				+ "complemento: 10," + "cep: 6000980	}]}]");

		JsonNode json = new JsonNode(jsonBuilder.toString());

		HttpResponse<JsonNode> request = Unirest
				.post("http://localhost:8082/clientes/")
				.header("accept", "application/json")
				.header("Content-Type", "application/json").body(json).asJson();

		Assert.assertEquals(request.getStatus(), 204);
	}

	@Test
	public void testAtualizarCliente() throws UnirestException {

		StringBuilder jsonBuilder = new StringBuilder();
		jsonBuilder
				.append("{nome: teste1 alterado, email: teste1@terra.com.br,"
						+ "login: teste1.log, enderecos: [{"
						+ "logradouro: Rua Napoleao - Alterado,"
						+ "complemento: 1090," + "cep: 60070080 }, "
						+ "{logradouro: Rua Das Flores," + "complemento: 90,"
						+ "cep: 60009000}]}");

		JsonNode json = new JsonNode(jsonBuilder.toString());

		HttpResponse<JsonNode> request = Unirest
				.put("http://localhost:8082/clientes/1")
				.header("accept", "application/json")
				.header("Content-Type", "application/json").body(json).asJson();

		Assert.assertEquals(request.getStatus(), 200);
	}

	@Test
	public void testGetClientesById() throws UnirestException {

		HttpResponse<JsonNode> request = Unirest
				.get("http://localhost:8082/clientes/1")
				.header("accept", "application/json")
				.header("Content-Type", "application/json").asJson();

		System.out.println(request.getBody());

		Assert.assertEquals(request.getStatus(), 200);
	}

	@Test
	public void testGetClientes() throws UnirestException {

		HttpResponse<JsonNode> request = Unirest
				.get("http://localhost:8082/clientes/")
				.header("accept", "application/json")
				.header("Content-Type", "application/json").asJson();

		System.out.println(request.getBody());

		Assert.assertEquals(request.getStatus(), 200);

	}

	@Test
	public void testGetEnderecosByIdCliente() throws UnirestException {

		HttpResponse<JsonNode> request = Unirest
				.get("http://localhost:8082/clientes/1/enderecos/")
				.header("accept", "application/json")
				.header("Content-Type", "application/json").asJson();

		System.out.println(request.getBody());

		Assert.assertEquals(request.getStatus(), 200);
	}

	@Test
	public void testGetEnderecoByIdClienteByIdEndereco()
			throws UnirestException {

		HttpResponse<JsonNode> request = Unirest
				.get("http://localhost:8082/clientes/1/enderecos/8")
				.header("accept", "application/json")
				.header("Content-Type", "application/json").asJson();

		System.out.println(request.getBody());

		Assert.assertEquals(request.getStatus(), 200);
	}

	@Test
	public void testExcluirCliente() throws UnirestException {

		HttpResponse<JsonNode> request = Unirest
				.delete("http://localhost:8082/clientes/1")
				.header("accept", "application/json")
				.header("Content-Type", "application/json").asJson();

		Assert.assertEquals(request.getStatus(), 200);
	}

}

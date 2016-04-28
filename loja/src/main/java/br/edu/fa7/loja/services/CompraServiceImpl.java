package br.edu.fa7.loja.services;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.fa7.loja.entity.Compra;
import br.edu.fa7.loja.entity.Produto;
import br.edu.fa7.loja.exception.RegistroNotFoundException;
import br.edu.fa7.loja.vo.ClienteVO;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Stateless(name = "CompraService")
public class CompraServiceImpl implements CompraService {

	@PersistenceContext(name = "persistenceUnit")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public Compra getCompra(Long id) {

		Compra compra = em.find(Compra.class, id);

		if (compra != null) {
			String consulta = "select c.produtos from Compra c where c.id=:idCompra";

			List<Produto> produtos = (List<Produto>) em.createQuery(consulta)
					.setParameter("idCompra", compra.getId()).getResultList();

			compra.setProdutos(produtos);
		}
		return compra;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> getCompras() {

		String consulta = "select c from Compra c ";

		List<Compra> compras = em.createQuery(consulta).getResultList();

		for (Compra compra : compras) {
			String subQuery = "select c.produtos from Compra c where c.id=:idCompra";

			compra.setProdutos(em.createQuery(subQuery)
					.setParameter("idCompra", compra.getId()).getResultList());

		}

		return compras;

	}

	@Override
	public void comprar(Compra compra) {

		em.persist(compra);

	}

	public ClienteVO getCliente(Long seqCliente) throws Exception {

		return buscarCliente(seqCliente);
	}

	@Asynchronous
	public ClienteVO buscarCliente(Long seqCLiente) throws Exception {
		String urlStr = "http://localhost:8082/clientes/" + seqCLiente;

		ClienteVO clienteVO = new ClienteVO();

		Future<HttpResponse<JsonNode>> request = Unirest.get(urlStr)
				.header("accept", "application/json")
				.header("Content-Type", "application/json").asJsonAsync();

		Gson gson = new Gson();
		clienteVO = gson.fromJson(request.get().getBody().toString(),
				ClienteVO.class);

		if (clienteVO == null) {
			throw new RegistroNotFoundException("Registro não encontrado");
		}

		return clienteVO;

	}
}

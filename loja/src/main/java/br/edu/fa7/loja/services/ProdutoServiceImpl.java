package br.edu.fa7.loja.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.fa7.loja.entity.Produto;

@Stateless(name = "ProdutoService")
public class ProdutoServiceImpl implements ProdutoService {

	@PersistenceContext(name = "persistenceUnit")
	EntityManager em;

	@Override
	public Produto getProduto(Long id) {

		Produto produto = em.find(Produto.class, id);

		return produto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> getProdutos() {

		return em.createQuery("select p from Produto p").getResultList();
	}

	@Override
	public void inserir(Produto produto) {

		em.persist(produto);

	}

}

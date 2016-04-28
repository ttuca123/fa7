package br.edu.fa7.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import br.edu.fa7.model.ItemCardapio;

public class ItemCardapioDAO extends GenericDao<ItemCardapio> {

	public ItemCardapioDAO() {
		super();

	}

	public void registrarItem(ItemCardapio item) throws Exception {

		super.salvar(item);
	}

	public ItemCardapio getItemCardapio(int codigo) {

		List<Criterion> restricoes = new ArrayList<>();
		restricoes.add(Restrictions.eq("seqItem", codigo));

		return (ItemCardapio) getObject(ItemCardapio.class, restricoes);

	}

	public void excluir(ItemCardapio item) {

		try {
			super.deletar(item);
		} catch (Exception e) {
			System.out.println("Erro ao deletar ítem do Cardápio");
		}
	}

	public List<ItemCardapio> listarTodosEmEstoque() throws Exception {

		List<Criterion> restricoes = new ArrayList<>();
		restricoes.add(Restrictions.eq("heAtivo", Boolean.TRUE));
		restricoes.add(Restrictions.gt("quantidade", 0));

		List<ItemCardapio> itens = listar(ItemCardapio.class, restricoes);

		return itens;

	}

	public List<ItemCardapio> listarTodosItensAtivos() throws Exception {

		return super.listarTodosAtivos(ItemCardapio.class);

	}

	public List<ItemCardapio> listarTodosItens() throws Exception {

		List<ItemCardapio> itens = listar(ItemCardapio.class,
				new ArrayList<Criterion>());

		return itens;

	}

}

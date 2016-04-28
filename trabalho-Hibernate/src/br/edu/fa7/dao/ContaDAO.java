package br.edu.fa7.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import br.edu.fa7.model.Conta;
import br.edu.fa7.model.Mesa;

public class ContaDAO extends GenericDao<Conta> {

	public ContaDAO() {
		super();

	}

	public void encerrarConta(Conta conta) throws Exception {
		
		super.salvar(conta);
	}

	public Mesa buscarByNrMesa(Class bm, int nrMesa) {
		List<Criterion> restricoes = new ArrayList<>();
		restricoes.add(Restrictions.eq("seqMesa", nrMesa));
		restricoes.add(Restrictions.eq("heAtivo", true));

		Mesa mesa = (Mesa) getObject(Mesa.class, restricoes);

		return mesa;

	}

}

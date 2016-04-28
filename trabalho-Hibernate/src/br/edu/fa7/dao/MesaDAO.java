package br.edu.fa7.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import br.edu.fa7.model.Mesa;

public class MesaDAO extends GenericDao<Mesa> {

	public MesaDAO() {
		super();

	}

	public void cadastrarMesa(Mesa mesa) {

		super.salvar(mesa);
	}

		List<Criterion> restricoes = new ArrayList<>();

	public Mesa buscarByNrMesa(int nrMesa) {
		restricoes.add(Restrictions.eq("seqMesa", nrMesa));
		restricoes.add(Restrictions.eq("heAtivo", true));

		Mesa mesa = (Mesa) getObject(Mesa.class, restricoes);

		return mesa;

	}

	public Long buscarByNrPedido(Long nrPedido) {

		String query = "select mp.seq_mesa from mesa_pedido mp where mp.seq_pedido="
				+ nrPedido;
		Integer nrMesa = (Integer) getObject(query); 
		return nrMesa.longValue() ;


	}

}

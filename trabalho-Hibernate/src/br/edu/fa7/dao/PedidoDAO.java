package br.edu.fa7.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import br.edu.fa7.factory.HibernateFactory;
import br.edu.fa7.model.ItemCardapio;
import br.edu.fa7.model.Pedido;

public class PedidoDAO extends GenericDao<Pedido> {

	public PedidoDAO() {
		super();

	}

	public void registrarPedido(Pedido pedido) {

		super.salvar(pedido);
	}

	public List<Pedido> getPedidosByStatus(int status) {

		List<Criterion> restricoes = new ArrayList<>();
		restricoes.add(Restrictions.eq("statusPedido", status));

		List<Pedido> pedidos = listar(Pedido.class, restricoes);

		return pedidos;

	}

	public Pedido buscarPedido(int nrMesa, Long nrPedido) {

		List<Criterion> restricoes = new ArrayList<>();
		restricoes.add(Restrictions.eq("mesa.seqMesa", nrMesa));
		restricoes.add(Restrictions.eq("seqPedido", nrPedido));

		Pedido pedido = (Pedido) getObject(Pedido.class, restricoes);

		return pedido;

	}

	public List<ItemCardapio> getItensPedidoByNrPedido(Pedido pedido)
			throws Exception {

		Criteria criteria = null;

		criteria.add(Restrictions.eq("seqPedido", pedido.getSeqPedido()));
		
		return null;
	}

	public List<Pedido> getPedidosByMesa(Class bm, int nrMesa) throws Exception {
		Session session = HibernateFactory.getHibernateSession();
		session.getTransaction().begin();

		return session.createCriteria(bm).createAlias("mesa", "ms")
				.add(Restrictions.eq("ms.seqMesa", nrMesa))
				.add(Restrictions.eq("statusPedido", 1)).list();

	}

	public List<ItemCardapio> getItensById(Long id) {
		Session session = null;

		List<ItemCardapio> itens = null;

		try {
			session = HibernateFactory.getHibernateSession();

			

			session.getTransaction().begin();

			itens = (List<ItemCardapio>) session.get(ItemCardapio.class, id);

			session.getTransaction().commit();

		} catch (Exception ex) {

		} finally {
			session.close();
		}
		return itens;
	}

	// public List<Pedido> pedidos() throws Exception {
	//
	// return super.listar(Pedido.class);
	// }

}

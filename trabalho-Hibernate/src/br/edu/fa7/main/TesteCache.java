package br.edu.fa7.main;

import org.hibernate.Session;

import br.edu.fa7.factory.HibernateFactory;
import br.edu.fa7.model.Pedido;

public class TesteCache {

	public static void main(String[] args) throws Exception {

		String consulta = "from Pedido p where p.heAtivo = true";

		Session session = HibernateFactory.getHibernateSession();
		session.getTransaction().begin();

		session.createQuery(consulta).setCacheable(true).list();

		session.getTransaction().commit();

		Session session2 = HibernateFactory.getHibernateSession();
		session2.getTransaction().begin();

		session2.createQuery(consulta).setCacheable(true).list();

		session2.get(Pedido.class, 1L);

		session2.getTransaction().commit();

	}
}

package br.edu.fa7.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import br.edu.fa7.factory.HibernateFactory;

public class GenericDao<E> {

	public void salvar(E bm) {
		Session session = null;

		try {

			session = HibernateFactory.getHibernateSession();
			session.getTransaction().begin();
			session.saveOrUpdate(bm);
			session.getTransaction().commit();

			System.out.println("Registro " + bm.getClass().getCanonicalName()
					+ " cadastrado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao inserir/atualizar "
					+ bm.getClass().getCanonicalName());
			e.printStackTrace();

		} finally {

			if (session.isConnected()) {
				session.close();
			}
		}
	}
	
	
	
	public void deletar(E bm) {

		Session session = null;

		try {

			session = HibernateFactory.getHibernateSession();

			session.getTransaction().begin();
			session.delete(bm);
			session.getTransaction().commit();
			System.out.println("Registro " + bm.getClass().getCanonicalName()
					+ " deletado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao excluír " + bm.getClass().getName());
			e.printStackTrace();

		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<E> listarTodosAtivos(Class bm) {

		List objetos = null;
		Session session = null;
		try {
			session = HibernateFactory.getHibernateSession();
			session.getTransaction().begin();

			objetos = session.createCriteria(bm)
					.add(Restrictions.eq("heAtivo", Boolean.TRUE)).list();

			session.beginTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (session.isConnected()) {
				session.close();
			}
		}

		return objetos;

	}

	public List<E> listar(Class bm, List<Criterion> criterios) {

		Session session = null;

		List<E> lista = null;
		try {
			session = HibernateFactory.getHibernateSession();
			session.getTransaction().begin();
			Criteria criteria = session.createCriteria(bm);
			for (Criterion criterio : criterios) {

				criteria.add(criterio);
			}
			lista = criteria.list();

			session.beginTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}

		return lista;

	}

	public Object getObject(Class bm, List<Criterion> criterios) {

		Session session = null;

		Object objeto = null;
		try {
			session = HibernateFactory.getHibernateSession();
			session.getTransaction().begin();
			Criteria criteria = session.createCriteria(bm);
			for (Criterion criterio : criterios) {

				criteria.add(criterio);
			}
			objeto = criteria.uniqueResult();

			session.beginTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (objeto == null) {
				System.out.println("Registro não encontrado!!!");

			}
			if (session.isConnected()) {
				session.close();
			}
		}

		return objeto;

	}

	public Object getObject(String queri) {

		Object objeto = null;
		Session session = null;
		try {
			session = HibernateFactory.getHibernateSession();
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(queri);
			objeto = query.uniqueResult();

			session.beginTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (objeto == null) {
				System.out.println("Registro não encontrado!!!");

			}
			if (session.isConnected()) {
				session.close();
			}
		}
		return objeto;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<E> listarTodosComLimite(Class bm, Integer limite)
			throws Exception {
		Session session = HibernateFactory.getHibernateSession();
		return session
				.createQuery(
						"from " + bm.getName() + " e where e.heAtivo = true")
				.setMaxResults(limite).list();
	}

}

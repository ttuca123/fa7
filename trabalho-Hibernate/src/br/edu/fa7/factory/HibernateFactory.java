package br.edu.fa7.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.edu.fa7.util.AuditInterceptor;

public class HibernateFactory {

	private static SessionFactory sf;

	public static synchronized Session getHibernateSession() throws Exception {
		try {

			if (sf == null) {
				Configuration c = new Configuration();
				c.setInterceptor(new AuditInterceptor());
				sf = c.configure().buildSessionFactory();

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Session s = sf.getCurrentSession();
		return s;
	}
}

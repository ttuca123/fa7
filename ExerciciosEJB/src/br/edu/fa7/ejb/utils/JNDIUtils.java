package br.edu.fa7.ejb.utils;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDIUtils {

	@SuppressWarnings({ "unchecked", "finally" })
	public static <T> T lookup(String name) throws NamingException {

		final Hashtable jndiProperties;
		Context context = null;

		try {
			jndiProperties = new Hashtable();
			jndiProperties.put(Context.URL_PKG_PREFIXES,
					"org.jboss.ejb.client.naming");
			context = new InitialContext(jndiProperties);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			return (T) context.lookup(name);
		}

	}

}

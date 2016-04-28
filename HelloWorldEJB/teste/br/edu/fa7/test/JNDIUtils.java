package br.edu.fa7.test;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDIUtils {

	@SuppressWarnings("unchecked")
	public static <T> T lookup(String name) throws NamingException {

		Hashtable env = new Hashtable();

		env.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

		Context context = new InitialContext(env);

		return (T) context.lookup(name);
	}

}
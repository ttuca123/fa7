package br.edu.fa7.loja.resources;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rs")
public class RestAplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {

		return new HashSet<Class<?>>(Arrays.asList(ProdutoResource.class,
				CompraResource.class));

	}
}

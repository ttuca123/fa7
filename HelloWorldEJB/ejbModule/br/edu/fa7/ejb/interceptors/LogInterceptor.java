package br.edu.fa7.ejb.interceptors;

import java.lang.reflect.Method;
import java.util.Date;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptor {

	@AroundInvoke
	public Object log(InvocationContext ctx) throws Exception {

		Object[] args = ctx.getParameters();
		Method metodo = ctx.getMethod();
		Log(metodo, args);

		return ctx.proceed();
	}

	private void Log(Method metodo, Object[] args) {
		System.out.println(new Date());
		
		System.out.println("Método "+metodo.getName() +"está sendo auditado.");
	}
}

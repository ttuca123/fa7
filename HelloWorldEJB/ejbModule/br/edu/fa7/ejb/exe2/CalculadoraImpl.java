package br.edu.fa7.ejb.exe2;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import br.edu.fa7.ejb.interceptors.LogInterceptor;


@Stateless(name = "Calculadora")
public class CalculadoraImpl implements Calculadora {
	
	
	
	
	@Override
	public int somar(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 + num2;
	}

	@Override
	public int subtrair(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 - num2;
	}

	@Override
	public Double multiplicar(int num1, int num2) {
		Double result = (double) (num1 * num2);
		return result;
	}

	@Override
	public Double dividir(int num1, int num2) {
		Double result = (double) (num1 / num2);
		return result;
	}

}

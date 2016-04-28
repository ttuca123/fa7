package br.edu.fa7.ejb.exe2;

import javax.ejb.Remote;

@Remote
public interface Calculadora {

	public int somar(int num1, int num2);

	public int subtrair(int num1, int num2);

	public Double multiplicar(int num1, int num2);

	public Double dividir(int num1, int num2);

}

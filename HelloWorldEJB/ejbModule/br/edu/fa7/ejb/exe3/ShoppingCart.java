package br.edu.fa7.ejb.exe3;

import javax.persistence.criteria.Order;

public interface ShoppingCart {

	public void process(Order order);
	
}

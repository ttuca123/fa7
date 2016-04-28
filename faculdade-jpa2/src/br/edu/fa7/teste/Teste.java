package br.edu.fa7.teste;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.edu.fa7.model.Pessoa;


public class Teste {

	public static void main(String[] args) throws Exception {
		
		EntityManager em = (EntityManager) Persistence.createEntityManagerFactory("unidadePersistencia").createEntityManager();
		
		// Inicia uma transação
		em.getTransaction().begin();

		Pessoa p = em.find(Pessoa.class, new Integer(1));
		
		p.setCpf("22222");		
		
		System.out.println(p.getIdade());
		
		em.getTransaction().commit();
		
	}
}

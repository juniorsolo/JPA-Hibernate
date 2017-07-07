package br.com.alura.financas.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteConta {

	public static void main(String[] args) {
		
		
		Conta c = new Conta();
		
		c.setAgencia("4521");
		c.setTitular("Leonardo");
		c.setNumero("54265");
		c.setBanco("Caixa Economica");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
		EntityManager em = emf.createEntityManager();
	    
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}

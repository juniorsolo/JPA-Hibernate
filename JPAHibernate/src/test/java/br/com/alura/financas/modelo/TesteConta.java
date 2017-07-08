package br.com.alura.financas.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		
		
		Conta c = new Conta();
		
		c.setAgencia("4521");
		c.setTitular("Danilo");
		c.setNumero("54265");
		c.setBanco("Banco do Brasil");
		
		EntityManager em = new JPAUtil().getEntityManager();
	    
		em.getTransaction().begin();
		em.persist(c);
		c.setBanco("Bradesco Prime");
		em.getTransaction().commit();
		
		em.close();
	
	}

}

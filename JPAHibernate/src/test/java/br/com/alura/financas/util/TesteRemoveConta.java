package br.com.alura.financas.util;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;

public class TesteRemoveConta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 9);
		
		em.remove(conta);
		System.out.println(conta.getTitular());
		em.getTransaction().commit();
		em.close();
		System.out.println(conta.getTitular());
	}

}

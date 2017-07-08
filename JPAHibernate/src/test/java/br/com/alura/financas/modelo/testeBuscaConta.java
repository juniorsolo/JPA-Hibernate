package br.com.alura.financas.modelo;

import javax.persistence.EntityManager;

import br.com.alura.financas.util.JPAUtil;

public class testeBuscaConta {

	public static void main(String[] args) {
	
			EntityManager em = new JPAUtil().getEntityManager();
			
			em.getTransaction().begin();
			
			Conta conta = em.find(Conta.class, 1);
			conta.setAgencia("1234");
			conta.setBanco("104 - CAIXA ECONOMICA FEDERAL");
			System.out.println(conta.getTitular());
			
			em.getTransaction().commit();
			em.close();
			
			EntityManager em2 = new JPAUtil().getEntityManager();
			em2.getTransaction().begin();
			conta.setTitular("Leonardo");
			em2.merge(conta);
			em2.getTransaction().commit();
			em2.close();
	}

}

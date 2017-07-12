package br.com.alura.financas.modelo;

import javax.persistence.EntityManager;

import br.com.alura.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 3);
		Conta conta = movimentacao.getConta();
		
		System.out.println("Titular: " + conta.getTitular());
		System.out.println("Qtd Movimentacoes: " + conta.getMovimentacoes().size());
		
		Conta conta2 = em.find(Conta.class, 2);
		System.out.println("mov conta: " + conta2.getMovimentacoes().size());
		em.getTransaction().commit();
		em.close();

	}

}

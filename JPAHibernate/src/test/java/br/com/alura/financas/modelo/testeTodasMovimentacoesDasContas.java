package br.com.alura.financas.modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.alura.financas.util.JPAUtil;

public class testeTodasMovimentacoesDasContas {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
		
		Query query = em.createQuery(jpql);
		
		List<Conta> todasContas = query.getResultList();
		
		System.out.println("QTD: " + todasContas.size());
		
		for (Conta conta : todasContas) {
			System.out.println("titular: " + conta.getTitular());
			System.out.println("Movimentacoes: ");

			for (Movimentacao mov : conta.getMovimentacoes()) {
				System.out.println("Desc: "+ mov.getDescricao());
			}
		}
		
		em.getTransaction().commit();		
		em.close();

	}

}

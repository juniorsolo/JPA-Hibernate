package br.com.alura.financas.modelo;

import java.text.NumberFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta" +
		" and m.tipo = :pTipo order by m.valor asc";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
		
		List<Movimentacao> resultados = query.getResultList();
		
		NumberFormat format = NumberFormat.getCurrencyInstance();
		
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Conta ID: " + movimentacao.getConta().getId());
			System.out.println("Valor: " + format.format( movimentacao.getValor() ));
			System.out.println("Descrição: " + movimentacao.getDescricao());
			
		}
		
		em.getTransaction().commit();
		em.close();

	}

}

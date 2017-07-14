package br.com.alura.financas.modelo;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :pConta" +
		" and m.tipo = :pTipo order by m.valor asc";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		BigDecimal soma = (BigDecimal) query.getSingleResult();
		
		System.out.println("Soma: " + soma);
		
		em.getTransaction().commit();
		em.close();

	}

}

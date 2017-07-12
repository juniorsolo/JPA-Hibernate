package br.com.alura.financas.modelo;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.util.JPAUtil;

public class TesteMovimentacaoPorCategoria {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(3);
		
		String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> resultados = query.getResultList();
		
		NumberFormat format = NumberFormat.getCurrencyInstance();
		
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Conta ID: " + movimentacao.getConta().getId());
			System.out.println("Valor: " + format.format( movimentacao.getValor() ));
			System.out.println("Descrição: " + movimentacao.getDescricao());
			//System.out.println("Categoria: " + movimentacao.getCategorias().toString());
		}
		
		em.getTransaction().commit();
		em.close();

	}

}

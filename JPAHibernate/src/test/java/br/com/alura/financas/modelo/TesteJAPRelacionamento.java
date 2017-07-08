package br.com.alura.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.alura.financas.util.JPAUtil;

public class TesteJAPRelacionamento {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setAgencia("6668-8");
		conta.setBanco("Bradesco Exclusive");
		conta.setNumero("18662-0");
		conta.setTitular("Rodrigo");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Churracaria fogo de Chão");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("200.0"));
		movimentacao.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		em.close();
		
		
	}

}

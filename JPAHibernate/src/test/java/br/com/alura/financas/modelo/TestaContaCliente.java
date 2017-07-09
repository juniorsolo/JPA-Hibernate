package br.com.alura.financas.modelo;

import javax.persistence.EntityManager;

import br.com.alura.financas.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {
		
		Conta  conta = new Conta();
		conta.setId(3);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Leonardo");
		cliente.setEndereco("Rua Adamastor, 454");
		cliente.setProfissao("Professor");
		cliente.setConta(conta);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Douglas");
		cliente2.setEndereco("Rua Gouveia, 12");
		cliente2.setProfissao("Professor");
		cliente2.setConta(conta);
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.persist(cliente);
		//em.persist(cliente2);
		
		em.getTransaction().commit();
		em.close();
		
	}

}

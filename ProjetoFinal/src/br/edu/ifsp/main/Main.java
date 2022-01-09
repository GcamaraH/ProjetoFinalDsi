package br.edu.ifsp.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifsp.model.Produto;

public class Principal {
	
	private static EntityManagerFactory eManagerFactory = Persistence.createEntityManagerFactory("BDProjFinal");
	private static EntityManager eManager = eManagerFactory.createEntityManager();

	public static void main(String[] args) {
	
		//Insert
		Produto produto = new Produto();
		produto.setNome("Teclado redragon kumara");
		
		eManager.getTransaction().begin();
		eManager.persist(produto);
		eManager.getTransaction().commit();
		
		//Search
		Produto produto = eManager.find(Produto.class, 1);
		System.out.println("Produto:" + produto.getNome());

		//Update
		Produto produto = new Produto();
		produto.setId(1);
		produto.setNome("Mouse redragon cobra");

		//Delete
		Produto produto = eManager.find(Produto.class, 2);
		eManager.getTransaction().begin();
		eManager.remove(produto);
		eManager.getTransaction().commit();
		
		eManager.getTransaction().begin();
		eManager.merge(produto);
		eManager.getTransaction().commit();

		eManager.close();
		eManagerFactory.close();
		
	}
	
}


package br.ufc.crateus.os.utils.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerPersistence {

	private static EntityManagerFactory emf;
	
	public static void init() {
		emf = Persistence.createEntityManagerFactory("SisOS");
	}
	
	public static EntityManagerFactory getEmf() {
		return emf;
	}
	
	public static EntityManager getEntityManager() {
		
		if(emf == null) {
			throw new IllegalStateException("Problema com JPA.");
		}
		
		return emf.createEntityManager();
	}
	
	public static void close() {
		emf.close();
	}
}

package br.ufc.crateus.os.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.crateus.os.model.Cliente;
import br.ufc.crateus.os.model.OS;

public class OSRepository implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public OSRepository(EntityManager manager) {
		
		this.manager = manager;
	}
	
	public List<OS> listOS(){
		
		TypedQuery<OS> query = manager.createQuery("from OS", OS.class);
		return query.getResultList();
	}
	
	public void addOS(OS os) {
		manager.merge(os);
	}
	
	public OS osById(int id) {
		return manager.find(OS.class, id);
	}
	
	public void delete(OS os) {
		manager.remove(manager.getReference(OS.class, os.getId()));
	}
	
}

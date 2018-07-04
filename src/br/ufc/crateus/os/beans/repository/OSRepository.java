package br.ufc.crateus.os.beans.repository;

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
	
	public void addCliente(OS os) {
		manager.merge(os);
	}
	
	public OS OsById(int id) {
		return manager.find(OS.class, id);
	}
	
	public void delete(Cliente cliente) {
		manager.remove(manager.getReference(Cliente.class, cliente.getId()));
	}
	
}

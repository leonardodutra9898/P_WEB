package br.ufc.crateus.os.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.crateus.os.model.Cliente;

public class ClienteRepository implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static EntityManager manager;
	
	public ClienteRepository(EntityManager manager) {
		
		ClienteRepository.manager = manager;
	}
	
	public List<Cliente> listClientes(){
		
		TypedQuery<Cliente> query = manager.createQuery("from Cliente", Cliente.class);
		return query.getResultList();
	}
	
	public void addCliente(Cliente cliente) {
		manager.merge(cliente);
	}
	
	public Cliente clienteById(int id) {
		return manager.find(Cliente.class, id);
	}
	
	public static Cliente getClienteById(int id) {
		return manager.find(Cliente.class, id);
	}
	
	public void delete(Cliente cliente) {
		manager.remove(manager.getReference(Cliente.class, cliente.getId()));
	}
	
}

package br.ufc.crateus.os.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.crateus.os.model.Funcionario;

public class FuncionarioRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public FuncionarioRepository(EntityManager manager) {
		
		this.manager = manager;
	}
	
	public List<Funcionario> listFuncionarios(){
		
		TypedQuery<Funcionario> query = manager.createQuery("from Funcionario", Funcionario.class);
		return query.getResultList();
	}
	
	public void addFuncionario(Funcionario funcionario) {
		manager.merge(funcionario);
	}
	
	public Funcionario funcionarioById(int id) {
		return manager.find(Funcionario.class, id);
	}
	
	public void delete(Funcionario funcionario) {
		manager.remove(manager.getReference(Funcionario.class, funcionario.getId()));
	}

}

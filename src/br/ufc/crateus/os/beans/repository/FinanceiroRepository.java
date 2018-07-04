package br.ufc.crateus.os.beans.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.crateus.os.model.Financeiro;

public class FinanceiroRepository implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private EntityManager manager;
	
	public FinanceiroRepository(EntityManager manager) {
		
		this.manager = manager;
	}
	
	public List<Financeiro> listLancamentosFinanceiro(){
		
		TypedQuery<Financeiro> query = manager.createQuery("from Financeiro", Financeiro.class);
		return query.getResultList();
	}
	
	public void addFinanceiro(Financeiro financeiro) {
		manager.merge(financeiro);
	}
	
	public Financeiro financeiroById(int id) {
		return manager.find(Financeiro.class, id);
	}
	
	public void delete(Financeiro financeiro) {
		manager.remove(manager.getReference(Financeiro.class, financeiro.getId()));
	}

}

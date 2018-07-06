package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.ufc.crateus.os.enums.FinanceiroEnum;
import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.model.Cliente;
import br.ufc.crateus.os.model.Financeiro;
import br.ufc.crateus.os.model.OS;
import br.ufc.crateus.os.repository.FinanceiroRepository;
import br.ufc.crateus.os.utils.dao.EntityManagerPersistence;
import br.ufc.crateus.os.utils.messages.MessagesUtils;


@Named
@ManagedBean(name="finBean")
@ApplicationScoped
public class FinanceiroBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Financeiro> financeiroList;
	private Financeiro financeiro;
	private Financeiro financeiroEdit;
	private Financeiro nFinanceiro;
	
	private Cliente clienteSetado;
	private OS osSetado;
	
	MessagesUtils msgUtils;
	
	public void novoLancamentoFinanceiro() {

		EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		try {
			manager.getTransaction().begin();
			FinanceiroRepository finRepo = new FinanceiroRepository(manager);
			
			finRepo.addFinanceiro(nFinanceiro);
			financeiroList = finRepo.listLancamentosFinanceiro();
			nFinanceiro = new Financeiro();
			msgUtils = new MessagesUtils("Registro Salvo", "Novo lançamento financeiro Registrado!", MessagesTypes.SUCCESS);
			
			manager.getTransaction().commit();
			
		}catch(Exception e) {
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Erro ao tentar salvar registro", ("Erro: " + e.toString()), 
					MessagesTypes.ERROR);
		} finally {
			manager.close();
		}
	}
	
	public FinanceiroBean() {
		
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		FinanceiroRepository finRepo = new FinanceiroRepository(manager);
		financeiroList = finRepo.listLancamentosFinanceiro();

		financeiro = new Financeiro();
		financeiroEdit = new Financeiro();
		nFinanceiro = new Financeiro();
		manager.close();
	}
	
	public Financeiro searchById() {
		
			for(Financeiro f : financeiroList) {
				
					if(f.getId() == financeiro.getId()) {
						return f;
					}
			}

		return null;
	}


	public String financeiroById(Financeiro financeiro) {

		EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		try {
		
			FinanceiroRepository finRepo = new FinanceiroRepository(manager);
			manager.getTransaction().begin();
			Financeiro temp = finRepo.financeiroById(financeiro.getId());
			financeiroEdit = temp;
			
		}catch(Exception e) {
			System.out.println("Erro ao tentar consultar financeiro individual");
		}finally {
			manager.close();
		}
				
		return "/financeiro/editFinanceiro?faces-redirect-true";
	}

	public void excluirLancamentoFinanceiro() {

EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		try {
			
			manager.getTransaction().begin();
			FinanceiroRepository finRepo = new FinanceiroRepository(manager);
			finRepo.financeiroById(financeiro.getId());
			finRepo.delete(financeiro);
			
			manager.getTransaction().commit();

			msgUtils = new MessagesUtils("Lançamento financeiro excluido...", "Lançamento removido", 
					MessagesTypes.SUCCESS);
					
			financeiroList = finRepo.listLancamentosFinanceiro();
			financeiro = new Financeiro();
			
		}catch(Exception e) {
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Lançamento não pode ser excluido...", ("Lançamento não removido... " + e.toString()), 
					MessagesTypes.ERROR);
		} finally {
			manager.close();
		}
	}
	
	public void atualizarFinanceiro() {
		
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		try {
			
			manager.getTransaction().begin();
			FinanceiroRepository finRepo = new FinanceiroRepository(manager);
			finRepo.addFinanceiro(financeiroEdit);
			financeiroList = finRepo.listLancamentosFinanceiro();
			
			financeiroEdit = new Financeiro();
			msgUtils = new MessagesUtils("Atualização realizada com sucesso em Finanças...", "Atualização concluída", 
					MessagesTypes.SUCCESS);
			
			manager.getTransaction().commit();
						
		}catch(Exception e) {
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Erro ao tentar atualizar lançamento financeiro...", ("Erro ao atualizar... " + e.toString()), 
					MessagesTypes.ERROR);
		} finally {
			manager.close();
		}
	}

	public Financeiro getFinanceiro() {
		return financeiro;
	}

	public void setFinanceiro(Financeiro financeiro) {
		this.financeiro = financeiro;
	}

	public List<Financeiro> getFinanceiroList() {
		return financeiroList;
	}

	public Financeiro getFinanceiroEdit() {
		return financeiroEdit;
	}

	public void setFinanceiroEdit(Financeiro financeiroEdit) {
		this.financeiroEdit = financeiroEdit;
	}

	public Financeiro getnFinanceiro() {
		return nFinanceiro;
	}

	public void setnFinanceiro(Financeiro nFinanceiro) {
		this.nFinanceiro = nFinanceiro;
	}
	
	public FinanceiroEnum[] getStatus() {
		return FinanceiroEnum.values();
	}

	public Cliente getClienteSetado() {
		return clienteSetado;
	}

	public void setClienteSetado(Cliente clienteSetado) {
		this.clienteSetado = clienteSetado;
	}

	public OS getOsSetado() {
		return osSetado;
	}

	public void setOsSetado(OS osSetado) {
		this.osSetado = osSetado;
	}
	
	
}

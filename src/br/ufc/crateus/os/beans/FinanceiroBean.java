package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.model.Cliente;
import br.ufc.crateus.os.model.Financeiro;
import br.ufc.crateus.os.utils.messages.MessagesUtils;


@Named
@ManagedBean(name="finBean")
@ApplicationScoped
public class FinanceiroBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int count = 0;

//	private List<SelectItem> listClientesSelectOneMenu;
	
	private Cliente cliente;
	private List<Financeiro> financeiroList;
	private Financeiro financeiro;
	
	MessagesUtils msgUtils;
	
	public void novoLancamentoFinanceiro() {
		
		if(isEditar()) {
			atualizarFinanceiro();
		}else {
			financeiro.setId(++count);
			financeiroList.add(financeiro);
			
			financeiro = new Financeiro();
		
			msgUtils = new MessagesUtils("Registro Salvo", "Novo Cliente Registrado!", MessagesTypes.SUCCESS);
		}
	}
	
	public FinanceiroBean() {

		financeiroList = new ArrayList<>();
		cliente = new Cliente();
		financeiro = new Financeiro();
	}
	
	public Financeiro searchById() {
		
			for(Financeiro f : financeiroList) {
				
					if(f.getId() == financeiro.getId()) {
						return f;
					}
			}

		return null;
	}


	
	public Financeiro getLancamentoFinanceiroById(Integer i) {
		
		for(Financeiro f : financeiroList) {
			
				if(f.getId() == i) {
					return f;
				}
		}

	return null;
	}

	public String financeiroById(Financeiro financeiro) {
		
		for(Financeiro f : financeiroList) {
			if(f.getId() == financeiro.getId()) {
				financeiro = f;
			}
		}
		
		return "/financeiro/newFinanceiro?faces-redirect-true";
	}

	public void excluirLancamentoFinanceiro() {
		
		Financeiro finTemp = searchById();
		
		if(finTemp != null) {
			financeiroList.remove(finTemp);
			
			msgUtils = new MessagesUtils("Lançamento financeiro excluido...", "Lançamento removido", MessagesTypes.SUCCESS);
		}		
	}
	
	public void atualizarFinanceiro() {
		
		Financeiro finSearch = searchById();
		
		if(finSearch != null) {
//			finSearch.setNome(clienteSelecionado.getNome());
//			finSearch.setEmail(clienteSelecionado.getEmail());
//			finSearch.setEndereco(clienteSelecionado.getEndereco());
//			finSearch.setCpf(clienteSelecionado.getCpf());
			
			msgUtils = new MessagesUtils("Atualização realizada com sucesso em Finanças...", "Atualização concluída", MessagesTypes.SUCCESS);
		}
		
	}
	
	public boolean isEditar() {
//		return this.financeiro.getId() != null;
		return false;
	}
	
}

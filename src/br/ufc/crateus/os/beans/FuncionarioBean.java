package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.model.Cliente;
import br.ufc.crateus.os.model.Funcionario;
import br.ufc.crateus.os.model.OS;
import br.ufc.crateus.os.utils.messages.MessagesUtils;

@Named
@ManagedBean(name="funcBean")
@ApplicationScoped
public class FuncionarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Funcionario funcionario;
	int count = 0;
	private List<Funcionario> funcionarios;
	private String FUNCAO;
	
	
	MessagesUtils msgUtils;
	
	public FuncionarioBean() {
		funcionario = new Funcionario();
		funcionarios = new ArrayList<Funcionario>();
	}
	
	
	public void novoFunc() {
		
		if(isEditar()) {
			atualizarFuncionario();
		}else {
		
			funcionario.setId(++count);
			funcionarios.add(funcionario);
			funcionario = new Funcionario();
			msgUtils = new MessagesUtils("Registro Salvo", "Funcionário registrado!", MessagesTypes.SUCCESS);
		}
	}

	public OS searchById(int idFunc) {
		return null;
	}
	
	
	public void excluirFunc() {
			System.out.println("excluido");
			funcionarios.remove(funcionario);
			
			msgUtils = new MessagesUtils("Excluído!", "OS", MessagesTypes.INFO);	
		
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}


	public String getFUNCAO() {
		return FUNCAO;
	}


	public void setFUNCAO(String fUNCAO) {
		FUNCAO = fUNCAO;
	}

	public String funcionarioById(Funcionario f) {
		
		for(Funcionario c : funcionarios) {
			if(c.getId() == f.getId()) {
				funcionario = c;
			}
		}
		
		return "/funcionario/newFuncionario?faces-redirect-true";
	}	
	
	public void excluirFuncionario() {
		
		Funcionario fTemp = searchById();
		
		if(fTemp != null) {
			funcionarios.remove(fTemp);
			
			msgUtils = new MessagesUtils("Funcionário excluído...", "Funcionário removido", MessagesTypes.SUCCESS);
		}		
	}
	
	public void atualizarFuncionario() {
		
		Funcionario fSearch = searchById();
		
		if(fSearch != null) {
			fSearch.setNome(funcionario.getNome());
			fSearch.setEmail(funcionario.getEmail());
			fSearch.setFUNCAO(funcionario.getFUNCAO());
			fSearch.setSalario(funcionario.getSalario());
			
			msgUtils = new MessagesUtils("Atualização realizada com sucesso em Funcionário...", "Atualização concluída", MessagesTypes.SUCCESS);
		}
		
	}
	
	public boolean isEditar() {
		return this.funcionario.getId() != null;
	}
	
	public Funcionario searchById() {
		
		for(Funcionario f : funcionarios) {
			
				if(f.getId() == funcionario.getId()) {
					return f;
				}
		}

	return null;
}
	
	public String funcById(Funcionario f) {
		
		for(Funcionario fa : funcionarios) {
			if(fa.getId() == f.getId()) {
				funcionario = fa;
			}
		}
		
		return "/funcionario/newFuncionario?faces-redirect-true";
	}
	
}

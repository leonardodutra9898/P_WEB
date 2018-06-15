package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.enums.Status;
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
	
	MessagesUtils msgUtils;
	
	public FuncionarioBean() {
		funcionario = new Funcionario();
	}
	
	
	public void novoFunc() {
		funcionario.setId(++count);
		funcionario = new Funcionario();
		msgUtils = new MessagesUtils("Registro Salvo", "Nova Ordem de Serviço registrada!", MessagesTypes.SUCCESS);

	}

	public OS searchById(int idFunc) {
		return null;
	}
	
	
	public void excluirFunc() {
			System.out.println("excluido");
		
			msgUtils = new MessagesUtils("Excluído!", "OS", MessagesTypes.INFO);	
		
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
}

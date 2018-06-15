package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.model.Cliente;
import br.ufc.crateus.os.utils.messages.MessagesUtils;

@Named
@ManagedBean(name="cliBean")
@ApplicationScoped
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int count = 0;

	private List<SelectItem> listClientesSelectOneMenu;
	
	private Cliente clienteSelecionado;
	private List<Cliente> clientes;
	
	MessagesUtils msgUtils;
	
	public void novoCliente() {
		
		if(clientes == null) {
			clientes = new ArrayList<Cliente>();
		}
				
		if(clienteSelecionado != null) {
			clienteSelecionado.setId(++count);
			clientes.add(clienteSelecionado);
		}
		
		msgUtils = new MessagesUtils("Registro Salvo", "Novo Cliente Registrado!", MessagesTypes.SUCCESS);
	}
	
	public ClienteBean() {

	}

	
	public void inicializar() {
		clienteSelecionado = new Cliente();
	}


	
	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public Cliente searchById(int idCliente) {
		if(clientes != null) {
			for(Cliente c : clientes) {
				
					if(c.getId() == idCliente) {
						return c;
					}
				
			}
		}

		return null;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void excluirCliente() {
		
		if(getClienteSelecionado().getId() != null && clientes != null) {
			clientes.remove(searchById(getClienteSelecionado().getId()));
			System.out.println("excluido");
		}else {
			msgUtils = new MessagesUtils("Não foi possível remover! Provavelmente objetos vazios...", "Cliente vazio", MessagesTypes.WARNING);	
		}
	}
}

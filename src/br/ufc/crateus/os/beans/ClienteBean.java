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

//	private List<SelectItem> listClientesSelectOneMenu;
	
	private Cliente clienteSelecionado;
	private List<Cliente> clientes;
	
	MessagesUtils msgUtils;
	
	public void novoCliente() {
		
		if(isEditar()) {
			atualizarCliente();
		}else {
			clienteSelecionado.setId(++count);
			clientes.add(clienteSelecionado);
			clienteSelecionado = new Cliente();
		
			msgUtils = new MessagesUtils("Registro Salvo", "Novo Cliente Registrado!", MessagesTypes.SUCCESS);
		}
	}
	
	public ClienteBean() {

		clientes = new ArrayList<>();
		clienteSelecionado = new Cliente();
	}
	
	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public Cliente searchById() {
		
			for(Cliente c : clientes) {
				
					if(c.getId() == clienteSelecionado.getId()) {
						return c;
					}
			}

		return null;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public String clientById(Cliente cliente) {
		
		for(Cliente c : clientes) {
			if(c.getId() == cliente.getId()) {
				clienteSelecionado = c;
			}
		}
		
		return "/cliente/newCliente?faces-redirect-true";
	}
	
//	public Cliente getClientById(Cliente cliente) {
//		Cliente temp = null;
//		for(Cliente c : clientes) {
//			if(c.getId() == cliente.getId()) {
//				temp = c;
//			}
//		}
//		return temp;
//	}
	
	public void excluirCliente() {
		
		Cliente cliTemp = searchById();
		
		if(cliTemp != null) {
			clientes.remove(cliTemp);
			
			msgUtils = new MessagesUtils("Cliente excluído...", "Cliente removido", MessagesTypes.SUCCESS);
		}		
	}
	
	public void atualizarCliente() {
		
		Cliente cliSearch = searchById();
		
		if(cliSearch != null) {
			cliSearch.setNome(clienteSelecionado.getNome());
			cliSearch.setEmail(clienteSelecionado.getEmail());
			cliSearch.setEndereco(clienteSelecionado.getEndereco());
			cliSearch.setCpf(clienteSelecionado.getCpf());
			
			msgUtils = new MessagesUtils("Atualização realizada com sucesso em CLiente...", "Atualização concluída", MessagesTypes.SUCCESS);
		}
		
	}
	
	public boolean isEditar() {
		return this.clienteSelecionado.getId() != null;
	}
}

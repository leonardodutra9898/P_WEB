package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.ufc.crateus.os.model.Cliente;
import br.ufc.crateus.os.service.ClienteService;

@ManagedBean(name="cliBean")
@ApplicationScoped
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Inject
	private ClienteService cliServ;

	private Cliente cliente;
	
	@PostConstruct
	public void init() {
		

	}
	
	public void novoCliente() {
		cliServ.salvar(cliente);
		cliente = new Cliente();
	}
	
	public ClienteBean() {
		cliServ = new ClienteService();
		cliente = new Cliente();		
	}

	public ClienteService getCliServ() {
		return cliServ;
	}

	public void setCliServ(ClienteService cliServ) {
		this.cliServ = cliServ;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}

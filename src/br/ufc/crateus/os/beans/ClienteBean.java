package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.ufc.crateus.os.model.Cliente;
import br.ufc.crateus.os.service.ClienteService;

@ManagedBean(name="cliBean")
@ApplicationScoped
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ClienteService cliServ;
	private Cliente cliente;
	
	@PostConstruct
	public void init() {

		
	}
	
	public void novoCliente() {

		cliServ = new ClienteService();
		cliente = new Cliente();
		cliServ.salvar(cliente);

	}
	
	public ClienteBean() {
		
	}
	
	public void list() {
		
//		for(Cliente c : listClientes) {
			
//			System.out.println(c.getId() + " -- " + c.getDescricao() + " -- " + o.getStatus());
//		}
	}

	public ClienteService getCliServ() {
		return cliServ;
	}

	public void setCliServ(ClienteService cliServ) {
		this.cliServ = cliServ;
	}
	
	
	
}

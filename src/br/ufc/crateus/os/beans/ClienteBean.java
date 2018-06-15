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

//	private ClienteService cliServ;
	int c = 0;
	int count = 0;

//	private List<Cliente> listClientes;
	
	private List<SelectItem> listClientesSelectOneMenu;
	
	private Cliente clienteSelecionado;
	private List<Cliente> clientes;
	
	MessagesUtils msgUtils;
	
	public void novoCliente() {
//		cliServ.salvar();
//		cliente = new Cliente();
		
		
		if(clientes == null) {
			clientes = new ArrayList<Cliente>();
		}
		
		if(clienteSelecionado != null) {
			clienteSelecionado.setId(++count);
			clientes.add(clienteSelecionado);
		}
		
			clienteSelecionado = new Cliente();
		
		
		
		
		
//		listClientes.add(cliente);
		
//		System.out.println("Antes de novo Cliente\n " + cliente.toString());
		
//		System.out.println("\nDepois de novo Cliente\n");
//		System.out.println(cliente.toString());
		
		
		
		msgUtils = new MessagesUtils("Registro Salvo", "Novo Cliente Registrado!", MessagesTypes.SUCCESS);
	}
	
	public ClienteBean() {
//		cliServ = new ClienteService();
//		cliente = new Cliente();
//		listClientes = new ArrayList<Cliente>();
		clienteSelecionado = new Cliente();

	}

	@PostConstruct
	public void inicializar() {

//		if(cliente != null) {
//		System.out.println("###############################");
//		System.out.println("Inicializando valores...");
//		clienteSelecionado = new Cliente();
		
		
//		System.out.println("nome cliente => " + cliente.getNome());
//		System.out.println("Total de objetos cliente: " + cliente.getId());
		System.out.println("chamada =>> " + ++c);
		System.out.println("###############################");
		}
		
//		if(cliente == null) {
//			cliente = new Cliente();
//		}
		
//		cliente = new Cliente();
//	}
	
	
	
//	public ClienteService getCliServ() {
//		return cliServ;
//	}
//
//	public void setCliServ(ClienteService cliServ) {
//		this.cliServ = cliServ;
//	}

	
	public Cliente getClienteSelecionado() {
		if(clienteSelecionado != null) {
			return clienteSelecionado;
		}
		return null;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public Cliente searchById(int idCliente) {
		if(clientes != null) {
			for(Cliente c : clientes) {
				if(c != null) {
					if(c.getId() == idCliente) {
						return c;
					}
				}
			}
		}
		System.out.println("Pesquisa por ID em Cliente inexistente...");
		return null;
	}

	public String goListCli(){
		return "/cliente/listCliente.xhtml";
	}

	//	public Cliente getClienteSelecionado() {
	//		return clienteSelecionado;
	//	}
	//
	//	public void setClienteSelecionado(Cliente clienteSelecionado) {
	//		this.clienteSelecionado = clienteSelecionado;
	//	}

	public List<SelectItem> getListClientesSelectOneMenu() {
		
		if(listClientesSelectOneMenu == null) {
			listClientesSelectOneMenu = new ArrayList<SelectItem>();
						
			if(clientes != null && !clientes.isEmpty()) {
				SelectItem item;
				for(Cliente cliLista : clientes) {
					item = new SelectItem(cliLista, cliLista.getNome());
					listClientesSelectOneMenu.add(item);
				}
			}
		}
		
		
		return listClientesSelectOneMenu;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

//	public Cliente getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}
	
	
	
}

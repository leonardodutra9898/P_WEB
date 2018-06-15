package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.model.Cliente;
import br.ufc.crateus.os.utils.messages.MessagesUtils;

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

	private List<Cliente> listClientes = new ArrayList<>();
	private Cliente clienteSelecionado;
	private Cliente cliente;
	
	MessagesUtils msgUtils;
	
	public void novoCliente() {
//		cliServ.salvar();
//		cliente = new Cliente();
		cliente.setId(++count);
		

		listClientes.add(cliente);
		
//		System.out.println("Antes de novo Cliente\n " + cliente.toString());
		
//		System.out.println("\nDepois de novo Cliente\n");
//		System.out.println(cliente.toString());
		
		clienteSelecionado = cliente;
		
		msgUtils = new MessagesUtils("Registro Salvo", "Novo Cliente Registrado!", MessagesTypes.SUCCESS);
	}
	
	public ClienteBean() {
//		cliServ = new ClienteService();
//		cliente = new Cliente();
//		listClientes = new ArrayList<Cliente>();

	}

	public void inicializar() {

		if(cliente != null) {
		System.out.println("###############################");
		System.out.println("Inicializando valores...");
//		clienteSelecionado = new Cliente();
		
		
		System.out.println("nome cliente => " + cliente.getNome());
//		System.out.println("Total de objetos cliente: " + cliente.getId());
		System.out.println("chamada =>> " + ++c);
		System.out.println("###############################");
		}
		cliente = new Cliente();
	}
	
	
	
//	public ClienteService getCliServ() {
//		return cliServ;
//	}
//
//	public void setCliServ(ClienteService cliServ) {
//		this.cliServ = cliServ;
//	}

	
	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public Cliente searchById(Integer idCliente) {
		for(Cliente c : listClientes) {
			if(c.getId() == idCliente) {
				return c;
			}
		}
		System.out.println("Pesquisa por ID em Cliente inexistente...");
		return null;
	}

	public List<Cliente> getListClientes() {
		return listClientes;
	}

	public void setListClientes(List<Cliente> listClientes) {
		this.listClientes = listClientes;
	}

	//	public Cliente getClienteSelecionado() {
	//		return clienteSelecionado;
	//	}
	//
	//	public void setClienteSelecionado(Cliente clienteSelecionado) {
	//		this.clienteSelecionado = clienteSelecionado;
	//	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}

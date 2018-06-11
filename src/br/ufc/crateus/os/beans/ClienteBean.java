package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.ufc.crateus.os.enums.Status;
import br.ufc.crateus.os.model.Cliente;
import br.ufc.crateus.os.model.OS;

@ManagedBean(name="cliBean")
@ApplicationScoped
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	int count = 0;
	private List<Cliente> listClientes;
	private Cliente	cli1;
	private Cliente	cli2;
	private Cliente	cli3;
		
	public ClienteBean() {
	
		listClientes = new ArrayList<Cliente>();
		
		cli1 = new Cliente();
		cli2 = new Cliente();
		cli3 = new Cliente();
		
		cli1.setNome("Maria");
		cli1.setEmail("maria@gmail.com");
		cli1.setCpf("5055050505");
		cli1.setEndereco("Rua A");
		cli1.setId(1);
		
		cli2.setNome("João");
		cli2.setEmail("joao@gmail.com");
		cli2.setCpf("111155411");
		cli2.setEndereco("Rua B");
		cli2.setId(2);		
		
		cli3.setNome("José");
		cli3.setEmail("jose@gmail.com");
		cli3.setCpf("69600000");
		cli3.setEndereco("Rua C");
		cli3.setId(3);
		
		listClientes.add(cli1);
		listClientes.add(cli2);
		listClientes.add(cli3);
		
	}
	
	@PostConstruct
	public void init() {

		
	}
	
	public void novoCliente() {
		
		listClientes.add(cliente);
		cliente = new Cliente();
		
//		System.out.println("Tamanho da lista: " + listOS.size());
//		System.out.println("Cliente => " + os.getIdCliente());
	}
	
	public void list() {
		
		for(Cliente c : listClientes) {
			
//			System.out.println(c.getId() + " -- " + c.getDescricao() + " -- " + o.getStatus());
		}
	}

	public List<Cliente> getListClientes() {
		return listClientes;
	}

	public void setListClientes(List<Cliente> listClientes) {
		this.listClientes = listClientes;
	}
	
	
	
}

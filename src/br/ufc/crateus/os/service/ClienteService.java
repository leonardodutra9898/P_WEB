package br.ufc.crateus.os.service;

import java.util.ArrayList;
import java.util.List;

import br.ufc.crateus.os.model.Cliente;

public class ClienteService {

	private Cliente cliente;
	int count = 0;
	private List<Cliente> listClientes;
	
	
	public ClienteService() {
		
		listClientes = new ArrayList<Cliente>();
		cliente = new Cliente();
		
	}
	
	public void salvar(Cliente cliente) {
		cliente.setId(++count);
		listClientes.add(cliente);		
//		cliente = new Cliente();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListClientes() {
		return listClientes;
	}

	public void setListClientes(List<Cliente> listClientes) {
		this.listClientes = listClientes;
	}
	
	
	
}

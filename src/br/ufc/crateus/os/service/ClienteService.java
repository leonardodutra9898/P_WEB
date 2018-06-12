package br.ufc.crateus.os.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufc.crateus.os.model.Cliente;

public class ClienteService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int count = 0;
	private List<Cliente> listClientes;
	
	public ClienteService() {
		listClientes = new ArrayList<Cliente>();
	}
	
	public void salvar(Cliente cliente) {
		cliente.setId(++count);
		listClientes.add(cliente);
		System.out.println("Total de itens da lista clis na própria classe. => " + getListClientes().size());
	}

	public List<Cliente> getListClientes() {
		return listClientes;
	}
}

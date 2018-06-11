package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.ufc.crateus.os.enums.Status;
import br.ufc.crateus.os.model.Cliente;
import br.ufc.crateus.os.model.OS;

@ManagedBean(name="osBean")
@ApplicationScoped
public class OSBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<OS> listOS;
	private OS os;
	int count = 0;
	private List<Cliente> listClientes;
	private Cliente cliente;
	
	public OSBean() {
		os = new OS();
		listOS = new ArrayList<OS>();
//		listClientes = new ArrayList<Cliente>();
	}
	
	@PostConstruct
	public void init() {
		
		
	}

	
	
	public List<OS> getListOS() {
		return listOS;
	}

	public OS getOs() {
		return os;
	}

	public void setOs(OS os) {
		this.os = os;
	}
	
	public void novoOS() {
		
		os.setDataAbertura(Calendar.getInstance().getTime());
		os.setId(++count);
		os.setStatus(Status.ABERTO);
		
//		cliente.setId(id);
		os.setIdCliente(cliente);
		
		listOS.add(os);

		os = new OS();
		cliente = new Cliente();
		
		System.out.println("Tamanho da lista: " + listOS.size());
		System.out.println("Cliente => " + os.getIdCliente());
	}
	
	public void list() {
		
		for(OS o : listOS) {
			
			System.out.println(o.getId() + " -- " + o.getDescricao() + " -- " + o.getStatus());
		}
	}

	public List<Cliente> getListClientes() {
		return listClientes;
	}

	public void setListClientes(List<Cliente> listClientes) {
		this.listClientes = listClientes;
	}
	
	
	
}

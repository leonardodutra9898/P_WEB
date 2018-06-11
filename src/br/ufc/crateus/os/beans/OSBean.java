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
	
	
	public OSBean() {
		os = new OS();
		listOS = new ArrayList<OS>();
		listClientes = new ArrayList<Cliente>();
		
		Cliente	cli1 = new Cliente();
		Cliente	cli2 = new Cliente();
		Cliente	cli3 = new Cliente();
		
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
		
//		OS os1 = new OS();
//		os1.setId(1);
//		os1.setDescricao("Trêta com meu navegador");
//		os1.setPrioridade(1);
//		os1.setStatus(Status.ABERTO);
//		os1.setDataAbertura(Calendar.getInstance().getTime());
//
//		OS os2 = new OS();
//		os2.setId(2);
//		os2.setDescricao("Sem internet");
//		os2.setPrioridade(5);
//		os2.setStatus(Status.ANDAMENTO);
//		os2.setDataAbertura(Calendar.getInstance().getTime());
//		
//		OS os3 = new OS();
//		os3.setId(3);
//		os3.setDescricao("Mouse não funciona");
//		os3.setPrioridade(2);
//		os3.setStatus(Status.ANDAMENTO);
//		os3.setDataAbertura(Calendar.getInstance().getTime());
//		
//		OS os4 = new OS();
//		os4.setId(4);
//		os4.setDescricao("Sem energia");
//		os4.setPrioridade(10);
//		os4.setStatus(Status.ABERTO);
//		os4.setDataAbertura(Calendar.getInstance().getTime());
		

//		listOS.add(os1);
//		listOS.add(os2);
//		listOS.add(os3);
//		listOS.add(os4);
		

		
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
		os.setIdCliente(os.getIdCliente());
		
		listOS.add(os);

		os = new OS();
		
		//list();
		
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

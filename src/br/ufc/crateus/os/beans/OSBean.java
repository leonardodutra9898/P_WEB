package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.enums.Status;
import br.ufc.crateus.os.model.Cliente;
import br.ufc.crateus.os.model.OS;
import br.ufc.crateus.os.service.ClienteService;
import br.ufc.crateus.os.utils.MessagesUtils;

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
	
	MessagesUtils msgUtils;
	
//	@Inject
	private ClienteService cliServ;
	
	private Cliente cliente;

	@PostConstruct
	public void init() {

		
	}
	
	public OSBean() {
		os = new OS();
		listOS = new ArrayList<OS>();
		cliServ = new ClienteService();
		cliente = new Cliente();
		
		System.out.println("Valores inicializados em osBean, como os, listOS, cliServ");
		
		//System.out.println("Total de itens da lista clis => " + cliServ.getListClientes().size());
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
//		os.setIdCliente(cliente);
		
		listOS.add(os);

		os = new OS();
//		cliente = new Cliente();
		
//		System.out.println("####");
//		
//		System.out.println("Tamanho da lista: " + listOS.size());
//		System.out.println("Cliente => " + os.getIdCliente());
		
		msgUtils = new MessagesUtils("Registro Salvo", "Nova Ordem de Serviço registrada!", MessagesTypes.SUCCESS);
	}
	
	public void list() {
		
		for(OS o : listOS) {
			
			System.out.println(o.getId() + " -- " + o.getDescricao() + " -- " + o.getStatus());
		}
	}

	public ClienteService getCliServ() {
		return cliServ;
	}

	public void setCliServ(ClienteService cliServ) {
		this.cliServ = cliServ;
	}
}

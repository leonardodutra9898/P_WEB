package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.enums.Status;
import br.ufc.crateus.os.model.OS;
import br.ufc.crateus.os.utils.messages.MessagesUtils;


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
	
	public OSBean() {
		os = new OS();
		listOS = new ArrayList<OS>();
	}
	
	public void osEdit() {
		
	}
	
	public void osDelete() {
		
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

//		os = new OS();
		
		
		
//		cliente = new Cliente();
		
//		System.out.println("####");
//		
//		System.out.println("Tamanho da lista: " + listOS.size());
//		System.out.println("Cliente => " + os.getIdCliente());
		
		msgUtils = new MessagesUtils("Registro Salvo", "Nova Ordem de Serviço registrada!", MessagesTypes.SUCCESS);
		
		list();
	}
	

	
	public void list() {
		
		for(OS o : listOS) {
			
			System.out.println(o.getId() + " -- " + o.getDescricao() + " -- " + o.getStatus() + " -- Prio: " + o.getPrioridade()
					+ " -- Data: " + o.getDataAbertura());
//			System.out.println(" -- Cli => " + o.getIdCliente().getNome() + " obj=> " + o.getIdCliente());
			System.out.println();
		}
	}

//	public ClienteService getCliServ() {
//		return cliServ;
//	}
//
//	public void setCliServ(ClienteService cliServ) {
//		this.cliServ = cliServ;
//	}
}

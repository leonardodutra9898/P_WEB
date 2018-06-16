package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.enums.Status;
import br.ufc.crateus.os.model.Cliente;
import br.ufc.crateus.os.model.OS;
import br.ufc.crateus.os.utils.messages.MessagesUtils;

@Named
@ManagedBean(name="osBean")
@ApplicationScoped
public class OSBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ClienteBean cliB;
	
	private List<OS> listOS;
	private OS os;
	int count = 0;
	private Cliente clienteViewOS;
	
	MessagesUtils msgUtils;
	
	public OSBean() {
		os = new OS();
		clienteViewOS = new Cliente();
		listOS = new ArrayList<OS>();
		cliB = new ClienteBean();
	}
	
	public void osEdit() {
		
	}
	
	public void osDelete() {
		
	}
	
//	public String nomeClienteByOS(OS o) {
//			
//			for(OS oss : listOS) {
//				if(oss.getId() == os.getId()) {
//					clienteViewOS = oss;
//				}
//			}
//
//		return os.getIdCliente().getNome();
//	}
	
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
		os.setIdCliente(clienteViewOS);
		
		
		listOS.add(os);
		os = new OS();
		msgUtils = new MessagesUtils("Registro Salvo", "Nova Ordem de Serviço registrada!", MessagesTypes.SUCCESS);

	}

	public ClienteBean getCliB() {
		return cliB;
	}

	public void setCliB(ClienteBean cliB) {
		this.cliB = cliB;
	}
	
	public OS searchById(int idOS) {
		if(listOS != null) {
			for(OS os : listOS) {
				
					if(os.getId() == idOS) {
						return os;
					}
				
			}
		}

		return null;
	}
	
	
	public void excluirOS() {
		
		
			listOS.remove(searchById(getOs().getId()));
			System.out.println("excluido");
		
			msgUtils = new MessagesUtils("Excluído!", "OS", MessagesTypes.INFO);	
		
	}

	public Cliente getClienteViewOS() {
		return clienteViewOS;
	}

	public void setClienteViewOS(Cliente clienteViewOS) {
		this.clienteViewOS = clienteViewOS;
	}
	
}

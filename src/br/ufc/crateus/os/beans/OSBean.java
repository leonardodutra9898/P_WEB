package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
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

	
	private List<OS> listOS;
	private OS os;
	int count = 0;
	private Cliente clienteViewOS;
	private Cliente cliSetado;
	
	
	MessagesUtils msgUtils;
	
	public OSBean() {
		os = new OS();
		clienteViewOS = new Cliente();
		listOS = new ArrayList<>();
		
		cliSetado = new Cliente();
		System.out.println("Cliente inicializado... == " + cliSetado.getNome());
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
	
	public boolean isEdit() {
		return (os.getId() != null);
	}
	
	public void novoOS() {
		
		if(isEdit()) {
			atualizarOS();
		}else {
		
		os.setDataAbertura(Calendar.getInstance().getTime());
		os.setId(++count);
		os.setStatus(Status.ABERTO);
		os.setNomeCliente(cliSetado.getNome());	
		
		System.out.println("teste cli em OS === " + cliSetado.getId());
				
		listOS.add(os);
		os = new OS();
		msgUtils = new MessagesUtils("Registro Salvo", "Nova Ordem de Serviço registrada!", MessagesTypes.SUCCESS);
		}
	}

	public void setClienteId(Cliente cli) {
		cliSetado = cli;
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
	
	public OS searchById() {
		
		for(OS c : listOS) {
			
			if(c.getId() == os.getId()) {
				return c;
			}
		}
		
		return null;
	}
	
	public String searchEdit(OS oo) {
		for(OS o : listOS) {
			
			if(o.getId() == oo.getId()) {
				os = o;

			}
		}
		
		return "/os/newOS?faces-redirect=true";
	}

	public Cliente getClienteViewOS() {
		return clienteViewOS;
	}

	public void setClienteViewOS(Cliente clienteViewOS) {
		this.clienteViewOS = clienteViewOS;
	}

	public Cliente getCliSetado() {
		return cliSetado;
	}

	public void setCliSetado(Cliente cliSetado) {
		this.cliSetado = cliSetado;
	}
	
public void atualizarOS() {
		
		OS osSearch = searchById();
		
		if(osSearch != null) {
			osSearch.setNomeCliente(os.getNomeCliente());
			osSearch.setDescricao(os.getDescricao());
			osSearch.setDataAbertura(os.getDataAbertura());
			osSearch.setGravidade(os.getGravidade());
			osSearch.setDataFechamento(os.getDataFechamento());
			osSearch.setStatus(os.getStatus());
			
			msgUtils = new MessagesUtils("Atualização realizada com sucesso em Ordem de Serviço...", "Atualização concluída", MessagesTypes.SUCCESS);
		}
		
	}

public void remove() {
	
	OS o = searchById();
	
	if(o != null) {
		
		listOS.remove(o);
		
		msgUtils = new MessagesUtils("Atualização realizada com sucesso em OS...", "Atualização concluída", MessagesTypes.SUCCESS);
		System.out.println("Contato removido.");
	}
}


	
}

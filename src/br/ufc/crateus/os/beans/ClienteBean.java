package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.model.Cliente;
import br.ufc.crateus.os.repository.ClienteRepository;
import br.ufc.crateus.os.utils.dao.EntityManagerPersistence;
import br.ufc.crateus.os.utils.messages.MessagesUtils;

@Named
@ManagedBean(name="cliBean")
@ApplicationScoped
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int count = 0;

//	private List<SelectItem> listClientesSelectOneMenu;
	
	private Cliente clienteSelecionado;
	private List<Cliente> clientes;
	
	MessagesUtils msgUtils;
	
	public void novoCliente() {
		
		if(isEditar()) {
			atualizarCliente();
		}else {
			
			EntityManager manager = EntityManagerPersistence.getEntityManager();
			
			try {
				manager.getTransaction().begin();
				ClienteRepository clienteRepo = new ClienteRepository(manager);
				clienteRepo.addCliente(clienteSelecionado);
				clientes = clienteRepo.listClientes();
				clienteSelecionado = new Cliente();
				msgUtils = new MessagesUtils("Registro Salvo", "Novo Cliente Registrado!", MessagesTypes.SUCCESS);
				
				manager.getTransaction().commit();
				
			}catch(Exception e) {
				manager.getTransaction().rollback();
				msgUtils = new MessagesUtils("Erro ao tentar salvar registro", ("Erro: " + e.toString()), 
						MessagesTypes.ERROR);
			} finally {
				manager.close();
			}
		}
	}
	
	public ClienteBean() {

		EntityManager manager = EntityManagerPersistence.getEntityManager();
		ClienteRepository clienteRepo = new ClienteRepository(manager);
		clientes = clienteRepo.listClientes();
		clienteSelecionado = new Cliente();
		manager.close();
	}
	
	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public Cliente searchById() {
		
			for(Cliente c : clientes) {
				
					if(c.getId() == clienteSelecionado.getId()) {
						return c;
					}
			}

		return null;
	}

	public String getNameClienteById(Integer i) {
		
		for(Cliente c : clientes) {
			
				if(c.getId() == i) {
					System.out.println("resultado..." + c.getNome());
					return c.getNome();
				}
		}
		


	return null;
	}
	
	public Cliente getClienteById(Integer i) {
		
		for(Cliente c : clientes) {
			
				if(c.getId() == i) {
					return c;
				}
		}

	return null;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public String clientById(Cliente cliente) {
		
		for(Cliente c : clientes) {
			if(c.getId() == cliente.getId()) {
				clienteSelecionado = c;
			}
		}
		
		return "/cliente/editCliente?faces-redirect-true";
	}
	
//	public Cliente getClientById(Cliente cliente) {
//		Cliente temp = null;
//		for(Cliente c : clientes) {
//			if(c.getId() == cliente.getId()) {
//				temp = c;
//			}
//		}
//		return temp;
//	}
	
	public void excluirCliente() {
		
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		try {
			
			manager.getTransaction().begin();
			ClienteRepository clienteRepo = new ClienteRepository(manager);
			clienteRepo.delete(clienteSelecionado);
			clientes = clienteRepo.listClientes();
			
			clienteSelecionado = new Cliente();
			
			manager.getTransaction().commit();
			msgUtils = new MessagesUtils("Cliente excluído...", "Cliente removido", 
					MessagesTypes.SUCCESS);
			
		}catch(Exception e) {
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Cliente não pode ser excluido...", ("Cliente não removido... " + e.toString()), 
					MessagesTypes.ERROR);
		} finally {
			manager.close();
		}
		
//		Cliente cliTemp = searchById();
//		
//		if(cliTemp != null) {
//			clientes.remove(cliTemp);
//			
//			msgUtils = new MessagesUtils("Cliente excluído...", "Cliente removido", MessagesTypes.SUCCESS);
//		}
		
	}
	
	public void atualizarCliente() {
		
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		try {
			
			manager.getTransaction().begin();
			ClienteRepository clienteRepo = new ClienteRepository(manager);
			clienteRepo.addCliente(clienteSelecionado);
			clientes = clienteRepo.listClientes();
			
			clienteSelecionado = new Cliente();
			msgUtils = new MessagesUtils("Atualização realizada com sucesso em CLiente...", "Atualização concluída", 
					MessagesTypes.SUCCESS);
			
			manager.getTransaction().commit();
						
		}catch(Exception e) {
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Erro ao tentar atualizar Cliente...", ("Erro ao atualizar... " + e.toString()), 
					MessagesTypes.ERROR);
		} finally {
			manager.close();
		}
		
//		Cliente cliSearch = searchById();
//		
//		if(cliSearch != null) {
//			cliSearch.setNome(clienteSelecionado.getNome());
//			cliSearch.setEmail(clienteSelecionado.getEmail());
//			cliSearch.setEndereco(clienteSelecionado.getEndereco());
//			cliSearch.setCpf(clienteSelecionado.getCpf());
//			
//			msgUtils = new MessagesUtils("Atualização realizada com sucesso em CLiente...", "Atualização concluída", MessagesTypes.SUCCESS);
//		}
		
	}
	
	
	
	public boolean isEditar() {
		return this.clienteSelecionado.getId() != null;
	}
}

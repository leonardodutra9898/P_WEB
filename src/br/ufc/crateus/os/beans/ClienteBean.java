package br.ufc.crateus.os.beans;

import java.io.Serializable;
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
	
	private Cliente clienteSelecionado;
	private List<Cliente> clientes;
	private Cliente nCliente;
	private Cliente cliEdit;
		
	MessagesUtils msgUtils;
	
	public void novoCliente() {
		
			EntityManager manager = EntityManagerPersistence.getEntityManager();
			
			try {
				manager.getTransaction().begin();
				ClienteRepository clienteRepo = new ClienteRepository(manager);
				clienteRepo.addCliente(nCliente);
				clientes = clienteRepo.listClientes();
				nCliente = new Cliente();
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
	
	public ClienteBean() {

		EntityManager manager = EntityManagerPersistence.getEntityManager();
		ClienteRepository clienteRepo = new ClienteRepository(manager);
		clientes = clienteRepo.listClientes();
		clienteSelecionado = new Cliente();
		nCliente = new Cliente();
		cliEdit = new Cliente();
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

	public List<Cliente> getClientes() {
		return clientes;
	}

	public String clientById(Cliente cliente) {
		
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		try {
		
			ClienteRepository cliRepo = new ClienteRepository(manager);
			manager.getTransaction().begin();
			Cliente temp = cliRepo.clienteById(cliente.getId());
			cliEdit = temp;
			
		}catch(Exception e) {
			System.out.println("Erro ao tentar consultar cliente individual");
		}finally {
			manager.close();
		}		
		return "/cliente/editCliente?faces-redirect-true";
	}
	
	public void excluirCliente() {
		
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		try {
			
			manager.getTransaction().begin();
			ClienteRepository clienteRepo = new ClienteRepository(manager);
			clienteRepo.clienteById(clienteSelecionado.getId());
			clienteRepo.delete(clienteSelecionado);
			
			manager.getTransaction().commit();

			msgUtils = new MessagesUtils("Cliente exclu�do...", "Cliente removido", 
					MessagesTypes.SUCCESS);
					
			clientes = clienteRepo.listClientes();
			clienteSelecionado = new Cliente();
		
		}catch(Exception e) {
			
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Pode haver depend�ncia desse registro em outra entidade...", ("Cliente n�o removido... " + e.toString()), 
					MessagesTypes.ERROR);
			
		} finally {
			manager.close();
		}
	}
	
	public void atualizarCliente() {
		
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		try {
			
			manager.getTransaction().begin();
			ClienteRepository clienteRepo = new ClienteRepository(manager);
			clienteRepo.addCliente(cliEdit);
			clientes = clienteRepo.listClientes();
			
			cliEdit = new Cliente();
			msgUtils = new MessagesUtils("Atualiza��o realizada com sucesso em CLiente...", "Atualiza��o conclu�da", 
					MessagesTypes.SUCCESS);
			
			manager.getTransaction().commit();
						
		}catch(Exception e) {
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Erro ao tentar atualizar Cliente...", ("Erro ao atualizar... " + e.toString()), 
					MessagesTypes.ERROR);
		} finally {
			manager.close();
		}
		
	}

	public Cliente getnCliente() {
		return nCliente;
	}

	public void setnCliente(Cliente nCliente) {
		this.nCliente = nCliente;
	}

	public Cliente getCliEdit() {
		return cliEdit;
	}

	public void setCliEdit(Cliente cliEdit) {
		this.cliEdit = cliEdit;
	}
}

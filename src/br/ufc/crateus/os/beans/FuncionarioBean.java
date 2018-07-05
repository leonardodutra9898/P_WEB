package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.ufc.crateus.os.enums.FuncionarioFuncoes;
import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.enums.Status;
import br.ufc.crateus.os.model.Cliente;
import br.ufc.crateus.os.model.Funcionario;
import br.ufc.crateus.os.model.OS;
import br.ufc.crateus.os.repository.ClienteRepository;
import br.ufc.crateus.os.repository.FuncionarioRepository;
import br.ufc.crateus.os.utils.dao.EntityManagerPersistence;
import br.ufc.crateus.os.utils.messages.MessagesUtils;

@Named
@ManagedBean(name="funcBean")
@ApplicationScoped
public class FuncionarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private FuncionarioFuncoes FUNCAO;
	private Funcionario nFuncionario;
	private Funcionario funcionarioEdit;
	
	MessagesUtils msgUtils;
	
	public FuncionarioBean() {
		
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		FuncionarioRepository funcionarioRepo = new FuncionarioRepository(manager);
		funcionarios = funcionarioRepo.listFuncionarios();
		
		funcionario = new Funcionario();
		nFuncionario = new Funcionario();
		funcionarioEdit = new Funcionario();
		
		manager.close();
	}
	
	
	public void novoFunc() {
		
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		try {
			manager.getTransaction().begin();
			FuncionarioRepository funcionarioRepo = new FuncionarioRepository(manager);
			funcionarioRepo.addFuncionario(nFuncionario);
			funcionarios = funcionarioRepo.listFuncionarios();
			
			funcionario = new Funcionario();
			msgUtils = new MessagesUtils("Registro Salvo", "Funcionário registrado!", MessagesTypes.SUCCESS);
			
			manager.close();
			
		}catch(Exception e) {
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Erro ao tentar salvar registro", ("Erro: " + e.toString()), 
					MessagesTypes.ERROR);
		}finally {
			manager.close();
		}
	}

	public Funcionario searchById() {
		
		for(Funcionario f : funcionarios) {
			
				if(f.getId() == funcionario.getId()) {
					return f;
				}
		}

	return null;
}
	
	
	public void excluirFunc() {
			System.out.println("excluido");
			funcionarios.remove(funcionario);
			
			msgUtils = new MessagesUtils("Excluído!", "OS", MessagesTypes.INFO);	
		
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public String funcionarioById(Funcionario f) {
		
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		try {
			
			FuncionarioRepository funcionarioRepo = new FuncionarioRepository(manager);
			manager.getTransaction().begin();
			Funcionario temp = funcionarioRepo.funcionarioById(f.getId());
			funcionarioEdit = temp;
			
		}catch(Exception e) {
			System.out.println("Erro ao tentar consultar funcionário individual");
		}finally {
			manager.close();
		}
		
		return "/funcionario/editFuncionario?faces-redirect-true";
	}	
	
	public void excluirFuncionario() {
		
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		try {
			
			manager.getTransaction().begin();
			FuncionarioRepository funcionarioRepo = new FuncionarioRepository(manager);
			funcionarioRepo.funcionarioById(funcionario.getId());
			funcionarioRepo.delete(funcionario);
			
			manager.getTransaction().commit();

			msgUtils = new MessagesUtils("Funcionário excluído...", "Funcionário removido", 
					MessagesTypes.SUCCESS);
					
			funcionarios = funcionarioRepo.listFuncionarios();
			funcionario = new Funcionario();
			
		}catch(Exception e) {
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Funcionário não pode ser excluido...", ("Funcionário não removido... " + e.toString()), 
					MessagesTypes.ERROR);
		} finally {
			manager.close();
		}
	}
	
	public void atualizarFuncionario() {
		
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		try {
			
			manager.getTransaction().begin();
			FuncionarioRepository funcionarioRepo = new FuncionarioRepository(manager);
			funcionarioRepo.addFuncionario(funcionarioEdit);
			funcionarios = funcionarioRepo.listFuncionarios();
			
			funcionarioEdit = new Funcionario();
			msgUtils = new MessagesUtils("Atualização realizada com sucesso em funcionário...", "Atualização concluída", 
					MessagesTypes.SUCCESS);
			
			manager.getTransaction().commit();
						
		}catch(Exception e) {
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Erro ao tentar atualizar funcionário...", ("Erro ao atualizar... " + e.toString()), 
					MessagesTypes.ERROR);
		} finally {
			manager.close();
		}
		
	}
	
	public String funcById(Funcionario f) {
		
		for(Funcionario fa : funcionarios) {
			if(fa.getId() == f.getId()) {
				funcionario = fa;
			}
		}
		
		return "/funcionario/newFuncionario?faces-redirect-true";
	}


	public Funcionario getnFuncionario() {
		return nFuncionario;
	}


	public void setnFuncionario(Funcionario nFuncionario) {
		this.nFuncionario = nFuncionario;
	}


	public Funcionario getFuncionarioEdit() {
		return funcionarioEdit;
	}


	public void setFuncionarioEdit(Funcionario funcionarioEdit) {
		this.funcionarioEdit = funcionarioEdit;
	}
	
	public FuncionarioFuncoes[] getFuncoes(){
		   return FuncionarioFuncoes.values();
		 }
	
}

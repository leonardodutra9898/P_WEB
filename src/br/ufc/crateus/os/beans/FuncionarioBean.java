package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.ufc.crateus.os.enums.FuncionarioFuncoes;
import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.model.Funcionario;
import br.ufc.crateus.os.repository.FuncionarioRepository;
import br.ufc.crateus.os.utils.dao.EntityManagerPersistence;
import br.ufc.crateus.os.utils.messages.MessagesUtils;

@Named
@ManagedBean(name = "funcBean")
@ApplicationScoped
public class FuncionarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private List<Funcionario> tecnicos;
	private FuncionarioFuncoes FUNCAO;
	private Funcionario nFuncionario;
	private Funcionario funcionarioEdit;
	private Funcionario senhaFuncionarioTemp;
	
	
	MessagesUtils msgUtils;

	public FuncionarioBean() {

		EntityManager manager = EntityManagerPersistence.getEntityManager();
		FuncionarioRepository funcionarioRepo = new FuncionarioRepository(manager);
		funcionarios = funcionarioRepo.listFuncionarios();
		tecnicos = funcionarioRepo.listTecnicos();

		funcionario = new Funcionario();
		nFuncionario = new Funcionario();
		funcionarioEdit = new Funcionario();

		manager.close();
	}

	public void sessaoCarrega() {
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		funcionarioEdit = FuncionarioRepository.getUsuarioLogado();
		
		manager.close();
	}
	
	public void init() {
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		FuncionarioRepository funcionarioRepo = new FuncionarioRepository(manager);
		
		funcionarios = funcionarioRepo.listFuncionarios();
		tecnicos = funcionarioRepo.listTecnicos();
		
		manager.close();
	}

	public void novoFunc() {

		EntityManager manager = EntityManagerPersistence.getEntityManager();

		try {
			manager.getTransaction().begin();
			FuncionarioRepository funcionarioRepo = new FuncionarioRepository(manager);
			funcionarioRepo.addFuncionario(nFuncionario);
						
			nFuncionario = new Funcionario();
			msgUtils = new MessagesUtils("Registro Salvo", "Funcionário registrado!", MessagesTypes.SUCCESS);

			manager.getTransaction().commit();
			
			funcionarios = funcionarioRepo.listFuncionarios();
			tecnicos = funcionarioRepo.listTecnicos();

		} catch (Exception e) {
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Erro ao tentar salvar registro", ("Erro: " + e.toString()),
					MessagesTypes.ERROR);
		} finally {
			manager.close();
		}
	}

	public Funcionario searchById() {

		for (Funcionario f : funcionarios) {

			if (f.getId() == funcionario.getId()) {
				return f;
			}
		}

		return null;
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

		} catch (Exception e) {
			System.out.println("Erro ao tentar consultar funcionário individual");
		} finally {
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
			msgUtils = new MessagesUtils("Funcionário excluído...", "Funcionário removido", MessagesTypes.SUCCESS);

			funcionarios = funcionarioRepo.listFuncionarios();
			funcionario = new Funcionario();

		} catch (Exception e) {
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Pode haver dependência desse registro em outra entidade...",
					("Funcionário não removido... " + e.toString()), MessagesTypes.ERROR);
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
			
			funcionarioEdit = new Funcionario();
			msgUtils = new MessagesUtils("Atualização realizada com sucesso em funcionário...", "Atualização concluída",
					MessagesTypes.SUCCESS);
			manager.getTransaction().commit();
			
			funcionarios = funcionarioRepo.listFuncionarios();

		} catch (Exception e) {
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Erro ao tentar atualizar funcionário...",
					("Erro ao atualizar... " + e.toString()), MessagesTypes.ERROR);
		} finally {
			manager.close();
		}

	}
	
	public void mudarSenha() {
		EntityManager manager = EntityManagerPersistence.getEntityManager();

		try {

			manager.getTransaction().begin();
			FuncionarioRepository funcionarioRepo = new FuncionarioRepository(manager);

			funcionarioEdit = new Funcionario();
			msgUtils = new MessagesUtils("Atualização realizada com sucesso em funcionário...", "Atualização concluída",
					MessagesTypes.SUCCESS);
			manager.getTransaction().commit();
			
			funcionarios = funcionarioRepo.listFuncionarios();

		} catch (Exception e) {
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Erro ao tentar atualizar funcionário...",
					("Erro ao atualizar... " + e.toString()), MessagesTypes.ERROR);
		} finally {
			manager.close();
		}
	}

	public String funcById(Funcionario f) {

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

	public Funcionario getFuncionarioEdit() {
		return funcionarioEdit;
	}

	public void setFuncionarioEdit(Funcionario funcionarioEdit) {
		this.funcionarioEdit = funcionarioEdit;
	}

	public FuncionarioFuncoes[] getFuncoes() {
		return FuncionarioFuncoes.values();
	}

	public FuncionarioFuncoes getFUNCAO() {
		return FUNCAO;
	}

	public void setFUNCAO(FuncionarioFuncoes fUNCAO) {
		FUNCAO = fUNCAO;
	}

	public Funcionario getnFuncionario() {
		return nFuncionario;
	}

	public void setnFuncionario(Funcionario nFuncionario) {
		this.nFuncionario = nFuncionario;
	}

	public List<Funcionario> getTecnicos() {
		return tecnicos;
	}

	public Funcionario getSenhaFuncionarioTemp() {
		return senhaFuncionarioTemp;
	}

	public void setSenhaFuncionarioTemp(Funcionario senhaFuncionarioTemp) {
		this.senhaFuncionarioTemp = senhaFuncionarioTemp;
	}	
}

package br.ufc.crateus.os.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.model.Funcionario;
import br.ufc.crateus.os.utils.messages.MessagesUtils;

public class FuncionarioRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	private static Funcionario usuarioLogado;
	
	public FuncionarioRepository(EntityManager manager) {
		
		this.manager = manager;
	}
	
	public List<Funcionario> listFuncionarios(){
		
		TypedQuery<Funcionario> query = manager.createQuery("from Funcionario", Funcionario.class);
		return query.getResultList();
	}

	public boolean userIsFound(String login){
		
		TypedQuery<Funcionario> query = manager.createQuery("SELECT f FROM Funcionario f WHERE login = :lo", 
				Funcionario.class).setParameter("lo", login);
		return query.getResultList().size() > 0;
	}
	
	public List<Funcionario> listTecnicos(){
		
		TypedQuery<Funcionario> query = manager.createQuery("SELECT f FROM Funcionario f WHERE FUNCAO = 'TECNICO'", 
				Funcionario.class);
		return query.getResultList();
	}
	
	public void addFuncionario(Funcionario funcionario) {
		manager.merge(funcionario);
	}
	
	public Funcionario funcionarioById(int id) {
		return manager.find(Funcionario.class, id);
	}
	
	public void delete(Funcionario funcionario) {
		manager.remove(manager.getReference(Funcionario.class, funcionario.getId()));
	}

	public Funcionario byLoginSenha(String login, String senha) {
		TypedQuery<Funcionario> query = manager.createQuery(
				"SELECT u FROM Funcionario u WHERE login = :login AND senha = :senha",
				Funcionario.class).
				setParameter("login", login).
				setParameter("senha", senha);
		
		if(query.getMaxResults() > 0) {
			setUsuarioLogado(query.getSingleResult());
			new MessagesUtils("Usuário logado!", "Autenticação sem sucesso.", 
					MessagesTypes.ERROR);
			return getUsuarioLogado();
		}else {
			new MessagesUtils("Erro ao localizar usuário informado.", "Autenticação sem sucesso.", 
					MessagesTypes.ERROR);
			return null;
		}
	}

	public static Funcionario getUsuarioLogado() {
		return usuarioLogado;
	}

	public static void setUsuarioLogado(Funcionario usuarioLogado) {
		FuncionarioRepository.usuarioLogado = usuarioLogado;
	}
	
	
}

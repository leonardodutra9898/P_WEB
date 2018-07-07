package br.ufc.crateus.os.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.crateus.os.model.Funcionario;

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
				Funcionario.class);

		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		setUsuarioLogado(query.getSingleResult());
		
		System.out.println("### === " + query.getSingleResult().getLogin());
		
		return getUsuarioLogado();
	}

	public static Funcionario getUsuarioLogado() {
		return usuarioLogado;
	}

	public static void setUsuarioLogado(Funcionario usuarioLogado) {
		FuncionarioRepository.usuarioLogado = usuarioLogado;
	}
	
	
}

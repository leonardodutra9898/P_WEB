package br.ufc.crateus.os.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.crateus.os.model.Usuario;

public class UsuarioRepository implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	private static Usuario usuarioLogado;
	
	public UsuarioRepository(EntityManager manager) {
		
		this.manager = manager;
	}
	
	public List<Usuario> allUsuarios(){
		
		TypedQuery<Usuario> query = manager.createQuery("from Usuario", Usuario.class);
		return query.getResultList();
	}
	
	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public static void setUsuarioLogado(Usuario usuarioLogado) {
		UsuarioRepository.usuarioLogado = usuarioLogado;
	}

	public void addUsuario(Usuario usuario) {		
		manager.merge(usuario);
	}
	
	public Usuario usuarioById(int id) {
		return manager.find(Usuario.class, id);
	}
	
	public Usuario byLoginSenha(String login, String senha) {
		TypedQuery<Usuario> query = manager.createQuery(
				"SELECT u FROM Usuario u WHERE login = :login AND senha = :senha",
				Usuario.class);
		
		System.out.println("LO = " + login);
		System.out.println("SEN = " + senha);
		
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		setUsuarioLogado(query.getSingleResult());
		
		System.out.println("### === " + query.getSingleResult().getLogin());
		
		return getUsuarioLogado();
	}
	
	public void delete(Usuario usuario) {
		manager.remove(manager.getReference(Usuario.class, usuario.getId()));
	}
}

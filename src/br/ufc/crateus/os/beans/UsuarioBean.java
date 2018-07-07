package br.ufc.crateus.os.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.model.Usuario;
import br.ufc.crateus.os.repository.UsuarioRepository;
import br.ufc.crateus.os.utils.dao.EntityManagerPersistence;
import br.ufc.crateus.os.utils.messages.MessagesUtils;

@ManagedBean(name="uBean")
@SessionScoped
public class UsuarioBean implements Serializable{

	private Usuario usuario;
	private String login;
	private String senha;
	
	public UsuarioBean() {
		
	}
	
	MessagesUtils msgUtils;
	
	public String adiciona() {
		
		String retorno = "";
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		try {
			
			manager.getTransaction().begin();
			UsuarioRepository usuarioRepo = new UsuarioRepository(manager);
			
			Usuario novoUsuario = new Usuario();
			novoUsuario.setLogin(this.login);
			novoUsuario.setSenha(this.senha);
			usuarioRepo.addUsuario(novoUsuario);
			setUsuario(novoUsuario);
			
			
			manager.getTransaction().commit();
			
			msgUtils = new MessagesUtils("Usuário cadastrado", "Novo usuário Registrado!", MessagesTypes.SUCCESS);
			
			retorno = "/index?faces-redirect=true";
		}catch (Exception e) {
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Erro ao cadastrar usuário", ("Erro: " + e.toString()), 
					MessagesTypes.ERROR);
			retorno = "";
		}finally {
			manager.close();
		}
		
		return retorno;
	}
	
	public String logar() {
		
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		UsuarioRepository usuarioRepo = new UsuarioRepository(manager);
		Usuario usuarioLogado = usuarioRepo.byLoginSenha(login, senha);
		
		if(usuarioLogado == null) {
			setSenha("");
			msgUtils = new MessagesUtils("Login ou senha incorreta", "Erro: " , 
					MessagesTypes.WARNING);
			
			manager.close();
			return "/login.xhtml?faces-redirect=true"; 
		}else {
			setUsuario(usuarioLogado);
			manager.close();
			return "/index.xhtml?faces-redirect=true"; 
		}		
	}
	
	public String logout() {
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		UsuarioRepository.setUsuarioLogado(null);
		setUsuario(null);
		setLogin("");
		setSenha("");
		return "/login.xhtml?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

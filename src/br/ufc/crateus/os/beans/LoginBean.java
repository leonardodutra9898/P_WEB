package br.ufc.crateus.os.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.ufc.crateus.os.enums.FuncionarioFuncoes;
import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.model.Funcionario;
import br.ufc.crateus.os.repository.FuncionarioRepository;
import br.ufc.crateus.os.utils.dao.EntityManagerPersistence;
import br.ufc.crateus.os.utils.messages.MessagesUtils;

@ManagedBean(name="uBean")
@SessionScoped
public class LoginBean implements Serializable{

	private Funcionario usuario;
	private String login;
	private String senha;

	MessagesUtils msgUtils;
	
	public LoginBean() {
		
	}

	public void init() {
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		FuncionarioRepository fRepo = new FuncionarioRepository(manager);

		if(!fRepo.userIsFound("admin")) {
			manager.getTransaction().begin();
			Funcionario temp = new Funcionario();
			
			temp.setId(1);
			temp.setFUNCAO(FuncionarioFuncoes.ADMINISTRADOR);
			temp.setLogin("admin");
			temp.setNome("Administrador");
			temp.setSenha("admin");
			temp.setSalario(0.0f);
			temp.setEmail("admin@admin.com.br");
			
			fRepo.addFuncionario(temp);
			manager.getTransaction().commit();
			
			manager.close();
		}
	}
	
	public String logar() {

		EntityManager manager = EntityManagerPersistence.getEntityManager();		
		
		try {
			
			FuncionarioRepository usuarioRepo = new FuncionarioRepository(manager);
			Funcionario usuarioLogado = usuarioRepo.byLoginSenha(login, senha);
			
			if(usuarioLogado == null) {
				setSenha("");
				msgUtils = new MessagesUtils("Login ou senha incorreta", "Erro: " , 
						MessagesTypes.WARNING);
				
				
				manager.close();
				return "/login.xhtml?faces-redirect=true"; 
			}else {
				setUsuario(usuarioLogado);
				System.out.println("Teste de autenticação feito -- " + usuarioLogado.getLogin());
				manager.close();
				msgUtils = new MessagesUtils("Usuário Logado. Bem-Vindo!", "Autenticação realizada.", 
						MessagesTypes.SUCCESS);
				return "/index.xhtml?faces-redirect=true"; 
			}					
			
		}catch(Exception e) {
			manager.close();
			msgUtils = new MessagesUtils("Login ou senha incorreta", "Erro: " , 
					MessagesTypes.WARNING);
		}
		return "";
	}
	
	public String logout() {
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		FuncionarioRepository.setUsuarioLogado(null);
		setUsuario(null);
		return "/index.xhtml?faces-redirect=true";
	}
	
	public Funcionario getUsuario() {
		return usuario;
	}

	public void setUsuario(Funcionario usuario) {
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

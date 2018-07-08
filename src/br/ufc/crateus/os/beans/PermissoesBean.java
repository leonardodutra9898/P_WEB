package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.ufc.crateus.os.controller.PermissoesPaginas;
import br.ufc.crateus.os.enums.EntidadeSistema;
import br.ufc.crateus.os.enums.FuncionarioFuncoes;
import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.model.Funcionario;
import br.ufc.crateus.os.model.Permissoes;
import br.ufc.crateus.os.repository.FuncionarioRepository;
import br.ufc.crateus.os.repository.PermissoesRepository;
import br.ufc.crateus.os.utils.dao.EntityManagerPersistence;
import br.ufc.crateus.os.utils.messages.MessagesUtils;

@Named
@ManagedBean(name="pBean")
@ApplicationScoped
public class PermissoesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Permissoes> permissoes;
	private List<Permissoes> permissoesPorPerfil;
	
	MessagesUtils msgUtils;

	public void init() {
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		try {
			manager.getTransaction().begin();
			
			PermissoesRepository permissoesRepo = new PermissoesRepository(manager);
			FuncionarioRepository fRepo = new FuncionarioRepository(manager);
			
			Funcionario usuario = fRepo.getUsuarioLogado();
			
			permissoesRepo.carregaPermissoesIni();

			
			manager.getTransaction().commit();

			msgUtils = new MessagesUtils("Permissões carregadas", "Carregado!", MessagesTypes.SUCCESS);
			
			permissoes = permissoesRepo.listPermissoes();
			permissoesPorPerfil = permissoesRepo.listPermissoesByPerfil(usuario.getFUNCAO());
			
		}catch(Exception e) {
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Erro ao tentar carregar permissões", ("Erro: " + e.toString()), 
					MessagesTypes.ERROR);
		} finally {
			manager.close();
		}
	}
	
	public PermissoesBean() {
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		PermissoesRepository permissoesRepo = new PermissoesRepository(manager);
		
		FuncionarioRepository fRepo = new FuncionarioRepository(manager);
		Funcionario usuario = fRepo.getUsuarioLogado();
		
		permissoes = permissoesRepo.listPermissoes();
		
		permissoesPorPerfil = permissoesRepo.listPermissoesByPerfil(usuario.getFUNCAO());
		
		manager.close();
	}

	public List<Permissoes> listPermissoes() {
		return permissoes;
	}

	public List<Permissoes> getPermissoes() {
		return permissoes;
	}

	public List<Permissoes> getPermissoesPorPerfil() {
		return permissoesPorPerfil;
	}
	
	public boolean isRender(FuncionarioFuncoes perfil, EntidadeSistema entidade, String controle) {
		// controle NOVO, EDITAR, EXCLUIR, LISTAR
		
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		PermissoesRepository permissoesRepo = new PermissoesRepository(manager);
		
		List<Permissoes> listTemp = permissoesRepo.listPermissoesByPerfilEntidade(perfil, entidade);
		
		System.out.println("PERFIL === > " + perfil);
		System.out.println("ENTIDADE === > " + entidade);
		System.out.println("CONTROLE === > " + controle);
		System.out.println("resultado da lista === > " + listTemp.size());
		
		Permissoes permissao = null;
		
		for(Permissoes pe : listTemp) {
			permissao = pe;
		}
		
		System.out.println("TIPO P === > "+permissao.getTipoPermissao());
		
		boolean novo = false, editar = false, excluir = false, listar = false;
		
		PermissoesPaginas pPaginas;
		
		switch(permissao.getTipoPermissao()) {
		case FULL:
			novo = true;
			editar = true;
			excluir = true;
			listar = true;
			break;
		case ONLY_WRITE:
			novo = false;
			editar = true;
			excluir = false;
			listar = true;
			break;
		case ONLY_READ:
			novo = false;
			editar = false;
			excluir = false;
			listar = true;
			break;
		}
		
		System.out.println("CONTROLE NOVO == " + novo);
		
		if(controle == "novo") return novo;
		if(controle == "editar") return editar;
		if(controle == "excluir") return excluir;
		if(controle == "listar") return listar;
		
		manager.close();
		
		return false;
	}
}

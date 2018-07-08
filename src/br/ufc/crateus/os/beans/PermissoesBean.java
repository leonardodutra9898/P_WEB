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
	PermissoesPaginas pps;
	
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
	
	public void setPermissoesPaginas(FuncionarioFuncoes perfil, EntidadeSistema entidade) {
		// controle NOVO, EDITAR, EXCLUIR, LISTAR
		
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		PermissoesRepository permissoesRepo = new PermissoesRepository(manager);
		
		List<Permissoes> listTemp = permissoesRepo.listPermissoesByPerfilEntidade(perfil, entidade);
		
		System.out.println("PERFIL === > " + perfil);
		System.out.println("ENTIDADE === > " + entidade);
//		System.out.println("CONTROLE === > " + controle);
		System.out.println("resultado da lista === > " + listTemp.size());
		
		Permissoes permissao = null;
		
		for(Permissoes pe : listTemp) {
			permissao = pe;
		}
		
		System.out.println("TIPO P === > "+permissao.getTipoPermissao());
		
		boolean novo = false, editar = false, excluir = false, listar = false;
		
		PermissoesPaginas pps = null;		
		
		pps = new PermissoesPaginas();
		
		switch(permissao.getTipoPermissao()) {
		case FULL:
			pps.setAdminOsNew(true);
			pps.setAdminOsEdit(true);
			pps.setAdminOsList(true);
			pps.setAdminOsDelete(true);
			
			pps.setAdminClienteNew(true);
			pps.setAdminClienteEdit(true);
			pps.setAdminClienteDelete(true);
			pps.setAdminClienteList(true);
			
			pps.setAdminFinanceiroNew(true);
			pps.setAdminFinanceiroEdit(true);
			pps.setAdminFinanceiroDelete(true);
			pps.setAdminFinanceiroList(true);
						
			pps.setAdminFuncionarioNew(true);
			pps.setAdminFuncionarioEdit(true);
			pps.setAdminFuncionarioDelete(true);
			pps.setAdminFuncionarioList(true);
			
//			novo = true;
//			editar = true;
//			excluir = true;
//			listar = true;
			break;
		case ONLY_WRITE:
			
			pps.setGerOsNew(false);
			pps.setGerOsEdit(true);
			pps.setGerOsList(true);
			pps.setGerOsDelete(false);
			

			pps.setGerClienteNew(false);
			pps.setGerClienteEdit(true);
			pps.setGerClienteDelete(false);
			pps.setGerClienteList(true);
			
			pps.setGerFinanceiroNew(false);
			pps.setGerFinanceiroEdit(true);
			pps.setGerFinanceiroDelete(false);
			pps.setGerFinanceiroList(true);
			
			pps.setGerFuncionarioNew(false);
			pps.setGerFuncionarioEdit(true);
			pps.setGerFuncionarioDelete(false);
			pps.setGerFuncionarioList(true);

			
			pps.setSupOsNew(false);
			pps.setSupOsEdit(true);
			pps.setSupOsList(true);
			pps.setSupOsDelete(false);
			
			pps.setSupClienteNew(false);
			pps.setSupClienteEdit(true);
			pps.setSupClienteDelete(false);
			pps.setSupClienteList(true);
			
			pps.setSupFinanceiroNew(false);
			pps.setSupFinanceiroEdit(true);
			pps.setSupFinanceiroDelete(false);
			pps.setSupFinanceiroList(true);
			
			
			pps.setTecOsNew(false); 
			pps.setTecOsEdit(true); 
			pps.setTecOsList(true);
			pps.setTecOsDelete(false);
			
//			novo = false;
//			editar = true;
//			excluir = false;
//			listar = true;
			break;
		case ONLY_READ:
			
			
			pps.setTecOsNew(true);
			pps.setTecOsEdit(false);
			pps.setTecOsList(true);
			pps.setTecOsDelete(false);
					
			
//			novo = false;
//			editar = false;
//			excluir = false;
//			listar = true;
			break;
		}
		
		System.out.println("CONTROLE NOVO == " + novo);
		
//		if(controle == "novo") return novo;
//		if(controle == "editar") return editar;
//		if(controle == "excluir") return excluir;
//		if(controle == "listar") return listar;
		
		manager.close();
		
//		return false;
	}

	public PermissoesPaginas getPps() {
		return pps;
	}
	
//	public boolean render() {
//		
//	}
	
	
}

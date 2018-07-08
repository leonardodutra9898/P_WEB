package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.ufc.crateus.os.controller.PermissoesPaginas;
import br.ufc.crateus.os.enums.FuncionarioFuncoes;
import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.enums.PermissoesTipos;
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
	
	public void setPermissoesPaginas(FuncionarioFuncoes perfil) {
		
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		PermissoesRepository permissoesRepo = new PermissoesRepository(manager);
		
		List<Permissoes> listTemp = permissoesRepo.listPermissoesByPerfilEntidade(perfil);

		Permissoes[] permissao = new Permissoes[listTemp.size()];
		int count = 0;
		
		for(Permissoes pe : listTemp) {
			permissao[count++] = pe;
		}
		
		for(int i = 0; i < listTemp.size(); i++) {
		
			pps = new PermissoesPaginas();
				
			if(permissao[i].getTipoPermissao()==PermissoesTipos.FULL) {

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
			
			} else if(permissao[i].getTipoPermissao()==PermissoesTipos.ONLY_WRITE) {

				if(permissao[i].getPerfil()==FuncionarioFuncoes.GERENTE) {
					pps.setGerOsNew(false);
					pps.setGerOsEdit(true);
					pps.setGerOsList(true);
					pps.setGerOsDelete(false);
					
	
					pps.setGerClienteNew(false);
					pps.setGerClienteEdit(true);
					pps.setGerClienteDelete(false);
					pps.setGerClienteList(true);
					
					pps.setGerFinanceiroNew(false);
					pps.setGerFinanceiroEdit(false);
					pps.setGerFinanceiroDelete(false);
					pps.setGerFinanceiroList(true);
					
					pps.setGerFuncionarioNew(false);
					pps.setGerFuncionarioEdit(true);
					pps.setGerFuncionarioDelete(false);
					pps.setGerFuncionarioList(true);				
				} else if(permissao[i].getPerfil()==FuncionarioFuncoes.SUPERVISOR) {
					pps.setSupOsNew(false);
					pps.setSupOsEdit(true);
					pps.setSupOsList(true);
					pps.setSupOsDelete(false);
					
					pps.setSupClienteNew(false);
					pps.setSupClienteEdit(true);
					pps.setSupClienteDelete(false);
					pps.setSupClienteList(true);
					
					pps.setSupFinanceiroNew(true);
					pps.setSupFinanceiroEdit(true);
					pps.setSupFinanceiroDelete(false);
					pps.setSupFinanceiroList(true);
				} else {
					pps.setTecOsNew(false); 
					pps.setTecOsEdit(true); 
					pps.setTecOsList(true);
					pps.setTecOsDelete(false);
				}
			} else if(permissao[i].getTipoPermissao()==PermissoesTipos.ONLY_READ) {

				pps.setTecOsNew(true);
				pps.setTecOsEdit(false);
				pps.setTecOsList(true);
				pps.setTecOsDelete(false);
				
				pps.setTecClienteNew(true);
				pps.setTecClienteEdit(true);
				pps.setTecClienteDelete(true);
				pps.setTecClienteList(true);
			} 
		
		} // final do for
		
		manager.close();

	}

	public PermissoesPaginas getPps() {
		return pps;
	}

	public void setPps(PermissoesPaginas pps) {
		this.pps = pps;
	}

}

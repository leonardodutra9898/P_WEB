package br.ufc.crateus.os.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.crateus.os.enums.EntidadeSistema;
import br.ufc.crateus.os.enums.FuncionarioFuncoes;
import br.ufc.crateus.os.enums.PermissoesTipos;
import br.ufc.crateus.os.model.Permissoes;

public class PermissoesRepository implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static EntityManager manager;
	
	public PermissoesRepository(EntityManager manager) {
		
		PermissoesRepository.manager = manager;
	}
	
	public List<Permissoes> listPermissoes(){
		
		TypedQuery<Permissoes> query = manager.createQuery("from Permissoes", Permissoes.class);
		return query.getResultList();
	}

	public List<Permissoes> listPermissoesByPerfil(FuncionarioFuncoes perfil){
		
		TypedQuery<Permissoes> query = manager.createQuery("SELECT p FROM Permissoes p WHERE perfil = :perf", 
				Permissoes.class).setParameter("perf", perfil);
		return query.getResultList();
	}

	public List<Permissoes> listPermissoesByPerfilEntidade(FuncionarioFuncoes perfil){
		
		TypedQuery<Permissoes> query = manager.createQuery("SELECT p FROM Permissoes p WHERE perfil = :perf", 
				Permissoes.class).setParameter("perf", perfil);
		return query.getResultList();
	}
	
	public void carregaPermissoesIni() {
		
		Permissoes p1 = new Permissoes(2, FuncionarioFuncoes.ADMINISTRADOR, PermissoesTipos.FULL, EntidadeSistema.CLIENTE);
		Permissoes p2 = new Permissoes(3, FuncionarioFuncoes.ADMINISTRADOR, PermissoesTipos.FULL, EntidadeSistema.FINANCEIRO);
		Permissoes p3 = new Permissoes(4, FuncionarioFuncoes.ADMINISTRADOR, PermissoesTipos.FULL, EntidadeSistema.FUNCIONARIO);
		Permissoes p4 = new Permissoes(5, FuncionarioFuncoes.ADMINISTRADOR, PermissoesTipos.FULL, EntidadeSistema.OS);
		addPermissao(p1);
		addPermissao(p2);
		addPermissao(p3);
		addPermissao(p4);
		
		Permissoes p5 = new Permissoes(6, FuncionarioFuncoes.GERENTE, PermissoesTipos.ONLY_WRITE, EntidadeSistema.CLIENTE);
		Permissoes p6 = new Permissoes(7, FuncionarioFuncoes.GERENTE, PermissoesTipos.ONLY_WRITE, EntidadeSistema.FINANCEIRO);
		Permissoes p7 = new Permissoes(8, FuncionarioFuncoes.GERENTE, PermissoesTipos.ONLY_WRITE, EntidadeSistema.FUNCIONARIO);
		Permissoes p8 = new Permissoes(9, FuncionarioFuncoes.GERENTE, PermissoesTipos.ONLY_WRITE, EntidadeSistema.OS);
		addPermissao(p5);		
		addPermissao(p6);
		addPermissao(p7);
		addPermissao(p8);
		
		Permissoes p9 = new Permissoes(10, FuncionarioFuncoes.SUPERVISOR, PermissoesTipos.ONLY_WRITE, EntidadeSistema.CLIENTE);
		Permissoes p10 = new Permissoes(11, FuncionarioFuncoes.SUPERVISOR, PermissoesTipos.ONLY_WRITE, EntidadeSistema.FINANCEIRO);
		Permissoes p11 = new Permissoes(12, FuncionarioFuncoes.SUPERVISOR, PermissoesTipos.ONLY_WRITE, EntidadeSistema.OS);
		addPermissao(p9);
		addPermissao(p10);
		addPermissao(p11);
		
		Permissoes p12 = new Permissoes(13, FuncionarioFuncoes.TECNICO, PermissoesTipos.ONLY_WRITE, EntidadeSistema.CLIENTE);
		Permissoes p13 = new Permissoes(14, FuncionarioFuncoes.TECNICO, PermissoesTipos.ONLY_READ, EntidadeSistema.OS);
		addPermissao(p12);
		addPermissao(p13);
		
	}
	
	private void addPermissao(Permissoes perm) {
		manager.merge(perm);
	}
	
	public Permissoes permissaoByPerfil(FuncionarioFuncoes perfil) {
		return manager.find(Permissoes.class, perfil);
	}
}

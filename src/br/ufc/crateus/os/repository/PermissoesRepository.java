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
	
	public void carregaPermissoesIni() {
		List<EntidadeSistema> listP1 = new ArrayList<>();
		
		listP1.add(EntidadeSistema.CLIENTE);
		listP1.add(EntidadeSistema.FINANCEIRO);
		listP1.add(EntidadeSistema.FUNCIONARIO);
		listP1.add(EntidadeSistema.OS);
		
		Permissoes p1 = new Permissoes(1, FuncionarioFuncoes.ADMINISTRADOR, PermissoesTipos.FULL, listP1);
		addPermissao(p1);
		
		
		List<EntidadeSistema> listP2 = new ArrayList<>();
		
		listP2.add(EntidadeSistema.CLIENTE);
		listP2.add(EntidadeSistema.FINANCEIRO);
		listP2.add(EntidadeSistema.FUNCIONARIO);
		listP2.add(EntidadeSistema.OS);
		
		Permissoes p2 = new Permissoes(2, FuncionarioFuncoes.GERENTE, PermissoesTipos.ONLY_WRITE, listP2);
		addPermissao(p2);		

		
		List<EntidadeSistema> listP3 = new ArrayList<>();
		
		listP3.add(EntidadeSistema.CLIENTE);
		listP3.add(EntidadeSistema.FINANCEIRO);
		listP3.add(EntidadeSistema.OS);
		
		Permissoes p3 = new Permissoes(3, FuncionarioFuncoes.SUPERVISOR, PermissoesTipos.ONLY_WRITE, listP3);
		addPermissao(p3);
		
		
		List<EntidadeSistema> listP4 = new ArrayList<>();
		
		listP4.add(EntidadeSistema.CLIENTE);
		listP4.add(EntidadeSistema.OS);
		
		Permissoes p4 = new Permissoes(4, FuncionarioFuncoes.TECNICO, PermissoesTipos.ONLY_WRITE, listP4);
		addPermissao(p4);
		
	}
	
	private void addPermissao(Permissoes perm) {
		manager.merge(perm);
	}
	
	public Permissoes permissaoByPerfil(FuncionarioFuncoes perfil) {
		return manager.find(Permissoes.class, perfil);
	}
	
/*	public static Cliente getClienteById(int id) {
		return manager.find(Cliente.class, id);
	}
*/	
/*	public void delete(Cliente cliente) {
		manager.remove(manager.getReference(Cliente.class, cliente.getId()));
	}*/
	
}

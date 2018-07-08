package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.model.Permissoes;
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

	MessagesUtils msgUtils;
	
	public PermissoesBean() {

		EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		try {
			manager.getTransaction().begin();
			
			PermissoesRepository permissoesRepo = new PermissoesRepository(manager);
			permissoesRepo.carregaPermissoesIni();

			
			manager.getTransaction().commit();

			msgUtils = new MessagesUtils("Permissões carregadas", "Carregado!", MessagesTypes.SUCCESS);
			
			permissoes = permissoesRepo.listPermissoes();
			
		}catch(Exception e) {
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Erro ao tentar carregar permissões", ("Erro: " + e.toString()), 
					MessagesTypes.ERROR);
		} finally {
			manager.close();
		}
	}

	public List<Permissoes> listPermissoes() {
		return permissoes;
	}
}

package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.sun.media.sound.FFT;

import br.ufc.crateus.os.enums.FinanceiroEnum;
import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.enums.Status;
import br.ufc.crateus.os.enums.TipoLancamento;
import br.ufc.crateus.os.model.Cliente;
import br.ufc.crateus.os.model.Financeiro;
import br.ufc.crateus.os.model.Funcionario;
import br.ufc.crateus.os.model.OS;
import br.ufc.crateus.os.repository.ClienteRepository;
import br.ufc.crateus.os.repository.FinanceiroRepository;
import br.ufc.crateus.os.repository.FuncionarioRepository;
import br.ufc.crateus.os.repository.OSRepository;
import br.ufc.crateus.os.utils.dao.EntityManagerPersistence;
import br.ufc.crateus.os.utils.messages.MessagesUtils;

@Named
@ManagedBean(name = "osBean")
@ApplicationScoped
public class OSBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<OS> listOS;
	private List<OS> osa;
	private OS os;
	private int idCliSetado;
	private int idFuncionarioSetado;
	private OS nOS;
	private OS osEdit;

	MessagesUtils msgUtils;

	public OSBean() {

		EntityManager manager = EntityManagerPersistence.getEntityManager();
		OSRepository osRepo = new OSRepository(manager);

		os = new OS();
		listOS = osRepo.listOS();
		osa = osRepo.listOSAbertos();
		nOS = new OS();
		manager.close();
		osEdit = new OS();
	

	}
	
//	@PostConstruct
	public void init() {

		EntityManager manager = EntityManagerPersistence.getEntityManager();
		OSRepository osRepo = new OSRepository(manager);
		
		osa = osRepo.listOSAbertos();
		listOS = osRepo.listOS();
		
		manager.close();
		
	}

	public List<OS> getListOS() {
		return listOS;
	}

	public OS getOs() {
		return os;
	}

	public void setOs(OS os) {
		this.os = os;
	}

	public void novoOS() {

		EntityManager manager = EntityManagerPersistence.getEntityManager();

		try {
			manager.getTransaction().begin();
			OSRepository osRepo = new OSRepository(manager);

			nOS.setDataAbertura(Calendar.getInstance().getTime());
			nOS.setStatus(Status.ABERTO);
			
			ClienteRepository cliRepo = new ClienteRepository(manager);
			Cliente clienteSelect = cliRepo.clienteById(idCliSetado);
			FuncionarioRepository funRepo = new FuncionarioRepository(manager);
			Funcionario funcionarioSelect = funRepo.funcionarioById(idFuncionarioSetado);
			
			nOS.setFuncionario(funcionarioSelect);
			nOS.setCliente(clienteSelect);
			
			osRepo.addOS(nOS);
			
			msgUtils = new MessagesUtils("Nova Ordem de Serviço registrada!", "Nova Ordem de Serviço registrada!", MessagesTypes.SUCCESS);
			manager.getTransaction().commit();
			
			nOS = new OS();
			listOS = osRepo.listOS();

		} catch (Exception e) {
			manager.getTransaction().rollback();

			msgUtils = new MessagesUtils("Ordem de Serviço - Registro não pode ser salvo",
					("OS não pode ser registrada... " + e.toString()), MessagesTypes.ERROR);
		} finally {
			manager.close();
		}
	}

	public OS searchById(int idOS) {
		
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		try {
		
			OSRepository osRepo = new OSRepository(manager);
			manager.getTransaction().begin();
			return osRepo.osById(idOS);
		
		}catch(Exception e) {
			System.out.println("Erro ao tentar consultar OS individual");
		}finally {
			manager.close();
		}

		return null;
	}

	public OS searchById() {

		for (OS c : listOS) {

			if (c.getId() == os.getId()) {
				return c;
			}
		}

		return null;
	}

	public String searchEdit(OS oo) {
		
		EntityManager manager = EntityManagerPersistence.getEntityManager();
		
		try {
		
			OSRepository osRepo = new OSRepository(manager);
			manager.getTransaction().begin();
			OS temp = osRepo.osById(oo.getId());
			osEdit = temp;
			
		}catch(Exception e) {
			System.out.println("Erro ao tentar consultar OS individual");
		}finally {
			manager.close();
		}
		return "/os/editOS?faces-redirect=true";
	}

	public void atualizarOS() {

		EntityManager manager = EntityManagerPersistence.getEntityManager();

		try {

			manager.getTransaction().begin();
			OSRepository osRepo = new OSRepository(manager);
			osRepo.addOS(osEdit);
			
			osEdit = new OS();

			msgUtils = new MessagesUtils("Atualização realizada com sucesso em Ordem de Serviço...",
					"Atualização concluída", MessagesTypes.SUCCESS);

			manager.getTransaction().commit();
			
			listOS = osRepo.listOS();

		} catch (Exception e) {
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Erro ao tentar atualizar OS...",
					("Erro ao atualizar... " + e.toString()), MessagesTypes.ERROR);
		} finally {
			manager.close();
		}
	}

	public int getIdCliSetado() {
		return idCliSetado;
	}

	public void setIdCliSetado(int idCliSetado) {
		this.idCliSetado = idCliSetado;
	}

	public void remove() {

		EntityManager manager = EntityManagerPersistence.getEntityManager();

		try {

			manager.getTransaction().begin();
			OSRepository osRepo = new OSRepository(manager);
			osRepo.osById(os.getId());
			osRepo.delete(os);

			manager.getTransaction().commit();

			msgUtils = new MessagesUtils("Exclusão de OS realizada...", "Exclusão concluída", MessagesTypes.SUCCESS);

			listOS = osRepo.listOS();
			os = new OS();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			msgUtils = new MessagesUtils("Pode haver dependência desse registro em outra entidade...", ("OS não removida... " + e.toString()),
					MessagesTypes.ERROR);
		} finally {
			manager.close();
		}

	}

	public OS getnOS() {
		return nOS;
	}

	public void setnOS(OS nOS) {
		this.nOS = nOS;
	}
	
	public Status[] getStatuses(){
		   return Status.values();
		 }

	public OS getOsEdit() {
		return osEdit;
	}

	public void setOsEdit(OS osEdit) {
		this.osEdit = osEdit;
	}

	public int getIdFuncionarioSetado() {
		return idFuncionarioSetado;
	}

	public void setIdFuncionarioSetado(int idFuncionarioSetado) {
		this.idFuncionarioSetado = idFuncionarioSetado;
	}

	public List<OS> getOsa() {
		return osa;
	}
	

}

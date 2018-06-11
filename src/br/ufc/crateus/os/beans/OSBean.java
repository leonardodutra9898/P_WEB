package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.ufc.crateus.os.enums.Status;
import br.ufc.crateus.os.model.OS;

@ManagedBean(name="osBean")
@ApplicationScoped
public class OSBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<OS> listOS;
	private OS os;
	int count = 0;
	
	
	public OSBean() {
		os = new OS();
		listOS = new ArrayList<OS>();
	}
	
	@PostConstruct
	public void init() {
		
//		OS os1 = new OS();
//		os1.setId(1);
//		os1.setDescricao("Trêta com meu navegador");
//		os1.setPrioridade(1);
//		os1.setStatus(Status.ABERTO);
//		os1.setDataAbertura(Calendar.getInstance().getTime());
//
//		OS os2 = new OS();
//		os2.setId(2);
//		os2.setDescricao("Sem internet");
//		os2.setPrioridade(5);
//		os2.setStatus(Status.ANDAMENTO);
//		os2.setDataAbertura(Calendar.getInstance().getTime());
//		
//		OS os3 = new OS();
//		os3.setId(3);
//		os3.setDescricao("Mouse não funciona");
//		os3.setPrioridade(2);
//		os3.setStatus(Status.ANDAMENTO);
//		os3.setDataAbertura(Calendar.getInstance().getTime());
//		
//		OS os4 = new OS();
//		os4.setId(4);
//		os4.setDescricao("Sem energia");
//		os4.setPrioridade(10);
//		os4.setStatus(Status.ABERTO);
//		os4.setDataAbertura(Calendar.getInstance().getTime());
		

//		listOS.add(os1);
//		listOS.add(os2);
//		listOS.add(os3);
//		listOS.add(os4);
		

		
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

		
		os.setDataAbertura(Calendar.getInstance().getTime());
		os.setId(++count);
		os.setStatus(Status.ABERTO);
		
		
		listOS.add(os);
		//list();
		
		System.out.println("Tamanho da lista: " + listOS.size());
	}
	
	public void list() {
		
		for(OS o : listOS) {
			
			System.out.println(o.getId() + " -- " + o.getDescricao() + " -- " + o.getStatus());
		}
	}
	
}

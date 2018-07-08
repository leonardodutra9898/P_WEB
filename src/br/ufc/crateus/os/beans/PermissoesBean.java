package br.ufc.crateus.os.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import br.ufc.crateus.os.model.Permissoes;

@Named
@ManagedBean(name="pBean")
@ApplicationScoped
public class PermissoesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Permissoes> permissoes;
	
	public void carregaPermissoes() {
		
	}
	
	public PermissoesBean() {
		permissoes = new ArrayList<Permissoes>();
	}

	public List<Permissoes> listPermissoes() {
		return permissoes;
	}
}

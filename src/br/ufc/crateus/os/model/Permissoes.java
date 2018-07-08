package br.ufc.crateus.os.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.ufc.crateus.os.enums.EntidadeSistema;
import br.ufc.crateus.os.enums.FuncionarioFuncoes;
import br.ufc.crateus.os.enums.PermissoesTipos;

@Entity
public class Permissoes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private FuncionarioFuncoes perfil;
	
	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private PermissoesTipos tipoPermissao;
	
	private List<EntidadeSistema> entidades = new ArrayList<>();

	public Permissoes() {
		
	}
	
	public Permissoes(int id, FuncionarioFuncoes perfil, PermissoesTipos tipo, List<EntidadeSistema> entidades) {
		this.id = id;
		this.perfil = perfil;
		this.tipoPermissao = tipo;
		this.entidades = entidades;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FuncionarioFuncoes getPerfil() {
		return perfil;
	}

	public void setPerfil(FuncionarioFuncoes perfil) {
		this.perfil = perfil;
	}

	public PermissoesTipos getTipoPermissao() {
		return tipoPermissao;
	}

	public void setTipoPermissao(PermissoesTipos tipoPermissao) {
		this.tipoPermissao = tipoPermissao;
	}

	public List<EntidadeSistema> getEntidades() {
		return entidades;
	}

	public void setEntidades(List<EntidadeSistema> entidades) {
		this.entidades = entidades;
	}
	
}

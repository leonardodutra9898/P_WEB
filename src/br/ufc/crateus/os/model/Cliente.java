package br.ufc.crateus.os.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(length = 200, nullable = false)
	private String endereco;
	
	@Column(length = 15, nullable = false)
	private String cpf;
	
	@Column(length = 100, nullable = false)
	private String email;
	
	@OneToMany(cascade = CascadeType.REFRESH)
	private List<OS> listOS = new ArrayList<OS>();
	
	public Cliente() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	public List<OS> getListOS() {
		return listOS;
	}
	public void setListOS(List<OS> listOS) {
		this.listOS = listOS;
	}
}

package br.ufc.crateus.os.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String nome;
	private String endereco;
	
	private String cpf;
	private String email;
	
	
	private List<OS> listOS = new ArrayList<OS>();
	
	public Cliente() {
		
	}
	
//	public Cliente(Integer id, String nome, String endereco, String cpf, String email) {
//		this.id = id;
//		this.nome = nome;
//		this.endereco = endereco;
//		this.cpf = cpf;
//		this.email = email;
//	}
	
	@Id
	@GeneratedValue
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

	
	@OneToMany
	public List<OS> getListOS() {
		return listOS;
	}
	public void setListOS(List<OS> listOS) {
		this.listOS = listOS;
	}


	
//	public String toString() {
//		return "ID => " + getId() + "\nNome => " + getNome() + "\nE-mail => " + getEmail() + "\nEndereço => " + getEndereco()
//			+ "\nCPF => " + getCpf() + "\nTotal de OS na lista por cliente => " + getListOS().size();
//	}

}

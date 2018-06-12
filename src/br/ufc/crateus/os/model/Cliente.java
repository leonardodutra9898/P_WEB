package br.ufc.crateus.os.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	private String nome;
	private String endereco;
	private String cpf;
	private String email;
	private List<OS> listOS = new ArrayList<OS>();
	
	public Cliente() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
	public String toString() {
		return "ID => " + getId() + "\nNome Cli => " + getNome() + "\nE-mail => " + getEmail() + "\nCPF => " + getCpf() + 
					"\nEndereço => " + getEndereco();
	}
	
	
//	public void listarOS() {
//		
//	}
	
}

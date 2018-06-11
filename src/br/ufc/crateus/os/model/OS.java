package br.ufc.crateus.os.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import br.ufc.crateus.os.enums.Status;

public class OS implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Cliente idCliente;
	private Date dataAbertura;
	private Calendar dataFechamento;
	private Status status;
	private String descricao;
	private Tecnico idTecnico;
	private int prioridade;
	
	public OS() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date calendar) {
		this.dataAbertura = calendar;
	}
	public Calendar getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(Calendar dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Tecnico getIdTecnico() {
		return idTecnico;
	}
	public void setIdTecnico(Tecnico idTecnico) {
		this.idTecnico = idTecnico;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	
	
}

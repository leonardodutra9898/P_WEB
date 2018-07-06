package br.ufc.crateus.os.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.ufc.crateus.os.enums.Status;

@Entity
public class OS implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date dataAbertura;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataFechamento;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(length = 255, nullable = false)
	private String descricao;
	
	private int prioridade;
	
	@Lob
	@ManyToOne
	private Cliente cliente;

	//	private Funcionario funcionario;
	
	public OS() {
		
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

//	@JoinColumn()
//	@ManyToOne
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}

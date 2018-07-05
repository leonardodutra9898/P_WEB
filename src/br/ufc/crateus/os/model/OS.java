package br.ufc.crateus.os.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.ufc.crateus.os.enums.FuncionarioFuncoes;
import br.ufc.crateus.os.enums.Status;

@Entity
public class OS implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 100, nullable = false)
	private String nomeCliente;
	
	@Temporal(TemporalType.DATE)
	private Date dataAbertura;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataFechamento;
	
	private Status status;
	
	@Column(length = 255, nullable = false)
	private String descricao;
	
//	private Funcionario tecnico;
	private int prioridade;
	private FuncionarioFuncoes gravidade;
	private Cliente cliente;
	
	public OS() {
		
	}
	
	
	
	public FuncionarioFuncoes getGravidade() {
		return gravidade;
	}



	public void setGravidade(FuncionarioFuncoes gravidade) {
		this.gravidade = gravidade;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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

	
//	public Funcionario getTecnico() {
//		return tecnico;
//	}
//
//
//
//	public void setTecnico(Funcionario tecnico) {
//		this.tecnico = tecnico;
//	}



	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}



	public String getNomeCliente() {
		return nomeCliente;
	}



	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	@JoinColumn(name="cliente_id")
	@ManyToOne
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
}

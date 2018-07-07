package br.ufc.crateus.os.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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

import br.ufc.crateus.os.enums.FinanceiroEnum;
import br.ufc.crateus.os.enums.TipoLancamento;

@Entity
public class Financeiro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private int id;
	
	@Lob
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Cliente cliente;
	
	@Column(length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private FinanceiroEnum status;

	@Column(length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoLancamento tipoLancamento;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Funcionario funcionario;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	private OS os;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public FinanceiroEnum getStatus() {
		return status;
	}
	public void setStatus(FinanceiroEnum status) {
		this.status = status;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public OS getOs() {
		return os;
	}
	public void setOs(OS os) {
		this.os = os;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}
	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}
	
	
}

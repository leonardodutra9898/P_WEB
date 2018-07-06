package br.ufc.crateus.os.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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
	
	@Enumerated(EnumType.STRING)
	private FinanceiroEnum status;

	@Enumerated(EnumType.STRING)
	private TipoLancamento tipoLancamento;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Funcionario funcionario;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	private OS os;
	
	private double valorOrcamentoOS;
	
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
	public double getValorOrcamentoOS() {
		return valorOrcamentoOS;
	}
	public void setValorOrcamentoOS(double valorOrcamentoOS) {
		this.valorOrcamentoOS = valorOrcamentoOS;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + id;
		result = prime * result + ((os == null) ? 0 : os.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorOrcamentoOS);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Financeiro other = (Financeiro) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (id != other.id)
			return false;
		if (os == null) {
			if (other.os != null)
				return false;
		} else if (!os.equals(other.os))
			return false;
		if (status != other.status)
			return false;
		if (Double.doubleToLongBits(valorOrcamentoOS) != Double.doubleToLongBits(other.valorOrcamentoOS))
			return false;
		return true;
	}
	
	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}
	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}
	
	
}

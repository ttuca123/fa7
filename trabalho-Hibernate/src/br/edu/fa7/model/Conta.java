/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.fa7.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.fa7.bean.MesaBean;

@Entity
@Table(name = "conta")
public class Conta extends BaseModel {

	private static final long serialVersionUID = -5366628231248555232L;

	public Conta(Mesa mesa) {
		this.mesa = mesa;
	}

	public Conta(int staFormaPgto, Date dtPgto, Mesa mesa) {
		this.staFormaPgto = staFormaPgto;
		this.dataPgto = dtPgto;
		this.mesa = mesa;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_pgto")
	private Long seqPagamento;

	@Column(name = "sta_forma_pgto", nullable = false)
	private int staFormaPgto;

	@Column(name = "total_pgto", nullable = false)
	private Double totalPago;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_pgto", nullable = false)
	protected Date dataPgto;

	@OneToOne
	private Mesa mesa;

	public int getStaFormaPgto() {
		return staFormaPgto;
	}

	public void setStaFormaPgto(int staFormaPgto) {
		this.staFormaPgto = staFormaPgto;
	}

	public Long getSeqPagamento() {
		return seqPagamento;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Date getDataPgto() {
		return dataPgto;
	}

	public void setDataPgto(Date dataPgto) {
		this.dataPgto = dataPgto;
	}

	public Double getTotal() {
		return totalPago;
	}

	public void setTotal(Double total) {
		this.totalPago = total;
	}

//	public Double calculaSaldoDevedor() {
//
//		return totalPago - mesa.calculaTotal();
//	}

}
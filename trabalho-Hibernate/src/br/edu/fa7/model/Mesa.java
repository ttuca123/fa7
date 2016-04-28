package br.edu.fa7.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mesa")
public class Mesa extends BaseModel {

	private static final long serialVersionUID = -5366628231248555232L;

	public Mesa() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_mesa")
	private int seqMesa;

	@Column(name = "is_alocada")
	private boolean alocada = false;

	@Column(name = "is_encerrada")
	private boolean encerrada = false;

	@ManyToOne(cascade = CascadeType.ALL)
	private Garcom garcom;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Pedido pedido;

	public boolean isEncerrada() {
		return encerrada;
	}

	public Pedido getPedido() {
		if(pedido ==null){
			
			pedido = new Pedido();
			pedido.setDataRegistro(new Date());
		}
		
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void setEncerrada(boolean encerrada) {
		this.encerrada = encerrada;
	}

	public boolean isAlocada() {
		return alocada;
	}

	public void setAlocada(boolean alocada) {
		this.alocada = alocada;
	}

	public Garcom getGarcom() {
		return garcom;
	}

	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
	}

	public int getSeqMesa() {
		return seqMesa;
	}

	// public Double calculaTotal() {
	//
	// MesaBean mesaBean = new MesaBean();
	// Mesa mesa = mesaBean.getMesa();
	//
	// for (Pedido pedido : mesa.getPedidos()) {
	//
	// for (ItemCardapio item : pedido.getItensPedido()) {
	// total += item.getPreco() * item.getQuantidade();
	// }
	// }
	// return total;
	// }

}

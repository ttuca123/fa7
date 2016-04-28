package br.edu.fa7.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.fa7.dao.PedidoDAO;

@Entity
@Table(name = "pedido")
public class Pedido extends BaseModel {

	private static final long serialVersionUID = -5366628231248555232L;

	public Pedido() {

	}

	public Pedido(List<ItemCardapio> itensCardapio) {
		this.itensPedido = itensCardapio;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_pedido")
	private Long seqPedido;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pedido_item")
	private Collection<ItemCardapio> itensPedido;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_registro")
	@Basic(optional = true)
	protected Date dataRegistro;
	
	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	@javax.persistence.Transient
	private Double total = null;

	public Long getSeqPedido() {
		return seqPedido;
	}

	public Collection<ItemCardapio> getItensPedido() {

		if (new PedidoDAO().getItensById(seqPedido) == null) {

			itensPedido = new ArrayList<>();
		}

		return itensPedido;
	}

	public void setItensPedido(Collection<ItemCardapio> itensPedido) {

		this.itensPedido = itensPedido;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
}

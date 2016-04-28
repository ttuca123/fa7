package br.edu.fa7.loja.vo;

import java.io.Serializable;

import br.edu.fa7.loja.entity.Compra;

public class CompraVO implements Serializable {

	private static final long serialVersionUID = -7216404701562101346L;

	private Compra compra;

	private ClienteVO clienteVO;

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public ClienteVO getClienteVO() {
		return clienteVO;
	}

	public void setClienteVO(ClienteVO clienteVO) {
		this.clienteVO = clienteVO;
	}

}

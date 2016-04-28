package br.edu.fa7.loja.services;

import java.io.IOException;
import java.util.List;

import com.mashape.unirest.http.exceptions.UnirestException;

import br.edu.fa7.loja.entity.Compra;
import br.edu.fa7.loja.vo.ClienteVO;

public interface CompraService {

	public Compra getCompra(Long id);

	public List<Compra> getCompras();

	public void comprar(Compra compra);

	public ClienteVO getCliente(Long seqCliente) throws  Exception;

}

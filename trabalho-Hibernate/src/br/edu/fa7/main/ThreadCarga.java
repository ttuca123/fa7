package br.edu.fa7.main;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;

import br.edu.fa7.dao.GarcomDAO;
import br.edu.fa7.dao.ItemCardapioDAO;
import br.edu.fa7.dao.MesaDAO;
import br.edu.fa7.dao.PedidoDAO;
import br.edu.fa7.model.Garcom;
import br.edu.fa7.model.ItemCardapio;
import br.edu.fa7.model.Mesa;
import br.edu.fa7.model.Pedido;

public class ThreadCarga extends Thread {

	List<Mesa> mesas;
	List<Garcom> garcons;
	List<ItemCardapio> itens;
	MesaDAO mesaDAO = new MesaDAO();
	GarcomDAO garcomDAO = new GarcomDAO();
	PedidoDAO pedidoDAO = new PedidoDAO();

	public ThreadCarga() {

		MesaDAO mesaDAO = new MesaDAO();

		GarcomDAO garcomDAO = new GarcomDAO();
		ItemCardapioDAO itemCardapioDAO = new ItemCardapioDAO();

		mesas = mesaDAO.listarTodosAtivos(Mesa.class);
		garcons = garcomDAO.listarTodosAtivos(Garcom.class);
		itens = itemCardapioDAO.listarTodosAtivos(ItemCardapio.class);

	}

	private void realizarTesteCarga() {

		Mesa mesa = mesas.get(RandomUtils.nextInt(30));
		Garcom garcom = garcons.get(RandomUtils.nextInt(10));
		itens.add(itens.get(0));
		Pedido pedido = new Pedido(itens);
		pedido.setDataRegistro(new Date());
		mesa.setPedido(pedido);

		mesa.setGarcom(garcom);

		mesaDAO.salvar(mesa);

		System.out.println("Pedido Cadastrado Com Sucesso!!!");
		mesa.getPedido().setEstaAtivo(false);
		mesaDAO.salvar(mesa);
		System.out.println("Pedido Fechado Com Sucesso!!!");

	}

	@Override
	public void run() {
		realizarTesteCarga();

	}
}

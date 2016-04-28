package br.edu.fa7.bean;

import java.util.List;
import java.util.Scanner;

import br.edu.fa7.dao.MesaDAO;
import br.edu.fa7.dao.PedidoDAO;
import br.edu.fa7.model.Mesa;
import br.edu.fa7.model.Pedido;

public class MesaBean {

	private Scanner reader = new Scanner(System.in);
	private MesaDAO mesaDAO = new MesaDAO();
	private List<Mesa> mesas;

	public void manterMesa() throws Exception {
		boolean sair = false;

		do {

			System.out
					.println("\n Por favor, digite a operação desejada para a Mesa:  \n");

			System.out.println("1 -   Listar as mesas ativas \n");
			System.out.println("2 - Registrar \n");
			System.out.println("3 - Excluir \n");
			System.out.println("4 - Encerrar Mesa \n");
			System.out.println("5 - Sair \n");

			System.out.println("Opção: ");
			int optItem = reader.nextInt();

			switch (optItem) {

			case 1:

				exibirMesasAtivas();

				break;

			case 2:

				registrar();

				break;

			case 3:
				excluirMesa();

				break;
			case 4:
				encerrarMesa();
				break;
			case 5:
				sair = true;
				break;
			default:
				break;
			}

		} while (!sair);

	}

	public void encerrarMesa() {

		Mesa mesa = getMesa();
		if (mesa != null) {
			mesa.setEncerrada(true);
			mesaDAO.salvar(mesa);
		}
	}

	public void registrar() throws Exception {

		System.out
				.println("Digite a quantidade de mesas que serão registradas:");
		int qtd = reader.nextInt();

		for (int i = 0; i < qtd; i++) {
			mesaDAO.cadastrarMesa(new Mesa());
		}
		System.out.println(qtd + " Mesa(s) cadastrada(s) com sucesso!!!");

	}

	public Mesa getMesa() {

		System.out.println("Digite número da mesa: ");
		int nrMesa = reader.nextInt();

		return mesaDAO.buscarByNrMesa(nrMesa);

	}

	public Long getMesaByNrPedido(Long nrPedido) {

		return mesaDAO.buscarByNrPedido(nrPedido);

	}

	public void excluirMesa() {

		System.out.println("Digite o número da mesa a ser excluída: ");
		int nrMesa = reader.nextInt();
		Mesa mesa = mesaDAO.buscarByNrMesa(nrMesa);

		if (mesa != null) {
			mesaDAO.deletar(mesa);
			System.out.println("Mesa excluída com sucesso!!!");
		}

	}

	public void exibirMesasAtivas() {

		System.out.println("Mesas disponiveis: ");
		System.out.println("\n");
		mesas = mesaDAO.listarTodosAtivos(Mesa.class);
		for (Mesa mesa : mesas) {

			System.out.println("Número da Mesa: " + mesa.getSeqMesa());
			System.out.println("\n");
		}
		System.out.println("total: " + mesas.size());

	}

}

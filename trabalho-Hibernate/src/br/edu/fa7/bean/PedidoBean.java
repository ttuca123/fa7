package br.edu.fa7.bean;

import java.util.Scanner;

import br.edu.fa7.dao.MesaDAO;
import br.edu.fa7.model.Garcom;
import br.edu.fa7.model.ItemCardapio;
import br.edu.fa7.model.Mesa;

public class PedidoBean {

	private Scanner reader = new Scanner(System.in);

	private ItemCardapioBean itemCardapioBean = new ItemCardapioBean();
	private MesaBean mesaBean = new MesaBean();
	private GarcomBean garconBean = new GarcomBean();
	private MesaDAO mesaDAO = new MesaDAO();

	public void manterPedido() throws Exception {
		boolean sair = false;

		do {

			System.out
					.println("\n Por favor, digite a operação desejada para o Pedido:  \n");

			System.out.println("1 - Incluir pedido \n");
			System.out
					.println("2 - Listar todos os itens do pedido da mesa \n");
			System.out.println("3 - Sair \n");

			System.out.println("Opção: ");
			int optItem = reader.nextInt();

			switch (optItem) {

			case 1:
				incluirPedido();
				break;
			case 2:
				Mesa mesa = mesaBean.getMesa();
				listarItensPedido(mesa);
				break;

			case 3:

				sair = true;

				break;

			default:
				break;
			}

		} while (!sair);

	}

	public void listarItensPedido(Mesa mesa) {

		System.out.println("Pedidos da mesa " + mesa.getSeqMesa());

//		for (ItemCardapio itemCardapio : mesa.getPedido().getItensPedido()) {
//
//			System.out.println("Código do ítem : " + itemCardapio.getSeqItem());
//			System.out.println("Nome do ítem : " + itemCardapio.getNome());
//			System.out.println("\n");
//		}

	}

	private void incluirPedido() {

		int operacao = 1;
		boolean condicao = true;

		Mesa mesa = mesaBean.getMesa();

		if (mesa != null) {
			Garcom garcom = garconBean.getGarcom();
			mesa.setGarcom(garcom);

			System.out.println("Matrícula do Garcom: " + garcom.getMatricula());
			System.out.println("Nome do Garcom: " + garcom.getNome());
			do {

				System.out.println("Digite o código do item escolhido");
				int codigo = reader.nextInt();
				ItemCardapio item = itemCardapioBean.getItemByCodigo(codigo);

				if (item != null) {
					int qtd = 0;
					do {
						System.out.println("Digite a quantidade de "
								+ item.getNome());
						qtd = reader.nextInt();

					} while (qtd <= 0);

					for (int i = 0; i < qtd; i++) {

					//	mesa.getPedido().getItensPedido().add(item);

						System.out.println("Item inserido com sucesso! \n");
					}

					System.out.println("Digite 1 para finalizar o pedido \n");

				} else {
					System.out.println("Item não encontrado ! \n");
				}
				System.out.println("Digite 0 para continuar \n");
				System.out.println("Digite 3 para cancelar o pedido e sair \n");
				System.out.println("Opção \n");
				operacao = reader.nextInt();

				switch (operacao) {
				case 1:
					mesa.setAlocada(true);

					mesaDAO.salvar(mesa);

					condicao = false;
					break;
				case 3:
					condicao = false;
					break;
				default:
					break;
				}

			} while (condicao);
		}
	}

}

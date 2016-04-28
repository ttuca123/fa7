package br.edu.fa7.main;

import java.util.Scanner;

import br.edu.fa7.bean.CargoBean;
import br.edu.fa7.bean.ContaBean;
import br.edu.fa7.bean.GarcomBean;
import br.edu.fa7.bean.ItemCardapioBean;
import br.edu.fa7.bean.MesaBean;
import br.edu.fa7.bean.PedidoBean;

public class Principal {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		inicializarMenu();
	}

	private static void inicializarMenu() throws Exception {
		boolean continuar = true;

		do {
			System.out.println("Sistema Gerenciador de Restaurante \n");

			System.out.println("Por favor, digite a opção  \n");

			System.out.println("1 - Pedido \n");
			System.out.println("2 - Mesa \n");
			System.out.println("3 - EncerrarConta \n");
			System.out.println("4 - ItensPedido \n");
			System.out.println("5 - Garcom \n");
			System.out.println("6 - Cargo \n");
			System.out.println("7 - Sair \n");
			// Reading from System.in
			System.out.println("Opção: ");
			int opt = reader.nextInt();

			switch (opt) {
			case 1:
				PedidoBean pedido = new PedidoBean();
				pedido.manterPedido();
				break;

			case 2:
				MesaBean mesaBean = new MesaBean();
				mesaBean.manterMesa();

				break;
			case 3:
				ContaBean contaBean = new ContaBean();
				contaBean.manterConta();
				break;
			case 4:

				ItemCardapioBean item = new ItemCardapioBean();
				item.manterItemPedido();

				break;
			case 5:
				GarcomBean garcomBean = new GarcomBean();
				garcomBean.manterGarcom();
				break;
			case 6:
				CargoBean cargoBean = new CargoBean();
				cargoBean.manterCargo();
				break;
			case 7:
				continuar = false;
				break;

			default:
				break;
			}
		} while (continuar);

	}

}

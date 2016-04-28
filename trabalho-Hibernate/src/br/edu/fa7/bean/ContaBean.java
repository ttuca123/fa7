package br.edu.fa7.bean;

import java.util.Date;
import java.util.Scanner;

import br.edu.fa7.model.Conta;
import br.edu.fa7.model.Mesa;
import br.edu.fa7.util.EnuFormaPagamento;

public class ContaBean {

	private Scanner reader = new Scanner(System.in);
	private MesaBean mesaBean = new MesaBean();

	public void manterConta() throws Exception {
		boolean sair = false;

		do {

			System.out
					.println("\n Por favor, digite a operação desejada para o Cliente:  \n");

			System.out.println("1 - Encerra Conta \n");
			System.out.println("2 - Sair \n");

			System.out.println("Opção: ");
			int optItem = reader.nextInt();

			switch (optItem) {

			case 1:

				encerrarConta();

				break;

			case 2:

				sair = true;

				break;

			default:
				break;
			}

		} while (!sair);

	}

	public void encerrarConta() {

//		Mesa mesa = mesaBean.getMesa();
//		if (mesa.isAlocada() && mesa.isEncerrada()) {
//			Conta conta = new Conta(mesa);
//			if (conta.calculaSaldoDevedor() >= 0) {
//				System.out.println("Conta ref. á mesa " + mesa.getSeqMesa()
//						+ " encontra-se totalmente paga");
//			} else {
//
//				System.out.println("Tipos de Pagamentos: ");
//				System.out.println("1 - " + EnuFormaPagamento.A_VISTA);
//				System.out.println("2 - " + EnuFormaPagamento.CARTAO);
//
//				System.out
//						.println(" \n Digite o código da forma de Pagamento: ");
//				int codigo = reader.nextInt();
//			}
//
//		}
//		System.out.println("Clientes: ");
//		System.out.println("\n");
		// List<Cliente> clientes = clienteDAO.listarTodosAtivos(Cliente.class);
		// for (Cliente cliente : clientes) {
		//
		// System.out.println("Nome: " + cliente.getNome());
		// System.out.println("Mesa: " + cliente.getMesa().getSeqMesa());
		// System.out.println("\n");
		// }
		// System.out.println("total: " + clientes.size());

	}

}

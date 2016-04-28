package br.edu.fa7.bean;

import java.util.List;
import java.util.Scanner;

import br.edu.fa7.dao.ItemCardapioDAO;
import br.edu.fa7.model.ItemCardapio;

public class ItemCardapioBean {

	private Scanner reader = new Scanner(System.in);
	private ItemCardapioDAO itemCardapioDAO = new ItemCardapioDAO();
	private List<ItemCardapio> itens;

	public void manterItemPedido() throws Exception {
		boolean sair = false;

		do {

			System.out
					.println("\n Por favor, digite a operação desejada para o Item do Cardápio:  \n");

			System.out.println("1 - Listar os Itens do Cardápio \n");
			System.out.println("2 - Registrar \n");
			System.out.println("3 - Excluir \n");
			System.out.println("4 - Sair \n");

			System.out.println("Opção: ");
			int optItem = reader.nextInt();

			switch (optItem) {

			case 1:

				exibirItensAtivos();

				break;
			case 2:
				registrarItem();

				break;

			case 3:
				excluirItem();

				break;

			case 4:

				sair = true;

				break;

			default:
				break;
			}

		} while (!sair);

	}

	public void registrarItem() {

		System.out.println("Nome: ");
		String nomeItem = reader.next();
		System.out.println("Preço: ");
		Double preco = reader.nextDouble();

		try {
			itemCardapioDAO.registrarItem(new ItemCardapio(nomeItem, preco));
			System.out.println("Item cadastrado com sucesso!!!");
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar Pedido!");
			e.printStackTrace();
		}

	}

	public void excluirItem() {

		System.out.println("Digite o código do item a ser excluído: ");
		int codigo = reader.nextInt();

		itemCardapioDAO.deletar(itemCardapioDAO.getItemCardapio(codigo));
		System.out.println("Item excluído com sucesso!!!");

	}

	public void exibirItensAtivos() {

		System.out.println("Itens do Cardapio Ativos: ");
		System.out.println("\n");
		itens = itemCardapioDAO.listarTodosAtivos(ItemCardapio.class);
		for (ItemCardapio item : itens) {
			System.out.println("código: " + item.getSeqItem());
			System.out.println("nome: " + item.getNome());
			System.out.println("preço: " + item.getPreco());
			System.out.println("\n");
		}

	}

	public List<ItemCardapio> getItensAtivos() {

		System.out.println("Itens do Cardapio Ativos: ");
		System.out.println("\n");
		itens = itemCardapioDAO.listarTodosAtivos(ItemCardapio.class);

		return itens;

	}

	public ItemCardapio getItemByCodigo(int codigo) {

		return (ItemCardapio) itemCardapioDAO.getItemCardapio(codigo);

	}

}

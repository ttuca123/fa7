package br.edu.fa7.bean;

import java.util.Scanner;

import br.edu.fa7.dao.CargoDAO;
import br.edu.fa7.model.Cargo;

public class CargoBean {

	private Scanner reader = new Scanner(System.in);
	private CargoDAO cargoDAO = new CargoDAO();

	public void manterCargo() throws Exception {
		boolean sair = false;

		do {

			System.out
					.println("\n Por favor, digite a operação desejada para o Cargo:  \n");

			System.out.println("1 - Incluir cargo \n");
			System.out.println("2 - Listar todos os cargos \n");

			System.out.println("3 - Sair \n");

			System.out.println("Opção: ");
			int optItem = reader.nextInt();

			switch (optItem) {

			case 1:
				incluirCargo();
				break;

			case 2:
				listarCargos();
				break;

			case 3:
				sair = true;

				break;

			default:
				break;
			}

		} while (!sair);

	}

	public void listarCargos() {

		System.out.println("Cargos ");

		for (Cargo cargo : cargoDAO.getCargos()) {

			System.out.println("Nome: " + cargo.getNome());
			System.out.println("\n");
			System.out.println("Salário: " + cargo.getSalario());
			System.out.println("\n");
		}

	}

	private void incluirCargo() {

		System.out.println("Digite o nome do cargo: ");
		String nome = reader.next();
		System.out.println("Digite o salário ref. ao cargo: " + nome);
		Double salario = reader.nextDouble();
		cargoDAO.cadastrarCargo(new Cargo(nome, salario));

	}

	public Cargo getCargo() {

		System.out.println("Digite a descrição do cargo: \n");
		String descricao = reader.next();

		return cargoDAO.buscarCargo(descricao);

	}

}

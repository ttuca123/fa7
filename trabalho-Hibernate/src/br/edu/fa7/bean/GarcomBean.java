package br.edu.fa7.bean;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.edu.fa7.dao.GarcomDAO;
import br.edu.fa7.model.Cargo;
import br.edu.fa7.model.Garcom;
import br.edu.fa7.model.Mesa;

public class GarcomBean {

	private Scanner reader = new Scanner(System.in);
	private GarcomDAO garcomDAO = new GarcomDAO();
	private CargoBean cargoBean = new CargoBean();

	public void manterGarcom() throws Exception {
		boolean sair = false;

		do {

			System.out
					.println("\n Por favor, digite a operação desejada para o Garcom:  \n");

			System.out.println("1 - Listar todos os garçons \n");

			System.out.println("2 - Sair \n");

			System.out.println("Opção: ");
			int optItem = reader.nextInt();

			switch (optItem) {

			case 1:

				exibirGarcons();

				break;

			case 2:

				sair = true;
				break;
			default:
				break;
			}

		} while (!sair);

	}

	public Garcom getGarcom() {

		System.out.println("Digite matrícula do garçom: ");
		int matricula = reader.nextInt();

		return garcomDAO.buscarByMatricula(matricula);

	}

	public void exibirGarcons() {

		System.out.println("Garcons: ");
		System.out.println("\n");
		List<Garcom> garcons = garcomDAO.listarTodosAtivos(Garcom.class);
		for (Garcom garcom : garcons) {

			System.out.println("Matricula: " + garcom.getMatricula());
			System.out.println("Nome: " + garcom.getNome());
			System.out.println("\n");
		}

		System.out.println("total: " + garcons.size());

	}

}

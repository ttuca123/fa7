package br.edu.fa7.main;

import org.apache.commons.lang.math.RandomUtils;

import br.edu.fa7.dao.CargoDAO;
import br.edu.fa7.dao.GarcomDAO;
import br.edu.fa7.dao.ItemCardapioDAO;
import br.edu.fa7.dao.MesaDAO;
import br.edu.fa7.factory.HibernateFactory;
import br.edu.fa7.model.Cargo;
import br.edu.fa7.model.Garcom;
import br.edu.fa7.model.ItemCardapio;
import br.edu.fa7.model.Mesa;

public class CargaTabelas {

	public static void main(String[] args) throws Exception {

		HibernateFactory.getHibernateSession();
	
		realizarCarga();
	}

	private static void realizarCarga() {

		MesaDAO mesaDAO = new MesaDAO();
		GarcomDAO garcomDAO = new GarcomDAO();

		CargoDAO cargoDAO = new CargoDAO();

		Cargo cargoGarcom = new Cargo("GARCOM", 1000.00);
		cargoDAO.salvar(cargoGarcom);
		cargoDAO.salvar(new Cargo("COZINHEIRO", 1300.00));
		cargoDAO.salvar(new Cargo("GERENTE", 3000.00));
		cargoGarcom = cargoDAO.buscarCargo("GARCOM");
		for (int i = 0; i < 30; i++) {
			mesaDAO.cadastrarMesa(new Mesa());
		}

		ItemCardapioDAO itemCardapioDAO = new ItemCardapioDAO();
		for (int i = 0; i < 10; i++) {
			itemCardapioDAO.salvar(new ItemCardapio("item" + i, (i + 4.0)));

		}

		for (int i = 0; i < 10; i++) {

			garcomDAO.salvar(new Garcom("garcom " + (i + 1), RandomUtils
					.nextLong(), cargoGarcom));
		}

	}
}
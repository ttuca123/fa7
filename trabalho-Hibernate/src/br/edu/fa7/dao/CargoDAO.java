package br.edu.fa7.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import br.edu.fa7.model.Cargo;

public class CargoDAO extends GenericDao<Cargo> {

	public CargoDAO() {
		super();

	}

	public void cadastrarCargo(Cargo cargo) {

		super.salvar(cargo);
	}

	public List<Cargo> getCargos() {

		return listar(Cargo.class, new ArrayList<Criterion>());
	}

	public Cargo buscarCargo(String nome) {

		List<Criterion> restricoes = new ArrayList<>();
		restricoes.add(Restrictions.eq("nome", nome));

		Cargo cargo = (Cargo) getObject(Cargo.class, restricoes);

		return cargo;

	}

}

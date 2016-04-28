package br.edu.fa7.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import br.edu.fa7.model.Garcom;

public class GarcomDAO extends GenericDao<Garcom> {

	public GarcomDAO() {
		super();

	}

	public void cadastrarGarcom(Garcom garcom) throws Exception {

		super.salvar(garcom);
	}

	public Garcom buscarByMatricula(int matricula) {

		List<Criterion> restricoes = new ArrayList<>();
		restricoes.add(Restrictions.eq("matricula", matricula));
		restricoes.add(Restrictions.eq("heAtivo", true));

		Garcom garcom = (Garcom) getObject(Garcom.class, restricoes);

		return garcom;

	}

}

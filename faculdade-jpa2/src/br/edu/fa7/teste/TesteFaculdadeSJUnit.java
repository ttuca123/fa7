package br.edu.fa7.teste;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.edu.fa7.model.Aluno;
import br.edu.fa7.model.Curso;
import br.edu.fa7.model.Disciplina;
import br.edu.fa7.model.Faculdade;
import br.edu.fa7.model.Matricula;
import br.edu.fa7.model.Pessoa;
import br.edu.fa7.model.Professor;
import br.edu.fa7.model.ProfessorDisciplina;
import br.edu.fa7.util.Horario;

public class TesteFaculdadeSJUnit {

	private static EntityManager em = null;

	public static void main(String[] args) {

		em = (EntityManager) Persistence.createEntityManagerFactory(
				"unidadePersistencia").createEntityManager();

		// Inicia uma transação
		em.getTransaction().begin();

		javax.persistence.Query query = em.createNamedQuery("Aluno.findAll");

		List<Aluno> alunos = query.getResultList();

		// ------------ Cria o primeiro Aluno ---------
		Aluno a1 = new Aluno();
		a1.setNome("João");

		Calendar dt = Calendar.getInstance();

		dt.set(Calendar.YEAR, 1983);
		dt.set(Calendar.MONTH, Calendar.AUGUST);
		dt.set(Calendar.DAY_OF_MONTH, 11);

		a1.setDataNascimento(dt.getTime());
		a1.setMatricula("22222");
		a1.setCpf("123456");

		em.persist(a1);
		em.flush();

		Aluno a2 = new Aluno();

		a2.setNome("Pedro");

		dt = Calendar.getInstance();

		dt.set(Calendar.YEAR, 1992);
		dt.set(Calendar.MONTH, Calendar.JANUARY);
		dt.set(Calendar.DAY_OF_MONTH, 3);

		a2.setDataNascimento(dt.getTime());
		a2.setMatricula("11111");
		a2.setCpf("1234");

		em.persist(a2);
		em.flush();

		Professor p = new Professor();

		p.setNome("Lucas");

		dt = Calendar.getInstance();

		dt.set(Calendar.YEAR, 1972);
		dt.set(Calendar.MONTH, Calendar.JANUARY);
		dt.set(Calendar.DAY_OF_MONTH, 3);

		p.setDataNascimento(dt.getTime());
		p.setTitulacao("Doutor");
		p.setCpf("232313");

		em.persist(p);
		em.flush();

		Faculdade f = new Faculdade();
		f.setNome("FA7");

		em.persist(f);
		em.flush();

		Curso c = new Curso();
		c.setCargaHoraria(400);
		c.setNome("Computação");
		c.setFaculdade(f);

		em.persist(c);
		em.flush();

		Curso c2 = new Curso();
		c2.setCargaHoraria(200);
		c2.setNome("Direito");
		c2.setFaculdade(f);

		em.persist(c2);
		em.flush();

		Disciplina d = new Disciplina();
		d.setNome("Direito constitucional");
		d.setCargaHoraria(20);

		em.persist(d);
		em.flush();

		Disciplina d2 = new Disciplina();
		d2.setNome("IA");
		d2.setCargaHoraria(60);

		em.persist(d2);
		em.flush();

		Disciplina d3 = new Disciplina();
		d3.setNome("Lógica de Programação");
		d3.setCargaHoraria(40);

		em.persist(d3);
		em.flush();

		Disciplina d4 = new Disciplina();
		d4.setNome("Cálculo");
		d4.setCargaHoraria(40);

		c.setDisciplinas(new HashSet<Disciplina>());
		c.getDisciplinas().add(d2);
		c.getDisciplinas().add(d3);
		c.getDisciplinas().add(d4);

		em.persist(c);
		em.flush();

		c2.setDisciplinas(new HashSet<Disciplina>());
		c2.getDisciplinas().add(d);

		em.persist(c2);
		em.flush();

		ProfessorDisciplina pd = new ProfessorDisciplina();

		pd.setDisciplina(d3);
		pd.setHorario(Horario.ManhaAB);
		pd.setProfessor(p);

		em.persist(pd);
		em.flush();

		Matricula m = new Matricula();

		m.setAluno(a1);
		m.setAnoPeriodo("2014/1");
		m.setProfessorDisciplina(pd);

		em.persist(m);
		em.flush();

		m = new Matricula();

		m.setAluno(a2);
		m.setAnoPeriodo("2014/1");
		m.setProfessorDisciplina(pd);

		em.persist(m);
		em.flush();

		em.getTransaction().commit();

	}
}

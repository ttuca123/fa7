/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.fa7.model;


import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

 // Curso Entity Bean*
 //	@author Carlos Caminha

@Entity
@Table(name = "matricula")
public class Matricula implements Serializable {	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3807549913811041745L;

	@Column(name = "nota")
    @Basic(optional = true)
    private Float nota;
	
	@Column(name = "percentual_frequencia")
    @Basic(optional = true)
    private Float percentualFrequencia;
   
	@Id
    @Column(name = "ano_periodo")
    @Basic(optional = false)
    private String anoPeriodo;
    
	@Id
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_aluno",nullable = false)    
	private Aluno aluno;
    
	@Id
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_professor_disciplina",nullable = false)    
	private ProfessorDisciplina professorDisciplina;
    
    public Matricula() {
    
    }

	public Float getNota() {
		return nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}

	public Float getPercentualFrequencia() {
		return percentualFrequencia;
	}

	public void setPercentualFrequencia(Float percentualFrequencia) {
		this.percentualFrequencia = percentualFrequencia;
	}

	public String getAnoPeriodo() {
		return anoPeriodo;
	}

	public void setAnoPeriodo(String anoPeriodo) {
		this.anoPeriodo = anoPeriodo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public ProfessorDisciplina getProfessorDisciplina() {
		return professorDisciplina;
	}

	public void setProfessorDisciplina(ProfessorDisciplina professorDisciplina) {
		this.professorDisciplina = professorDisciplina;
	}	

}
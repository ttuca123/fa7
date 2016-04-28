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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.edu.fa7.util.Horario;

 // Curso Entity Bean*
 //	@author Carlos Caminha

@Entity
@Table(name = "professor_disciplina",
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"id_professor", "horario"})
	)
@SequenceGenerator(name="SEQUENCE", sequenceName="professor_disciplina_id_seq")
public class ProfessorDisciplina implements Serializable {	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5043758660978789210L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
    @Column(name = "id")
    private Integer id;
	
	@Column(name = "horario")
    @Basic(optional = false)
    private Horario horario; 
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_disciplina",nullable = false)    
	private Disciplina disciplina;
      
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_professor",nullable = false)    
	private Professor professor;
    
    public ProfessorDisciplina() {
    
    }   
    
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
}
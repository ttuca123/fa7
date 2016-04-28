/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.fa7.model;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

 // Curso Entity Bean*
 //	@author Carlos Caminha

@Entity
@Table(name = "curso")
@SequenceGenerator(name="SEQUENCE", sequenceName="curso_id_seq")
public class Curso implements Serializable {	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1018728617078842215L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    @Basic(optional = false)
    private String nome;

    @Column(name = "carga_horaria")
    @Basic(optional = false)
    private Integer cargaHoraria;    
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_faculdade",nullable = false)    
	private Faculdade faculdade;
    
    @ManyToMany(
	   fetch = FetchType.LAZY,	
	   targetEntity=br.edu.fa7.model.Disciplina.class,
	   cascade={CascadeType.PERSIST, CascadeType.MERGE}
	)
	@JoinTable(
	   name="curso_disciplina",
	   joinColumns=@JoinColumn(name="id_curso"),
	   inverseJoinColumns=@JoinColumn(name="id_disciplina")	   
	)
	@OrderBy("nome")
	private Set<Disciplina> disciplinas;

    public Curso() {
    
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public Faculdade getFaculdade() {
		return faculdade;
	}

	public void setFaculdade(Faculdade faculdade) {
		this.faculdade = faculdade;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
    
}
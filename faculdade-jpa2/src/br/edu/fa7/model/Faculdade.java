/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.fa7.model;


import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

 // Universidade Entity Bean*
 //	@author Carlos Caminha

@Entity
@Table(name = "faculdade")
@SequenceGenerator(name="SEQUENCE", sequenceName="faculdade_id_seq")
public class Faculdade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3455061920363969488L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome",length=60)
    @Basic(optional = false)
    private String nome;
       

    public Faculdade() {
    
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
    
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.fa7.model;


import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

 // Aluno Entity Bean*
 //	@author Carlos Caminha


@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name="id_pessoa")
@NamedQueries({
	@NamedQuery(name="Aluno.findAll", query ="Select a from Aluno a")
})
public class Aluno extends Pessoa implements Serializable {   

    /**
	 * 
	 */
	private static final long serialVersionUID = 4279431468009488851L;
	
	@Column(name = "matricula")
    @Basic(optional = false)
    private String matricula;

    public Aluno() {
    
    }

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}	
    
}
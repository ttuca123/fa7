/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.fa7.model;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

 // Pessoa Entity Bean*
 //	@author Carlos Caminha

@Entity
@Table(name = "pessoa")
@SequenceGenerator(name="SEQUENCE", sequenceName="pessoa_id_seq")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6563846797910943364L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
    @Column(name = "id")
    protected Integer id;

    @Column(name = "nome")
    @Basic(optional = false)
    protected String nome;
    
    @Transient
    protected Integer idade;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    @Basic(optional = false)
    protected Date dataNascimento;
    
    @Column(name = "cpf")
    @Basic(optional = false)
    protected String cpf;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_registro")
    @Basic(optional = false)
    protected Date dataRegistro;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_alteracao")
    @Basic(optional = true)
    protected Date dataAlteracao;   

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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	
	@PostLoad
    public void calculateAge() {
        Calendar birth = new GregorianCalendar();
        birth.setTime(dataNascimento);
        Calendar now = new GregorianCalendar();
        now.setTime( new Date() );
        int adjust = 0;
        if ( now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR) < 0) {
            adjust = -1;
        }
        idade = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + adjust;
    }
	
	@PrePersist
	public void atualizaDataRegistro() {
		this.setDataRegistro(new Date());
	}

	@PreUpdate
	public void atualizaDataAtualizacao() {
		this.setDataAlteracao(new Date());
	}
    
}
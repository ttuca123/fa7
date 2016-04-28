package br.edu.fa7.model;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.apache.commons.beanutils.BeanUtils;

@MappedSuperclass
public abstract class BaseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7736710221797500486L;
	
	@Column(nullable=false, name="he_ativo")
	protected Boolean heAtivo = true;

	public Boolean getEstaAtivo() {
		return heAtivo;
	}

	public void setEstaAtivo(Boolean estaAtivo) {
		this.heAtivo = estaAtivo;
	}
	
	@Override
	public Object clone() {
		try {
			Object obj = new Object();
			BeanUtils.copyProperties(obj, this);
			return obj;
		} catch (IllegalAccessException e) {
			return null;
		} catch (InvocationTargetException e) {
			return null;
		}
	}
	
}

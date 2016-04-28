package br.com.trabalho.jsf.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.trabalho.jsf.business.UsuarioBusiness;
import br.com.trabalho.jsf.business.UsuarioInvalidoException;
import br.com.trabalho.jsf.model.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {

	@ManagedProperty("#{usuarioBusiness}")
	private UsuarioBusiness usuarioBusiness;

	private Usuario usuarioAutenticado;

	private String log;

	private String password;

	public UsuarioBusiness getUsuarioBusiness() {
		return usuarioBusiness;
	}

	public void setUsuarioBusiness(UsuarioBusiness usuarioBusiness) {
		this.usuarioBusiness = usuarioBusiness;
	}

	public Usuario getUsuarioAutenticado() {
		return usuarioAutenticado;
	}

	public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
		this.usuarioAutenticado = usuarioAutenticado;
	}

	public String getCpf() {
		return log;
	}

	public void setCpf(String cpf) {
		this.log = cpf;
	}

	public String getSenha() {
		return password;
	}

	public void setSenha(String senha) {
		this.password = senha;
	}

	public String autenticar() {
		try {

			usuarioAutenticado = usuarioBusiness.autenticarUsuario(log, password);
			return "index?faces-redirect=true";
		} catch (UsuarioInvalidoException e) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setDetail("Usu�rio ou senha inv�lidos!");
			FacesContext.getCurrentInstance().addMessage("loginForm", message);
			return null;
		} finally {
			log = null;
			password = null;
		}
	}
}
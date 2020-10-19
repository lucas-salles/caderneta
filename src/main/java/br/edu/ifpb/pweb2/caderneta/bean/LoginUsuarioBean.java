package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.UsuarioController;
import br.edu.ifpb.pweb2.caderneta.model.Usuario;

@Named(value = "loginUsuarioBean")
@SessionScoped
public class LoginUsuarioBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String senha;
	private Boolean isLogged = false;
	
	@Inject
	@Named("usuario")
	private Usuario usuario;
	
	@Inject
	private UsuarioController usuarioController;

	
	public String valide() {
		Usuario u = usuarioController.findByLoginAndPassword(login, senha);
		
		if(u != null) {
			usuario = u;
			isLogged = true;
			return "/home?faces-redirect=true";
		}
		
		this.addInfoMessage("Usuário não encontrado");
		
		
		return null;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Boolean getIsLogged() {
		return isLogged;
	}


	public void setIsLogged(Boolean isLogged) {
		this.isLogged = isLogged;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}

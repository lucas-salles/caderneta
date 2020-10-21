package br.edu.ifpb.pweb2.caderneta.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.caderneta.controller.UsuarioController;
import br.edu.ifpb.pweb2.caderneta.model.Aluno;
import br.edu.ifpb.pweb2.caderneta.model.Coordenador;
import br.edu.ifpb.pweb2.caderneta.model.Professor;
import br.edu.ifpb.pweb2.caderneta.model.Usuario;

@Named(value = "loginUsuarioBean")
@SessionScoped
public class LoginUsuarioBean extends GenericCadernetaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String senha;
	
	@Inject
	private Aluno aluno;
	
	@Inject
	@Named("professor")
	private Professor professor;
	
	@Inject
	private Coordenador coordenador;
	
	@Inject
	private UsuarioController usuarioController;

	
	public String valide() {
		Usuario u = usuarioController.findByLoginAndPassword(login, senha);
		
		if(u != null) {
			if(u.getTipo().equals("Coordenador")) {
				coordenador = (Coordenador) u;
				return "/coordenador/home?faces-redirect=true";
			} else if(u.getTipo().equals("Professor")) {
				professor = (Professor) u;
				return "/professor/home?faces-redirect=true";
			} else {
				aluno = (Aluno) u;
				return "/aluno/home?faces-redirect=true";
			}
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


	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	public Professor getProfessor() {
		return professor;
	}


	public void setProfessor(Professor professor) {
		this.professor = professor;
	}


	public Coordenador getCoordenador() {
		return coordenador;
	}


	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}
}

package br.edu.ifpb.pweb2.caderneta.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Professor extends Usuario {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String email;
	
	@ManyToMany
	private List<Turma> turmas;
	
	public Professor() {}
	
	public Professor(String login, String senha, String tipo, String nome, String email) {
		super(login, senha, tipo);
		this.nome = nome;
		this.email = email;
	}
	
	public void add(Turma t) {
		turmas.add(t);
	}
	
	public void remover(Turma t) {
		turmas.remove(t);
	}
	
	public Turma localizarTurma(int id) {
		for(Turma t : turmas) {
			if(t.getId() == id)
				return t;
		}
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	@Override
	public String toString() {
		return "Professor [nome=" + nome + ", email=" + email + "]";
	}
}

package br.edu.ifpb.pweb2.caderneta.model;

import javax.persistence.Entity;

@Entity
public class Professor extends Usuario {
	private String nome;
	private String email;
	
	public Professor() {}
	
	public Professor(String login, String senha, String nome, String email) {
		super(login, senha);
		this.nome = nome;
		this.email = email;
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

	@Override
	public String toString() {
		return "Professor [nome=" + nome + ", email=" + email + "]";
	}
}

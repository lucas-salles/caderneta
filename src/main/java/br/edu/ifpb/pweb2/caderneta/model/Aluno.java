package br.edu.ifpb.pweb2.caderneta.model;

import javax.persistence.Entity;

@Entity
public class Aluno extends Usuario {
	private String nome;
	private String matricula;
	
	public Aluno() {}
	
	public Aluno(String login, String senha, String nome, String matricula) {
		super(login, senha);
		this.nome = nome;
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", matricula=" + matricula + "]";
	}
}

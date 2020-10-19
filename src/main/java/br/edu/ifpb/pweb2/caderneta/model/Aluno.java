package br.edu.ifpb.pweb2.caderneta.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Aluno extends Usuario {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String matricula;
	
	@ManyToOne
	private Turma turma;
	
	public Aluno() {}
	
	public Aluno(String login, String senha, String tipo, String nome, String matricula) {
		super(login, senha, tipo);
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

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", matricula=" + matricula + "]";
	}
}
